package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerSubscriptionCurrentPlanTypeController {

    CustomerSubscriptionCurrentPlanTypeService customerSubscriptionCurrentPlanTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerSubscriptionCurrentPlanTypeService.list(params), model:[customerSubscriptionCurrentPlanTypeCount: customerSubscriptionCurrentPlanTypeService.count()]
    }

    def show(Long id) {
        respond customerSubscriptionCurrentPlanTypeService.get(id)
    }

    def create() {
        respond new CustomerSubscriptionCurrentPlanType(params)
    }

    def save(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {
        if (customerSubscriptionCurrentPlanType == null) {
            notFound()
            return
        }

        try {
            customerSubscriptionCurrentPlanTypeService.save(customerSubscriptionCurrentPlanType)
        } catch (ValidationException e) {
            respond customerSubscriptionCurrentPlanType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), customerSubscriptionCurrentPlanType.id])
                redirect customerSubscriptionCurrentPlanType
            }
            '*' { respond customerSubscriptionCurrentPlanType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerSubscriptionCurrentPlanTypeService.get(id)
    }

    def update(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType) {
        if (customerSubscriptionCurrentPlanType == null) {
            notFound()
            return
        }

        try {
            customerSubscriptionCurrentPlanTypeService.save(customerSubscriptionCurrentPlanType)
        } catch (ValidationException e) {
            respond customerSubscriptionCurrentPlanType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), customerSubscriptionCurrentPlanType.id])
                redirect customerSubscriptionCurrentPlanType
            }
            '*'{ respond customerSubscriptionCurrentPlanType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerSubscriptionCurrentPlanTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
