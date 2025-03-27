package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorSubscriptionPlanController {

    VendorSubscriptionPlanService vendorSubscriptionPlanService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorSubscriptionPlanService.list(params), model:[vendorSubscriptionPlanCount: vendorSubscriptionPlanService.count()]
    }

    def show(Long id) {
        respond vendorSubscriptionPlanService.get(id)
    }

    def create() {
        respond new VendorSubscriptionPlan(params)
    }

    def save(VendorSubscriptionPlan vendorSubscriptionPlan) {
        if (vendorSubscriptionPlan == null) {
            notFound()
            return
        }

        try {
            vendorSubscriptionPlanService.save(vendorSubscriptionPlan)
        } catch (ValidationException e) {
            respond vendorSubscriptionPlan.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorSubscriptionPlan.label', default: 'VendorSubscriptionPlan'), vendorSubscriptionPlan.id])
                redirect vendorSubscriptionPlan
            }
            '*' { respond vendorSubscriptionPlan, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorSubscriptionPlanService.get(id)
    }

    def update(VendorSubscriptionPlan vendorSubscriptionPlan) {
        if (vendorSubscriptionPlan == null) {
            notFound()
            return
        }

        try {
            vendorSubscriptionPlanService.save(vendorSubscriptionPlan)
        } catch (ValidationException e) {
            respond vendorSubscriptionPlan.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorSubscriptionPlan.label', default: 'VendorSubscriptionPlan'), vendorSubscriptionPlan.id])
                redirect vendorSubscriptionPlan
            }
            '*'{ respond vendorSubscriptionPlan, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorSubscriptionPlanService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorSubscriptionPlan.label', default: 'VendorSubscriptionPlan'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorSubscriptionPlan.label', default: 'VendorSubscriptionPlan'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
