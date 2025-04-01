package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerSupportTicketStatusController {

    CustomerSupportTicketStatusService customerSupportTicketStatusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerSupportTicketStatusService.list(params), model:[customerSupportTicketStatusCount: customerSupportTicketStatusService.count()]
    }

    def show(Long id) {
        respond customerSupportTicketStatusService.get(id)
    }

    def create() {
        respond new CustomerSupportTicketStatus(params)
    }

    def save(CustomerSupportTicketStatus customerSupportTicketStatus) {
        if (customerSupportTicketStatus == null) {
            notFound()
            return
        }

        try {
            customerSupportTicketStatusService.save(customerSupportTicketStatus)
        } catch (ValidationException e) {
            respond customerSupportTicketStatus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerSupportTicketStatus.label', default: 'CustomerSupportTicketStatus'), customerSupportTicketStatus.id])
                redirect customerSupportTicketStatus
            }
            '*' { respond customerSupportTicketStatus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerSupportTicketStatusService.get(id)
    }

    def update(CustomerSupportTicketStatus customerSupportTicketStatus) {
        if (customerSupportTicketStatus == null) {
            notFound()
            return
        }

        try {
            customerSupportTicketStatusService.save(customerSupportTicketStatus)
        } catch (ValidationException e) {
            respond customerSupportTicketStatus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerSupportTicketStatus.label', default: 'CustomerSupportTicketStatus'), customerSupportTicketStatus.id])
                redirect customerSupportTicketStatus
            }
            '*'{ respond customerSupportTicketStatus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerSupportTicketStatusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerSupportTicketStatus.label', default: 'CustomerSupportTicketStatus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerSupportTicketStatus.label', default: 'CustomerSupportTicketStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
