package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerOnboardingServiceInterestsMapController {

    CustomerOnboardingServiceInterestsMapService customerOnboardingServiceInterestsMapService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerOnboardingServiceInterestsMapService.list(params), model:[customerOnboardingServiceInterestsMapCount: customerOnboardingServiceInterestsMapService.count()]
    }

    def show(Long id) {
        respond customerOnboardingServiceInterestsMapService.get(id)
    }

    def create() {
        respond new CustomerOnboardingServiceInterestsMap(params)
    }

    def save(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {
        if (customerOnboardingServiceInterestsMap == null) {
            notFound()
            return
        }

        try {
            customerOnboardingServiceInterestsMapService.save(customerOnboardingServiceInterestsMap)
        } catch (ValidationException e) {
            respond customerOnboardingServiceInterestsMap.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), customerOnboardingServiceInterestsMap.id])
                redirect customerOnboardingServiceInterestsMap
            }
            '*' { respond customerOnboardingServiceInterestsMap, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerOnboardingServiceInterestsMapService.get(id)
    }

    def update(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap) {
        if (customerOnboardingServiceInterestsMap == null) {
            notFound()
            return
        }

        try {
            customerOnboardingServiceInterestsMapService.save(customerOnboardingServiceInterestsMap)
        } catch (ValidationException e) {
            respond customerOnboardingServiceInterestsMap.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), customerOnboardingServiceInterestsMap.id])
                redirect customerOnboardingServiceInterestsMap
            }
            '*'{ respond customerOnboardingServiceInterestsMap, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerOnboardingServiceInterestsMapService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingServiceInterestsMap.label', default: 'CustomerOnboardingServiceInterestsMap'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
