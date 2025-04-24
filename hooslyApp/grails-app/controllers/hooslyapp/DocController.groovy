package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class DocController {

    DocService docService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def docList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[docList: docService.list(params), docCount: docService.count()]
                } else {
					def userId = userDetails.id
					docList = Doc.findAllByUser(userId)
					def docCount = 0
					
					if (docList != null && docList.size() > 0) {
						docCount = docList.size()
					}
					respond userDetails, model:[docList: docList, docCount: docCount]
				}
	        
    	}

    }


    def show(Long id) {
        respond docService.get(id)
    }

    def create() {
        respond new Doc(params)
    }

    def save(Doc doc) {
        if (doc == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				doc.filename = transferFile.getOriginalFilename()
				doc.fileUpload = transferFile.getBytes()
			}
            docService.save(doc)
        } catch (ValidationException e) {
            respond doc.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'doc.label', default: 'Doc'), doc.id])
                redirect doc
            }
            '*' { respond doc, [status: CREATED] }
        }
    }

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		Doc docInstance = docService.get(id)
		if ( docInstance == null) {
			flash.message = "Doc not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${docInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << docInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
    def edit(Long id) {
        respond docService.get(id)
    }

    def update(Doc doc) {
        if (doc == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				doc.filename = transferFile.getOriginalFilename()
				doc.fileUpload = transferFile.getBytes()
			}
            docService.save(doc)
        } catch (ValidationException e) {
            respond doc.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'doc.label', default: 'Doc'), doc.id])
                redirect doc
            }
            '*'{ respond doc, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        docService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'doc.label', default: 'Doc'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'doc.label', default: 'Doc'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
