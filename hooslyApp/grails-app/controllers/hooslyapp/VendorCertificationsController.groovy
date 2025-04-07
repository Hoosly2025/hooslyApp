package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorCertificationsController {

    VendorCertificationsService vendorCertificationsService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorCertificationsService.list(params), model:[vendorCertificationsCount: vendorCertificationsService.count()]
    }

    def show(Long id) {
        respond vendorCertificationsService.get(id)
    }

    def create() {
        respond new VendorCertifications(params)
    }

    def save(VendorCertifications vendorCertifications) {
        if (vendorCertifications == null) {
            notFound()
            return
        }

        try {
            def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				vendorCertifications.filename = transferFile.getOriginalFilename()
				vendorCertifications.fileUpload = transferFile.getBytes()
			}
			vendorCertificationsService.save(vendorCertifications)
            
        } catch (ValidationException e) {
            respond vendorCertifications.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorCertifications.label', default: 'VendorCertifications'), vendorCertifications.id])
                redirect vendorCertifications
            }
            '*' { respond vendorCertifications, [status: CREATED] }
        }
    }

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		VendorCertifications vendorCertificationsInstance = vendorCertificationsService.get(id)
		if ( vendorCertificationsInstance == null) {
			flash.message = "Vendor Certifications not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${vendorCertificationsInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << vendorCertificationsInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
    def edit(Long id) {
        respond vendorCertificationsService.get(id)
    }

    def update(VendorCertifications vendorCertifications) {
        if (vendorCertifications == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				vendorCertifications.filename = transferFile.getOriginalFilename()
				vendorCertifications.fileUpload = transferFile.getBytes()
			}
            vendorCertificationsService.save(vendorCertifications)
        } catch (ValidationException e) {
            respond vendorCertifications.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorCertifications.label', default: 'VendorCertifications'), vendorCertifications.id])
                redirect vendorCertifications
            }
            '*'{ respond vendorCertifications, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorCertificationsService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorCertifications.label', default: 'VendorCertifications'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorCertifications.label', default: 'VendorCertifications'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
