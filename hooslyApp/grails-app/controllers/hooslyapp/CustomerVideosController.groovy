package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_CUSTOMER'])
class CustomerVideosController {

    CustomerVideosService customerVideosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def customerVideosList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[customerVideosList: customerVideosService.list(params), customerVideosCount: customerVideosService.count()]
                } else {
					def userId = userDetails.id
					customerVideosList = CustomerVideos.findAllByCustomer(userId)
					def customerVideosCount = 0
					
					if (customerVideosList != null && customerVideosList.size() > 0) {
						customerVideosCount = customerVideosList.size()
					}
					respond userDetails, model:[customerVideosList: customerVideosList, customerVideosCount: customerVideosCount]
				}
	        
    	}

    }

    def show(Long id) {
        respond customerVideosService.get(id)
    }

    def create() {
        respond new CustomerVideos(params)
    }

    def save(CustomerVideos customerVideos) {
        if (customerVideos == null) {
            notFound()
            return
        }

        try {
            customerVideosService.save(customerVideos)
        } catch (ValidationException e) {
            respond customerVideos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerVideos.label', default: 'CustomerVideos'), customerVideos.id])
                redirect customerVideos
            }
            '*' { respond customerVideos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerVideosService.get(id)
    }

    def update(CustomerVideos customerVideos) {
        if (customerVideos == null) {
            notFound()
            return
        }

        try {
            customerVideosService.save(customerVideos)
        } catch (ValidationException e) {
            respond customerVideos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerVideos.label', default: 'CustomerVideos'), customerVideos.id])
                redirect customerVideos
            }
            '*'{ respond customerVideos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerVideosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerVideos.label', default: 'CustomerVideos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerVideos.label', default: 'CustomerVideos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
