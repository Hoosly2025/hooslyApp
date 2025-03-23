package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerMaintenanceController {

    CustomerMaintenanceService customerMaintenanceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerMaintenanceService.list(params), model:[customerMaintenanceCount: customerMaintenanceService.count()]
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
