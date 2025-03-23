package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingServicesController {

    VendorOnboardingServicesService vendorOnboardingServicesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingServicesService.list(params), model:[vendorOnboardingServicesCount: vendorOnboardingServicesService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingServicesService.get(id)
    }

    def create() {
        respond new VendorOnboardingServices(params)
    }

    def save(VendorOnboardingServices vendorOnboardingServices) {
        if (vendorOnboardingServices == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServicesService.save(vendorOnboardingServices)
        } catch (ValidationException e) {
            respond vendorOnboardingServices.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboardingServices.label', default: 'VendorOnboardingServices'), vendorOnboardingServices.id])
                redirect vendorOnboardingServices
            }
            '*' { respond vendorOnboardingServices, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingServicesService.get(id)
    }

    def update(VendorOnboardingServices vendorOnboardingServices) {
        if (vendorOnboardingServices == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServicesService.save(vendorOnboardingServices)
        } catch (ValidationException e) {
            respond vendorOnboardingServices.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboardingServices.label', default: 'VendorOnboardingServices'), vendorOnboardingServices.id])
                redirect vendorOnboardingServices
            }
            '*'{ respond vendorOnboardingServices, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingServicesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboardingServices.label', default: 'VendorOnboardingServices'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboardingServices.label', default: 'VendorOnboardingServices'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
