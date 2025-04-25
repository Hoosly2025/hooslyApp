package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN'])
class VendorRatingController {

    VendorRatingService vendorRatingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorRatingService.list(params), model:[vendorRatingCount: vendorRatingService.count()]
    }

    def show(Long id) {
        respond vendorRatingService.get(id)
    }

    def create() {
        respond new VendorRating(params)
    }

    def save(VendorRating vendorRating) {
        if (vendorRating == null) {
            notFound()
            return
        }

        try {
            vendorRatingService.save(vendorRating)
        } catch (ValidationException e) {
            respond vendorRating.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorRating.label', default: 'VendorRating'), vendorRating.id])
                redirect vendorRating
            }
            '*' { respond vendorRating, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorRatingService.get(id)
    }

    def update(VendorRating vendorRating) {
        if (vendorRating == null) {
            notFound()
            return
        }

        try {
            vendorRatingService.save(vendorRating)
        } catch (ValidationException e) {
            respond vendorRating.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorRating.label', default: 'VendorRating'), vendorRating.id])
                redirect vendorRating
            }
            '*'{ respond vendorRating, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorRatingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorRating.label', default: 'VendorRating'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorRating.label', default: 'VendorRating'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
