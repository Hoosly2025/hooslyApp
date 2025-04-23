package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorLicensesController {

    VendorLicensesService vendorLicensesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def vendorLicensesList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[vendorLicensesList: vendorLicensesService.list(params), vendorLicensesCount: vendorLicensesService.count()]
                } else {
					def userId = userDetails.id
					vendorLicensesList = VendorLicenses.findAllByVendor(userId)
					def vendorLicensesCount = 0
					
					if (vendorLicensesList != null && vendorLicensesList.size() > 0) {
						vendorLicensesCount = vendorLicensesList.size()
					}
					respond userDetails, model:[vendorLicensesList: vendorLicensesList, vendorLicensesCount: vendorLicensesCount]
				}
	        
    	}

    }


    def show(Long id) {
        respond vendorLicensesService.get(id)
    }

    def create() {
        respond new VendorLicenses(params)
    }

    def save(VendorLicenses vendorLicenses) {
        if (vendorLicenses == null) {
            notFound()
            return
        }

        try {
            def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				vendorLicenses.filename = transferFile.getOriginalFilename()
				vendorLicenses.fileUpload = transferFile.getBytes()
			}
			vendorLicensesService.save(vendorLicenses)
            
        } catch (ValidationException e) {
            respond vendorLicenses.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), vendorLicenses.id])
                redirect vendorLicenses
            }
            '*' { respond vendorLicenses, [status: CREATED] }
        }
    }

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		VendorLicenses vendorLicensesInstance = vendorLicensesService.get(id)
		if ( vendorLicensesInstance == null) {
			flash.message = "Vendor Licenses not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${vendorLicensesInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << vendorLicensesInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
    def edit(Long id) {
        respond vendorLicensesService.get(id)
    }

    def update(VendorLicenses vendorLicenses) {
        if (vendorLicenses == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				vendorLicenses.filename = transferFile.getOriginalFilename()
				vendorLicenses.fileUpload = transferFile.getBytes()
			}
            vendorLicensesService.save(vendorLicenses)
        } catch (ValidationException e) {
            respond vendorLicenses.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), vendorLicenses.id])
                redirect vendorLicenses
            }
            '*'{ respond vendorLicenses, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorLicensesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
