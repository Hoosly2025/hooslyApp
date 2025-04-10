package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerInvoiceController {

    CustomerInvoiceService customerInvoiceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerInvoiceService.list(params), model:[customerInvoiceCount: customerInvoiceService.count()]
    }

    def show(Long id) {
        respond customerInvoiceService.get(id)
    }

    def create() {
        respond new CustomerInvoice(params)
    }

    def save(CustomerInvoice customerInvoice) {
        if (customerInvoice == null) {
            notFound()
            return
        }

        try {
            customerInvoiceService.save(customerInvoice)
        } catch (ValidationException e) {
            respond customerInvoice.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerInvoice.label', default: 'CustomerInvoice'), customerInvoice.id])
                redirect customerInvoice
            }
            '*' { respond customerInvoice, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerInvoiceService.get(id)
    }

    def update(CustomerInvoice customerInvoice) {
        if (customerInvoice == null) {
            notFound()
            return
        }

        try {
            customerInvoiceService.save(customerInvoice)
        } catch (ValidationException e) {
            respond customerInvoice.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerInvoice.label', default: 'CustomerInvoice'), customerInvoice.id])
                redirect customerInvoice
            }
            '*'{ respond customerInvoice, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerInvoiceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerInvoice.label', default: 'CustomerInvoice'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerInvoice.label', default: 'CustomerInvoice'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
