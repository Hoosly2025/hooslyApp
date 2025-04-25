package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_VENDOR'])
class VendorSubscriptionController {

    VendorSubscriptionService vendorSubscriptionService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorSubscriptionService.list(params), model:[vendorSubscriptionCount: vendorSubscriptionService.count()]
    }

    def show(Long id) {
        respond vendorSubscriptionService.get(id)
    }

    def create() {
        respond new VendorSubscription(params)
    }

    def save(VendorSubscription vendorSubscription) {
        if (vendorSubscription == null) {
            notFound()
            return
        }

        try {
            vendorSubscriptionService.save(vendorSubscription)
        } catch (ValidationException e) {
            respond vendorSubscription.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorSubscription.label', default: 'VendorSubscription'), vendorSubscription.id])
                redirect vendorSubscription
            }
            '*' { respond vendorSubscription, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorSubscriptionService.get(id)
    }

    def update(VendorSubscription vendorSubscription) {
        if (vendorSubscription == null) {
            notFound()
            return
        }

        try {
            vendorSubscriptionService.save(vendorSubscription)
        } catch (ValidationException e) {
            respond vendorSubscription.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorSubscription.label', default: 'VendorSubscription'), vendorSubscription.id])
                redirect vendorSubscription
            }
            '*'{ respond vendorSubscription, [status: OK] }
        }
    }

	@Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorSubscriptionService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorSubscription.label', default: 'VendorSubscription'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorSubscription.label', default: 'VendorSubscription'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
