package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingCategoriesMapController {

    VendorOnboardingCategoriesMapService vendorOnboardingCategoriesMapService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingCategoriesMapService.list(params), model:[vendorOnboardingCategoriesMapCount: vendorOnboardingCategoriesMapService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingCategoriesMapService.get(id)
    }

    def create() {
        respond new VendorOnboardingCategoriesMap(params)
    }

    def save(VendorOnboardingCategoriesMap vendorOnboardingCategoriesMap) {
        if (vendorOnboardingCategoriesMap == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingCategoriesMapService.save(vendorOnboardingCategoriesMap)
        } catch (ValidationException e) {
            respond vendorOnboardingCategoriesMap.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboardingCategoriesMap.label', default: 'VendorOnboardingCategoriesMap'), vendorOnboardingCategoriesMap.id])
                redirect vendorOnboardingCategoriesMap
            }
            '*' { respond vendorOnboardingCategoriesMap, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingCategoriesMapService.get(id)
    }

    def update(VendorOnboardingCategoriesMap vendorOnboardingCategoriesMap) {
        if (vendorOnboardingCategoriesMap == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingCategoriesMapService.save(vendorOnboardingCategoriesMap)
        } catch (ValidationException e) {
            respond vendorOnboardingCategoriesMap.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboardingCategoriesMap.label', default: 'VendorOnboardingCategoriesMap'), vendorOnboardingCategoriesMap.id])
                redirect vendorOnboardingCategoriesMap
            }
            '*'{ respond vendorOnboardingCategoriesMap, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingCategoriesMapService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboardingCategoriesMap.label', default: 'VendorOnboardingCategoriesMap'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboardingCategoriesMap.label', default: 'VendorOnboardingCategoriesMap'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
