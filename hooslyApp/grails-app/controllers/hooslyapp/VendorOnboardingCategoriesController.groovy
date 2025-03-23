package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorOnboardingCategoriesController {

    VendorOnboardingCategoriesService vendorOnboardingCategoriesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingCategoriesService.list(params), model:[vendorOnboardingCategoriesCount: vendorOnboardingCategoriesService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingCategoriesService.get(id)
    }

    def create() {
        respond new VendorOnboardingCategories(params)
    }

    def save(VendorOnboardingCategories vendorOnboardingCategories) {
        if (vendorOnboardingCategories == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingCategoriesService.save(vendorOnboardingCategories)
        } catch (ValidationException e) {
            respond vendorOnboardingCategories.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboardingCategories.label', default: 'VendorOnboardingCategories'), vendorOnboardingCategories.id])
                redirect vendorOnboardingCategories
            }
            '*' { respond vendorOnboardingCategories, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingCategoriesService.get(id)
    }

    def update(VendorOnboardingCategories vendorOnboardingCategories) {
        if (vendorOnboardingCategories == null) {
            notFound()
            return
        }

        try {
            vendorOnboardingCategoriesService.save(vendorOnboardingCategories)
        } catch (ValidationException e) {
            respond vendorOnboardingCategories.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboardingCategories.label', default: 'VendorOnboardingCategories'), vendorOnboardingCategories.id])
                redirect vendorOnboardingCategories
            }
            '*'{ respond vendorOnboardingCategories, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingCategoriesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboardingCategories.label', default: 'VendorOnboardingCategories'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboardingCategories.label', default: 'VendorOnboardingCategories'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
