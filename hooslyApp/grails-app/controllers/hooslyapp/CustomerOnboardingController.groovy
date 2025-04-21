package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerOnboardingController {

    CustomerOnboardingService customerOnboardingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerOnboardingService.list(params), model:[customerOnboardingCount: customerOnboardingService.count()]
    }

    def show(Long id) {
        respond customerOnboardingService.get(id)
    }

    def create() {
        respond new CustomerOnboarding(params)
    }

    def save(CustomerOnboarding customerOnboarding) {
        if (customerOnboarding == null) {
            notFound()
            return
        }

        try {
            customerOnboardingService.save(customerOnboarding)
        } catch (ValidationException e) {
            respond customerOnboarding.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), customerOnboarding.id])
                redirect customerOnboarding
            }
            '*' { respond customerOnboarding, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerOnboardingService.get(id)
    }

    def update(CustomerOnboarding customerOnboarding) {
        if (customerOnboarding == null) {
            notFound()
            return
        }

        try {
            customerOnboardingService.save(customerOnboarding)
        } catch (ValidationException e) {
            respond customerOnboarding.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), customerOnboarding.id])
                redirect customerOnboarding
            }
            '*'{ respond customerOnboarding, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerOnboardingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
