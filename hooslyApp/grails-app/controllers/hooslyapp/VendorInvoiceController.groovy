package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorInvoiceController {

    VendorInvoiceService vendorInvoiceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorInvoiceService.list(params), model:[vendorInvoiceCount: vendorInvoiceService.count()]
    }

    def show(Long id) {
        respond vendorInvoiceService.get(id)
    }

    def create() {
        respond new VendorInvoice(params)
    }

    def save(VendorInvoice vendorInvoice) {
        if (vendorInvoice == null) {
            notFound()
            return
        }

        try {
            vendorInvoiceService.save(vendorInvoice)
        } catch (ValidationException e) {
            respond vendorInvoice.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorInvoice.label', default: 'VendorInvoice'), vendorInvoice.id])
                redirect vendorInvoice
            }
            '*' { respond vendorInvoice, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorInvoiceService.get(id)
    }

    def update(VendorInvoice vendorInvoice) {
        if (vendorInvoice == null) {
            notFound()
            return
        }

        try {
            vendorInvoiceService.save(vendorInvoice)
        } catch (ValidationException e) {
            respond vendorInvoice.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorInvoice.label', default: 'VendorInvoice'), vendorInvoice.id])
                redirect vendorInvoice
            }
            '*'{ respond vendorInvoice, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorInvoiceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorInvoice.label', default: 'VendorInvoice'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorInvoice.label', default: 'VendorInvoice'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
