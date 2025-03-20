package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerMaintenanceStatusController {

    CustomerMaintenanceStatusService customerMaintenanceStatusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerMaintenanceStatusService.list(params), model:[customerMaintenanceStatusCount: customerMaintenanceStatusService.count()]
    }

    def show(Long id) {
        respond customerMaintenanceStatusService.get(id)
    }

    def create() {
        respond new CustomerMaintenanceStatus(params)
    }

    def save(CustomerMaintenanceStatus customerMaintenanceStatus) {
        if (customerMaintenanceStatus == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceStatusService.save(customerMaintenanceStatus)
        } catch (ValidationException e) {
            respond customerMaintenanceStatus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), customerMaintenanceStatus.id])
                redirect customerMaintenanceStatus
            }
            '*' { respond customerMaintenanceStatus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerMaintenanceStatusService.get(id)
    }

    def update(CustomerMaintenanceStatus customerMaintenanceStatus) {
        if (customerMaintenanceStatus == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceStatusService.save(customerMaintenanceStatus)
        } catch (ValidationException e) {
            respond customerMaintenanceStatus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), customerMaintenanceStatus.id])
                redirect customerMaintenanceStatus
            }
            '*'{ respond customerMaintenanceStatus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerMaintenanceStatusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceStatus.label', default: 'CustomerMaintenanceStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
