package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_CUSTOMER'])
class CustomerMaintenanceController {

    CustomerMaintenanceService customerMaintenanceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
		
		params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def customerMaintenanceList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[customerMaintenanceList: customerMaintenanceService.list(params), customerMaintenanceCount: customerMaintenanceService.count()]
                } else {
					def userId = userDetails.id
					customerMaintenanceList = CustomerMaintenance.findAllByCustomerOnboarding(userId)
					def customerMaintenanceCount = 0
					
					if (customerMaintenanceList != null && customerMaintenanceList.size() > 0) {
						customerMaintenanceCount = customerMaintenanceList.size()
					}
					respond userDetails, model:[customerMaintenanceList: customerMaintenanceList, customerMaintenanceCount: customerMaintenanceCount]
				}
	        
    	}
    }

    def show(Long id) {
        respond customerMaintenanceService.get(id)
    }

    def create() {
        respond new CustomerMaintenance(params)
    }

    def save(CustomerMaintenance customerMaintenance) {
        if (customerMaintenance == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceService.save(customerMaintenance)
        } catch (ValidationException e) {
            respond customerMaintenance.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenance.label', default: 'CustomerMaintenance'), customerMaintenance.id])
                redirect customerMaintenance
            }
            '*' { respond customerMaintenance, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerMaintenanceService.get(id)
    }

    def update(CustomerMaintenance customerMaintenance) {
        if (customerMaintenance == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceService.save(customerMaintenance)
        } catch (ValidationException e) {
            respond customerMaintenance.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenance.label', default: 'CustomerMaintenance'), customerMaintenance.id])
                redirect customerMaintenance
            }
            '*'{ respond customerMaintenance, [status: OK] }
        }
    }

	@Secured(['ROLE_ADMIN'])
	def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerMaintenanceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenance.label', default: 'CustomerMaintenance'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenance.label', default: 'CustomerMaintenance'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
