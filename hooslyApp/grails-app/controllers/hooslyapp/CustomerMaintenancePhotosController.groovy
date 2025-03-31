package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerMaintenancePhotosController {

    CustomerMaintenancePhotosService customerMaintenancePhotosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerMaintenancePhotosService.list(params), model:[customerMaintenancePhotosCount: customerMaintenancePhotosService.count()]
    }

    def show(Long id) {
        respond customerMaintenancePhotosService.get(id)
    }

    def create() {
        respond new CustomerMaintenancePhotos(params)
    }

    def save(CustomerMaintenancePhotos customerMaintenancePhotos) {
        if (customerMaintenancePhotos == null) {
            notFound()
            return
        }

        try {
            customerMaintenancePhotosService.save(customerMaintenancePhotos)
        } catch (ValidationException e) {
            respond customerMaintenancePhotos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenancePhotos.label', default: 'CustomerMaintenancePhotos'), customerMaintenancePhotos.id])
                redirect customerMaintenancePhotos
            }
            '*' { respond customerMaintenancePhotos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerMaintenancePhotosService.get(id)
    }

    def update(CustomerMaintenancePhotos customerMaintenancePhotos) {
        if (customerMaintenancePhotos == null) {
            notFound()
            return
        }

        try {
            customerMaintenancePhotosService.save(customerMaintenancePhotos)
        } catch (ValidationException e) {
            respond customerMaintenancePhotos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenancePhotos.label', default: 'CustomerMaintenancePhotos'), customerMaintenancePhotos.id])
                redirect customerMaintenancePhotos
            }
            '*'{ respond customerMaintenancePhotos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerMaintenancePhotosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenancePhotos.label', default: 'CustomerMaintenancePhotos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenancePhotos.label', default: 'CustomerMaintenancePhotos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
