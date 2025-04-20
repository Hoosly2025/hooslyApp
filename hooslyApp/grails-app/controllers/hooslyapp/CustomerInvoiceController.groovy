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

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		CustomerInvoice customerInvoiceInstance = customerInvoiceService.get(id)
		if ( customerInvoiceInstance == null) {
			flash.message = "Customer Invoice not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${customerInvoiceInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << customerInvoiceInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def invoice(Long id) {
		//create the customerInvoice object and invoice download can be on the show invoice
		//create the invoice number, Invoice #: HOOSLY-[YYYYMMDD]-[VENDOR_ID], which is id passed in
		
		Calendar rightNow = Calendar.getInstance()
		
		int year = rightNow.get(Calendar.YEAR)
		int month = rightNow.get(Calendar.MONTH)
		int day = rightNow.get(Calendar.DAY_OF_MONTH)
		
		def yearStr = String.valueOf(year)
		def monthStr = String.valueOf(month)
		def dayStr = String.valueOf(day)
		
		def invoiceNumber = "HOOSLY-" + yearStr + monthStr + dayStr + "-" + id
		
		def customerInvoice = CustomerInvoice.findById(id)
		
		customerInvoice.invoiceNumber = invoiceNumber
		
		def filename = "INVOICE-CUSTOMER-" + invoiceNumber + ".pdf"
		
		//Get the customer details from customer onboarding object
		
		if (customerInvoice.customer != null) {
			
			def customerOnboarding = CustomerOnboarding.findByCustomer(customerInvoice.customer)
			
			//TODO: Get the hoosly business details from Jermane
			
			//Get the customer subscription plan from CustomerSubscriptionCurrentPlanType
			def customerSubscription = CustomerSubscription.findByCustomer(customerInvoice.customer)
			
			def customerSubscriptionCurrentPlanType
			def customerSubscriptionPlan
			
			if (customerSubscription != null) {
				customerSubscriptionCurrentPlanType = CustomerSubscriptionCurrentPlanType.findByCustomerSubscription(customerSubscription.id)
				customerSubscriptionPlan = customerSubscriptionCurrentPlanType.planType
				
			}
			//Get the payment due date and method from CustomerSubscription
			//Get fees from CustomerSubscriptionPlan
			
			def mypdf = new ByteArrayOutputStream().withStream { outputStream ->
				pdfRenderingService.render(
					[controller:this,
					template: "/customerInvoice/invoice",
					model:[customerInvoice: customerInvoice, customerOnboarding: customerOnboarding, customerSubscription: customerSubscription, customerSubscriptonCurrentPlanType: customerSubscriptionCurrentPlanType, customerSubscriptionPlan: customerSubscriptionPlan]],
					outputStream // <- ataylor added this parameter
				).toByteArray()   // <- I added this
			}
		
			customerInvoice.fileUpload = mypdf
			customerInvoice.filename = filename
			
			try {
	            customerInvoiceService.save(customerInvoice)
	        } catch (ValidationException e) {
	            respond customerInvoice.errors, view:'show'
	            return
	        }
			
			response.contentType = 'application/pdf'
			//response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
			
			response.outputStream << mypdf
		}
		return
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
