package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_VENDOR'])
class VendorPhotosController {

    VendorPhotosService vendorPhotosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def vendorPhotosList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[vendorPhotosList: vendorPhotosService.list(params), vendorPhotosCount: vendorPhotosService.count()]
                } else {
					def userId = userDetails.id
					vendorPhotosList = VendorPhotos.findAllByVendor(userId)
					def vendorPhotosCount = 0
					
					if (vendorPhotosList != null && vendorPhotosList.size() > 0) {
						vendorPhotosCount = vendorPhotosList.size()
					}
					respond userDetails, model:[vendorPhotosList: vendorPhotosList, vendorPhotosCount: vendorPhotosCount]
				}
	        
    	}

    }

    def show(Long id) {
        respond vendorPhotosService.get(id)
    }

    def create() {
        respond new VendorPhotos(params)
    }

    def save(VendorPhotos vendorPhotos) {
        if (vendorPhotos == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				vendorPhotos.filename = transferFile.getOriginalFilename()
				vendorPhotos.fileUpload = transferFile.getBytes()
			}
            vendorPhotosService.save(vendorPhotos)
        } catch (ValidationException e) {
            respond vendorPhotos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorPhotos.label', default: 'VendorPhotos'), vendorPhotos.id])
                redirect vendorPhotos
            }
            '*' { respond vendorPhotos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorPhotosService.get(id)
    }

    def update(VendorPhotos vendorPhotos) {
        if (vendorPhotos == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				vendorPhotos.filename = transferFile.getOriginalFilename()
				vendorPhotos.fileUpload = transferFile.getBytes()
			}
            vendorPhotosService.save(vendorPhotos)
        } catch (ValidationException e) {
            respond vendorPhotos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorPhotos.label', default: 'VendorPhotos'), vendorPhotos.id])
                redirect vendorPhotos
            }
            '*'{ respond vendorPhotos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorPhotosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorPhotos.label', default: 'VendorPhotos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorPhotos.label', default: 'VendorPhotos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
