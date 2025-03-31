package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerSubscriptionController {

    CustomerSubscriptionService customerSubscriptionService
    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerSubscriptionService.list(params), model:[customerSubscriptionCount: customerSubscriptionService.count()]
    }

    def show(Long id) {
        respond customerSubscriptionService.get(id)
    }

    def create() {
		def user = springSecurityService.currentUser
		respond new CustomerSubscription(params), model:[user: user]
    }

    def save(CustomerSubscription customerSubscription) {
        if (customerSubscription == null) {
            notFound()
            return
        }

        try {
            customerSubscriptionService.save(customerSubscription)
        } catch (ValidationException e) {
            respond customerSubscription.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSubscription.label', default: 'CustomerSubscription'), customerSubscription.id])
                redirect customerSubscription
            }
            '*' { respond customerSubscription, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerSubscriptionService.get(id)
    }

    def update(CustomerSubscription customerSubscription) {
        if (customerSubscription == null) {
            notFound()
            return
        }

        try {
            customerSubscriptionService.save(customerSubscription)
        } catch (ValidationException e) {
            respond customerSubscription.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSubscription.label', default: 'CustomerSubscription'), customerSubscription.id])
                redirect customerSubscription
            }
            '*'{ respond customerSubscription, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerSubscriptionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSubscription.label', default: 'CustomerSubscription'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSubscription.label', default: 'CustomerSubscription'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
