package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerOnboardingMaintenanceFrequencyController {

    CustomerOnboardingMaintenanceFrequencyService customerOnboardingMaintenanceFrequencyService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerOnboardingMaintenanceFrequencyService.list(params), model:[customerOnboardingMaintenanceFrequencyCount: customerOnboardingMaintenanceFrequencyService.count()]
    }

    def show(Long id) {
        respond customerOnboardingMaintenanceFrequencyService.get(id)
    }

    def create() {
        respond new CustomerOnboardingMaintenanceFrequency(params)
    }

    def save(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {
        if (customerOnboardingMaintenanceFrequency == null) {
            notFound()
            return
        }

        try {
            customerOnboardingMaintenanceFrequencyService.save(customerOnboardingMaintenanceFrequency)
        } catch (ValidationException e) {
            respond customerOnboardingMaintenanceFrequency.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), customerOnboardingMaintenanceFrequency.id])
                redirect customerOnboardingMaintenanceFrequency
            }
            '*' { respond customerOnboardingMaintenanceFrequency, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerOnboardingMaintenanceFrequencyService.get(id)
    }

    def update(CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency) {
        if (customerOnboardingMaintenanceFrequency == null) {
            notFound()
            return
        }

        try {
            customerOnboardingMaintenanceFrequencyService.save(customerOnboardingMaintenanceFrequency)
        } catch (ValidationException e) {
            respond customerOnboardingMaintenanceFrequency.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), customerOnboardingMaintenanceFrequency.id])
                redirect customerOnboardingMaintenanceFrequency
            }
            '*'{ respond customerOnboardingMaintenanceFrequency, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerOnboardingMaintenanceFrequencyService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingMaintenanceFrequency.label', default: 'CustomerOnboardingMaintenanceFrequency'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
