package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerMaintenanceTypeController {

    CustomerMaintenanceTypeService customerMaintenanceTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerMaintenanceTypeService.list(params), model:[customerMaintenanceTypeCount: customerMaintenanceTypeService.count()]
    }

    def show(Long id) {
        respond customerMaintenanceTypeService.get(id)
    }

    def create() {
        respond new CustomerMaintenanceType(params)
    }

    def save(CustomerMaintenanceType customerMaintenanceType) {
        if (customerMaintenanceType == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceTypeService.save(customerMaintenanceType)
        } catch (ValidationException e) {
            respond customerMaintenanceType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), customerMaintenanceType.id])
                redirect customerMaintenanceType
            }
            '*' { respond customerMaintenanceType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerMaintenanceTypeService.get(id)
    }

    def update(CustomerMaintenanceType customerMaintenanceType) {
        if (customerMaintenanceType == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceTypeService.save(customerMaintenanceType)
        } catch (ValidationException e) {
            respond customerMaintenanceType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), customerMaintenanceType.id])
                redirect customerMaintenanceType
            }
            '*'{ respond customerMaintenanceType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerMaintenanceTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceType.label', default: 'CustomerMaintenanceType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
