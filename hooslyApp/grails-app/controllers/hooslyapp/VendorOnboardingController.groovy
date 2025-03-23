package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingController {

    VendorOnboardingService vendorOnboardingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingService.list(params), model:[vendorOnboardingCount: vendorOnboardingService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingService.get(id)
    }

    def create() {
        respond new VendorOnboarding(params)
    }

    def save(VendorOnboarding vendorOnboarding) {
        if (vendorOnboarding == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingService.save(vendorOnboarding)
        } catch (ValidationException e) {
            respond vendorOnboarding.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), vendorOnboarding.id])
                redirect vendorOnboarding
            }
            '*' { respond vendorOnboarding, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingService.get(id)
    }

    def update(VendorOnboarding vendorOnboarding) {
        if (vendorOnboarding == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingService.save(vendorOnboarding)
        } catch (ValidationException e) {
            respond vendorOnboarding.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), vendorOnboarding.id])
                redirect vendorOnboarding
            }
            '*'{ respond vendorOnboarding, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
