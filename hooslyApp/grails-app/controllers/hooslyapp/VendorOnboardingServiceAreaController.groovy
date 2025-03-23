package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingServiceAreaController {

    VendorOnboardingServiceAreaService vendorOnboardingServiceAreaService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingServiceAreaService.list(params), model:[vendorOnboardingServiceAreaCount: vendorOnboardingServiceAreaService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingServiceAreaService.get(id)
    }

    def create() {
        respond new VendorOnboardingServiceArea(params)
    }

    def save(VendorOnboardingServiceArea vendorOnboardingServiceArea) {
        if (vendorOnboardingServiceArea == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServiceAreaService.save(vendorOnboardingServiceArea)
        } catch (ValidationException e) {
            respond vendorOnboardingServiceArea.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboardingServiceArea.label', default: 'VendorOnboardingServiceArea'), vendorOnboardingServiceArea.id])
                redirect vendorOnboardingServiceArea
            }
            '*' { respond vendorOnboardingServiceArea, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingServiceAreaService.get(id)
    }

    def update(VendorOnboardingServiceArea vendorOnboardingServiceArea) {
        if (vendorOnboardingServiceArea == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServiceAreaService.save(vendorOnboardingServiceArea)
        } catch (ValidationException e) {
            respond vendorOnboardingServiceArea.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboardingServiceArea.label', default: 'VendorOnboardingServiceArea'), vendorOnboardingServiceArea.id])
                redirect vendorOnboardingServiceArea
            }
            '*'{ respond vendorOnboardingServiceArea, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingServiceAreaService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboardingServiceArea.label', default: 'VendorOnboardingServiceArea'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboardingServiceArea.label', default: 'VendorOnboardingServiceArea'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
