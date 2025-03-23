package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingServicesMapController {

    VendorOnboardingServicesMapService vendorOnboardingServicesMapService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingServicesMapService.list(params), model:[vendorOnboardingServicesMapCount: vendorOnboardingServicesMapService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingServicesMapService.get(id)
    }

    def create() {
        respond new VendorOnboardingServicesMap(params)
    }

    def save(VendorOnboardingServicesMap vendorOnboardingServicesMap) {
        if (vendorOnboardingServicesMap == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServicesMapService.save(vendorOnboardingServicesMap)
        } catch (ValidationException e) {
            respond vendorOnboardingServicesMap.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboardingServicesMap.label', default: 'VendorOnboardingServicesMap'), vendorOnboardingServicesMap.id])
                redirect vendorOnboardingServicesMap
            }
            '*' { respond vendorOnboardingServicesMap, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingServicesMapService.get(id)
    }

    def update(VendorOnboardingServicesMap vendorOnboardingServicesMap) {
        if (vendorOnboardingServicesMap == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServicesMapService.save(vendorOnboardingServicesMap)
        } catch (ValidationException e) {
            respond vendorOnboardingServicesMap.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboardingServicesMap.label', default: 'VendorOnboardingServicesMap'), vendorOnboardingServicesMap.id])
                redirect vendorOnboardingServicesMap
            }
            '*'{ respond vendorOnboardingServicesMap, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingServicesMapService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboardingServicesMap.label', default: 'VendorOnboardingServicesMap'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboardingServicesMap.label', default: 'VendorOnboardingServicesMap'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
