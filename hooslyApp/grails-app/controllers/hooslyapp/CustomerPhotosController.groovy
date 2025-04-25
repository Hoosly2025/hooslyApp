package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_CUSTOMER'])
class CustomerPhotosController {

    CustomerPhotosService customerPhotosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def customerPhotosList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[customerPhotosList: customerPhotosService.list(params), customerPhotosCount: customerPhotosService.count()]
                } else {
					def userId = userDetails.id
					customerPhotosList = CustomerPhotos.findAllByCustomer(userId)
					def customerPhotosCount = 0
					
					if (customerPhotosList != null && customerPhotosList.size() > 0) {
						customerPhotosCount = customerPhotosList.size()
					}
					respond userDetails, model:[customerPhotosList: customerPhotosList, customerPhotosCount: customerPhotosCount]
				}
	        
    	}

    }

    def show(Long id) {
        respond customerPhotosService.get(id)
    }

    def create() {
        respond new CustomerPhotos(params)
    }

    def save(CustomerPhotos customerPhotos) {
        if (customerPhotos == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				customerPhotos.filename = transferFile.getOriginalFilename()
				customerPhotos.fileUpload = transferFile.getBytes()
			}
            customerPhotosService.save(customerPhotos)
        } catch (ValidationException e) {
            respond customerPhotos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), customerPhotos.id])
                redirect customerPhotos
            }
            '*' { respond customerPhotos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerPhotosService.get(id)
    }

    def update(CustomerPhotos customerPhotos) {
        if (customerPhotos == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				customerPhotos.filename = transferFile.getOriginalFilename()
				customerPhotos.fileUpload = transferFile.getBytes()
			}
            customerPhotosService.save(customerPhotos)
        } catch (ValidationException e) {
            respond customerPhotos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), customerPhotos.id])
                redirect customerPhotos
            }
            '*'{ respond customerPhotos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerPhotosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
