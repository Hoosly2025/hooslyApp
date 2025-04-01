package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerSupportTicketController {

    CustomerSupportTicketService customerSupportTicketService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerSupportTicketService.list(params), model:[customerSupportTicketCount: customerSupportTicketService.count()]
    }

    def show(Long id) {
        respond customerSupportTicketService.get(id)
    }

    def create() {
        respond new CustomerSupportTicket(params)
    }

    def save(CustomerSupportTicket customerSupportTicket) {
        if (customerSupportTicket == null) {
            notFound()
            return
        }

        try {
            customerSupportTicketService.save(customerSupportTicket)
        } catch (ValidationException e) {
            respond customerSupportTicket.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSupportTicket.label', default: 'CustomerSupportTicket'), customerSupportTicket.id])
                redirect customerSupportTicket
            }
            '*' { respond customerSupportTicket, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerSupportTicketService.get(id)
    }

    def update(CustomerSupportTicket customerSupportTicket) {
        if (customerSupportTicket == null) {
            notFound()
            return
        }

        try {
            customerSupportTicketService.save(customerSupportTicket)
        } catch (ValidationException e) {
            respond customerSupportTicket.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSupportTicket.label', default: 'CustomerSupportTicket'), customerSupportTicket.id])
                redirect customerSupportTicket
            }
            '*'{ respond customerSupportTicket, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerSupportTicketService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSupportTicket.label', default: 'CustomerSupportTicket'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSupportTicket.label', default: 'CustomerSupportTicket'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
