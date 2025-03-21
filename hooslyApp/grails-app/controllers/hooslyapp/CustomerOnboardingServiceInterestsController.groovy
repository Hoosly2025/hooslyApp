package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerOnboardingServiceInterestsController {

    CustomerOnboardingServiceInterestsService customerOnboardingServiceInterestsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerOnboardingServiceInterestsService.list(params), model:[customerOnboardingServiceInterestsCount: customerOnboardingServiceInterestsService.count()]
    }

    def show(Long id) {
        respond customerOnboardingServiceInterestsService.get(id)
    }

    def create() {
        respond new CustomerOnboardingServiceInterests(params)
    }

    def save(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {
        if (customerOnboardingServiceInterests == null) {
            notFound()
            return
        }

        try {
            customerOnboardingServiceInterestsService.save(customerOnboardingServiceInterests)
        } catch (ValidationException e) {
            respond customerOnboardingServiceInterests.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), customerOnboardingServiceInterests.id])
                redirect customerOnboardingServiceInterests
            }
            '*' { respond customerOnboardingServiceInterests, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerOnboardingServiceInterestsService.get(id)
    }

    def update(CustomerOnboardingServiceInterests customerOnboardingServiceInterests) {
        if (customerOnboardingServiceInterests == null) {
            notFound()
            return
        }

        try {
            customerOnboardingServiceInterestsService.save(customerOnboardingServiceInterests)
        } catch (ValidationException e) {
            respond customerOnboardingServiceInterests.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), customerOnboardingServiceInterests.id])
                redirect customerOnboardingServiceInterests
            }
            '*'{ respond customerOnboardingServiceInterests, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerOnboardingServiceInterestsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingServiceInterests.label', default: 'CustomerOnboardingServiceInterests'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
