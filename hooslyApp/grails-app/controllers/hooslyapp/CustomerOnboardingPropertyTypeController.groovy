package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerOnboardingPropertyTypeController {

    CustomerOnboardingPropertyTypeService customerOnboardingPropertyTypeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerOnboardingPropertyTypeService.list(params), model:[customerOnboardingPropertyTypeCount: customerOnboardingPropertyTypeService.count()]
    }

    def show(Long id) {
        respond customerOnboardingPropertyTypeService.get(id)
    }

    def create() {
        respond new CustomerOnboardingPropertyType(params)
    }

    def save(CustomerOnboardingPropertyType customerOnboardingPropertyType) {
        if (customerOnboardingPropertyType == null) {
            notFound()
            return
        }

        try {
            customerOnboardingPropertyTypeService.save(customerOnboardingPropertyType)
        } catch (ValidationException e) {
            respond customerOnboardingPropertyType.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), customerOnboardingPropertyType.id])
                redirect customerOnboardingPropertyType
            }
            '*' { respond customerOnboardingPropertyType, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerOnboardingPropertyTypeService.get(id)
    }

    def update(CustomerOnboardingPropertyType customerOnboardingPropertyType) {
        if (customerOnboardingPropertyType == null) {
            notFound()
            return
        }

        try {
            customerOnboardingPropertyTypeService.save(customerOnboardingPropertyType)
        } catch (ValidationException e) {
            respond customerOnboardingPropertyType.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), customerOnboardingPropertyType.id])
                redirect customerOnboardingPropertyType
            }
            '*'{ respond customerOnboardingPropertyType, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerOnboardingPropertyTypeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboardingPropertyType.label', default: 'CustomerOnboardingPropertyType'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
