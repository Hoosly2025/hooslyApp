package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerMaintenanceRatingController {

    CustomerMaintenanceRatingService customerMaintenanceRatingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerMaintenanceRatingService.list(params), model:[customerMaintenanceRatingCount: customerMaintenanceRatingService.count()]
    }

    def show(Long id) {
        respond customerMaintenanceRatingService.get(id)
    }

    def create() {
        respond new CustomerMaintenanceRating(params)
    }

    def save(CustomerMaintenanceRating customerMaintenanceRating) {
        if (customerMaintenanceRating == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceRatingService.save(customerMaintenanceRating)
        } catch (ValidationException e) {
            respond customerMaintenanceRating.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), customerMaintenanceRating.id])
                redirect customerMaintenanceRating
            }
            '*' { respond customerMaintenanceRating, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerMaintenanceRatingService.get(id)
    }

    def update(CustomerMaintenanceRating customerMaintenanceRating) {
        if (customerMaintenanceRating == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceRatingService.save(customerMaintenanceRating)
        } catch (ValidationException e) {
            respond customerMaintenanceRating.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), customerMaintenanceRating.id])
                redirect customerMaintenanceRating
            }
            '*'{ respond customerMaintenanceRating, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerMaintenanceRatingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceRating.label', default: 'CustomerMaintenanceRating'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
