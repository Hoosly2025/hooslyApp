package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerPhotosController {

    CustomerPhotosService customerPhotosService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerPhotosService.list(params), model:[customerPhotosCount: customerPhotosService.count()]
    }

    def show(Long id) {
        respond customerPhotosService.get(id)
    }

    def create() {
        respond new CustomerPhotos(params)
    }

    def save(CustomerPhotos customerPhotos) {
        if (customerPhotos == null) {
            notFound()
            return
        }

        try {
            customerPhotosService.save(customerPhotos)
        } catch (ValidationException e) {
            respond customerPhotos.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), customerPhotos.id])
                redirect customerPhotos
            }
            '*' { respond customerPhotos, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerPhotosService.get(id)
    }

    def update(CustomerPhotos customerPhotos) {
        if (customerPhotos == null) {
            notFound()
            return
        }

        try {
            customerPhotosService.save(customerPhotos)
        } catch (ValidationException e) {
            respond customerPhotos.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), customerPhotos.id])
                redirect customerPhotos
            }
            '*'{ respond customerPhotos, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerPhotosService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerPhotos.label', default: 'CustomerPhotos'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
