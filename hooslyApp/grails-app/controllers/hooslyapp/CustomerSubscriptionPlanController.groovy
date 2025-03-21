package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerSubscriptionPlanController {

    CustomerSubscriptionPlanService customerSubscriptionPlanService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerSubscriptionPlanService.list(params), model:[customerSubscriptionPlanCount: customerSubscriptionPlanService.count()]
    }

    def show(Long id) {
        respond customerSubscriptionPlanService.get(id)
    }

    def create() {
        respond new CustomerSubscriptionPlan(params)
    }

    def save(CustomerSubscriptionPlan customerSubscriptionPlan) {
        if (customerSubscriptionPlan == null) {
            notFound()
            return
        }

        try {
            customerSubscriptionPlanService.save(customerSubscriptionPlan)
        } catch (ValidationException e) {
            respond customerSubscriptionPlan.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), customerSubscriptionPlan.id])
                redirect customerSubscriptionPlan
            }
            '*' { respond customerSubscriptionPlan, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerSubscriptionPlanService.get(id)
    }

    def update(CustomerSubscriptionPlan customerSubscriptionPlan) {
        if (customerSubscriptionPlan == null) {
            notFound()
            return
        }

        try {
            customerSubscriptionPlanService.save(customerSubscriptionPlan)
        } catch (ValidationException e) {
            respond customerSubscriptionPlan.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), customerSubscriptionPlan.id])
                redirect customerSubscriptionPlan
            }
            '*'{ respond customerSubscriptionPlan, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerSubscriptionPlanService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSubscriptionPlan.label', default: 'CustomerSubscriptionPlan'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
