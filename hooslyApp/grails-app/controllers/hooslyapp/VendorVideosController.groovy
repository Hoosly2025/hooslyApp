package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorVideosController {

    VendorVideosService vendorVideosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def vendorVideosList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[vendorVideosList: vendorVideosService.list(params), vendorVideosCount: vendorVideosService.count()]
                } else {
					def userId = userDetails.id
					vendorVideosList = VendorVideos.findAllByVendor(userId)
					def vendorVideosCount = 0
					
					if (vendorVideosList != null && vendorVideosList.size() > 0) {
						vendorVideosCount = vendorVideosList.size()
					}
					respond userDetails, model:[vendorVideosList: vendorVideosList, vendorVideosCount: vendorVideosCount]
				}
	        
    	}

    }


    def show(Long id) {
        respond vendorVideosService.get(id)
    }

    def create() {
        respond new VendorVideos(params)
    }

    def save(VendorVideos vendorVideos) {
        if (vendorVideos == null) {
            notFound()
            return
        }

        try {
            vendorVideosService.save(vendorVideos)
        } catch (ValidationException e) {
            respond vendorVideos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorVideos.label', default: 'VendorVideos'), vendorVideos.id])
                redirect vendorVideos
            }
            '*' { respond vendorVideos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorVideosService.get(id)
    }

    def update(VendorVideos vendorVideos) {
        if (vendorVideos == null) {
            notFound()
            return
        }

        try {
            vendorVideosService.save(vendorVideos)
        } catch (ValidationException e) {
            respond vendorVideos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorVideos.label', default: 'VendorVideos'), vendorVideos.id])
                redirect vendorVideos
            }
            '*'{ respond vendorVideos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorVideosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorVideos.label', default: 'VendorVideos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorVideos.label', default: 'VendorVideos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
