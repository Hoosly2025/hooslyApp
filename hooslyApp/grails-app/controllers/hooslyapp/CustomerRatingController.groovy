package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerRatingController {

    CustomerRatingService customerRatingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerRatingService.list(params), model:[customerRatingCount: customerRatingService.count()]
    }

    def show(Long id) {
        respond customerRatingService.get(id)
    }

    def create() {
        respond new CustomerRating(params)
    }

    def save(CustomerRating customerRating) {
        if (customerRating == null) {
            notFound()
            return
        }

        try {
            customerRatingService.save(customerRating)
        } catch (ValidationException e) {
            respond customerRating.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerRating.label', default: 'CustomerRating'), customerRating.id])
                redirect customerRating
            }
            '*' { respond customerRating, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerRatingService.get(id)
    }

    def update(CustomerRating customerRating) {
        if (customerRating == null) {
            notFound()
            return
        }

        try {
            customerRatingService.save(customerRating)
        } catch (ValidationException e) {
            respond customerRating.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerRating.label', default: 'CustomerRating'), customerRating.id])
                redirect customerRating
            }
            '*'{ respond customerRating, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerRatingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerRating.label', default: 'CustomerRating'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerRating.label', default: 'CustomerRating'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
