package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

import java.util.*
import java.lang.*

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

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		VendorInvoice vendorInvoiceInstance = vendorInvoiceService.get(id)
		if ( vendorInvoiceInstance == null) {
			flash.message = "Vendor Invoice not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${vendorInvoiceInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << vendorInvoiceInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def invoice(Long id) {
		System.out.println("Inside invoice: id = " + id)
		//create the vendorInvoice object and invoice download can be on the show invoice
		//create the invoice number, Invoice #: HOOSLY-[YYYYMMDD]-[VENDOR_ID], which is id passed in
		
		Calendar rightNow = Calendar.getInstance()
		
		int year = rightNow.get(Calendar.YEAR)
		int month = rightNow.get(Calendar.MONTH)
		int day = rightNow.get(Calendar.DAY_OF_MONTH)
		
		def yearStr = String.valueOf(year)
		def monthStr = String.valueOf(month)
		def dayStr = String.valueOf(day)
		
		def invoiceNumber = "HOOSLY-" + yearStr + monthStr + dayStr + "-" + id
		
		System.out.println("invoice number = " + invoiceNumber)
		
		def vendorInvoice = VendorInvoice.findById(id)
		
		vendorInvoice.invoiceNumber = invoiceNumber
		
		def filename = "INVOICE-VENDOR-" + invoiceNumber + ".pdf"
		
		System.out.println("filename = " + filename)
		
		//Get the vendor details from vendor onboarding object
		
		if (vendorInvoice.vendor != null) {
		
			def vendorOnboarding = VendorOnboarding.findByVendor(vendorInvoice.vendor)
			
			//TODO: Get the hoosly business details from Jermane
			
			//Get the vendor subscription plan from VendorSubscriptionCurrentPlanType
			def vendorSubscription = VendorSubscription.findByVendor(vendorInvoice.vendor)
			
			def vendorSubscriptionCurrentPlanType
			def vendorSubscriptionPlan
			
			if (vendorSubscription != null) {
				vendorSubscriptionCurrentPlanType = VendorSubscriptionCurrentPlanType.findByVendorSubscription(vendorSubscription.id)
				vendorSubscriptionPlan = vendorSubscriptionCurrentPlanType.planType
			}
			//Get the payment due date and method from VendorSubscription
			//Get fees from VendorSubscriptionPlan
			
			def mypdf = new ByteArrayOutputStream().withStream { outputStream ->
				pdfRenderingService.render(
					[controller:this,
					template: "/vendorInvoice/invoice",
					model:[vendorInvoice: vendorInvoice, vendorOnboarding: vendorOnboarding, vendorSubscription: vendorSubscription, vendorSubscriptonCurrentPlanType: vendorSubscriptionCurrentPlanType, vendorSubscriptionPlan: vendorSubscriptionPlan]],
					outputStream // <- ataylor added this parameter
				).toByteArray()   // <- I added this
			}
		
			vendorInvoice.fileUpload = mypdf
			vendorInvoice.filename = filename
			
			try {
	            vendorInvoiceService.save(vendorInvoice)
	        } catch (ValidationException e) {
	            respond vendorInvoice.errors, view:'show'
	            return
	        }
			
			response.contentType = 'application/pdf'
			//response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
			
			response.outputStream << mypdf
		} 
			
		return
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
