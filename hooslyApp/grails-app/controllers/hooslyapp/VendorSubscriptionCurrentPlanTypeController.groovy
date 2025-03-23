package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorSubscriptionCurrentPlanTypeController {

    VendorSubscriptionCurrentPlanTypeService vendorSubscriptionCurrentPlanTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorSubscriptionCurrentPlanTypeService.list(params), model:[vendorSubscriptionCurrentPlanTypeCount: vendorSubscriptionCurrentPlanTypeService.count()]
    }

    def show(Long id) {
        respond vendorSubscriptionCurrentPlanTypeService.get(id)
    }

    def create() {
        respond new VendorSubscriptionCurrentPlanType(params)
    }

    def save(VendorSubscriptionCurrentPlanType vendorSubscriptionCurrentPlanType) {
        if (vendorSubscriptionCurrentPlanType == null) {
            notFound()
            return
        }

        try {
            vendorSubscriptionCurrentPlanTypeService.save(vendorSubscriptionCurrentPlanType)
        } catch (ValidationException e) {
            respond vendorSubscriptionCurrentPlanType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorSubscriptionCurrentPlanType.label', default: 'VendorSubscriptionCurrentPlanType'), vendorSubscriptionCurrentPlanType.id])
                redirect vendorSubscriptionCurrentPlanType
            }
            '*' { respond vendorSubscriptionCurrentPlanType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorSubscriptionCurrentPlanTypeService.get(id)
    }

    def update(VendorSubscriptionCurrentPlanType vendorSubscriptionCurrentPlanType) {
        if (vendorSubscriptionCurrentPlanType == null) {
            notFound()
            return
        }

        try {
            vendorSubscriptionCurrentPlanTypeService.save(vendorSubscriptionCurrentPlanType)
        } catch (ValidationException e) {
            respond vendorSubscriptionCurrentPlanType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorSubscriptionCurrentPlanType.label', default: 'VendorSubscriptionCurrentPlanType'), vendorSubscriptionCurrentPlanType.id])
                redirect vendorSubscriptionCurrentPlanType
            }
            '*'{ respond vendorSubscriptionCurrentPlanType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorSubscriptionCurrentPlanTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorSubscriptionCurrentPlanType.label', default: 'VendorSubscriptionCurrentPlanType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorSubscriptionCurrentPlanType.label', default: 'VendorSubscriptionCurrentPlanType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
