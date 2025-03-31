package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorLicensesController {

    VendorLicensesService vendorLicensesService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorLicensesService.list(params), model:[vendorLicensesCount: vendorLicensesService.count()]
    }

    def show(Long id) {
        respond vendorLicensesService.get(id)
    }

    def create() {
        respond new VendorLicenses(params)
    }

    def save(VendorLicenses vendorLicenses) {
        if (vendorLicenses == null) {
            notFound()
            return
        }

        try {
            vendorLicensesService.save(vendorLicenses)
        } catch (ValidationException e) {
            respond vendorLicenses.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), vendorLicenses.id])
                redirect vendorLicenses
            }
            '*' { respond vendorLicenses, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorLicensesService.get(id)
    }

    def update(VendorLicenses vendorLicenses) {
        if (vendorLicenses == null) {
            notFound()
            return
        }

        try {
            vendorLicensesService.save(vendorLicenses)
        } catch (ValidationException e) {
            respond vendorLicenses.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), vendorLicenses.id])
                redirect vendorLicenses
            }
            '*'{ respond vendorLicenses, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorLicensesService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorLicenses.label', default: 'VendorLicenses'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
