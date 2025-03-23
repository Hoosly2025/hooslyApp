package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingServiceAreaMapController {

    VendorOnboardingServiceAreaMapService vendorOnboardingServiceAreaMapService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingServiceAreaMapService.list(params), model:[vendorOnboardingServiceAreaMapCount: vendorOnboardingServiceAreaMapService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingServiceAreaMapService.get(id)
    }

    def create() {
        respond new VendorOnboardingServiceAreaMap(params)
    }

    def save(VendorOnboardingServiceAreaMap vendorOnboardingServiceAreaMap) {
        if (vendorOnboardingServiceAreaMap == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServiceAreaMapService.save(vendorOnboardingServiceAreaMap)
        } catch (ValidationException e) {
            respond vendorOnboardingServiceAreaMap.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboardingServiceAreaMap.label', default: 'VendorOnboardingServiceAreaMap'), vendorOnboardingServiceAreaMap.id])
                redirect vendorOnboardingServiceAreaMap
            }
            '*' { respond vendorOnboardingServiceAreaMap, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingServiceAreaMapService.get(id)
    }

    def update(VendorOnboardingServiceAreaMap vendorOnboardingServiceAreaMap) {
        if (vendorOnboardingServiceAreaMap == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingServiceAreaMapService.save(vendorOnboardingServiceAreaMap)
        } catch (ValidationException e) {
            respond vendorOnboardingServiceAreaMap.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboardingServiceAreaMap.label', default: 'VendorOnboardingServiceAreaMap'), vendorOnboardingServiceAreaMap.id])
                redirect vendorOnboardingServiceAreaMap
            }
            '*'{ respond vendorOnboardingServiceAreaMap, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingServiceAreaMapService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboardingServiceAreaMap.label', default: 'VendorOnboardingServiceAreaMap'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboardingServiceAreaMap.label', default: 'VendorOnboardingServiceAreaMap'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
