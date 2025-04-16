package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerMaintenanceInvoiceController {

    CustomerMaintenanceInvoiceService customerMaintenanceInvoiceService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerMaintenanceInvoiceService.list(params), model:[customerMaintenanceInvoiceCount: customerMaintenanceInvoiceService.count()]
    }

    def show(Long id) {
        respond customerMaintenanceInvoiceService.get(id)
    }

    def create() {
        respond new CustomerMaintenanceInvoice(params)
    }

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		CustomerMaintenanceInvoice customerMaintenanceInvoiceInstance = customerMaintenanceInvoiceService.get(id)
		if ( customerMaintenanceInvoiceInstance == null) {
			flash.message = "Customer Maintenance Invoice not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${customerMaintenanceInvoiceInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << customerMaintenanceInvoiceInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def invoice(Long id) {
		System.out.println("Inside invoice: id = " + id)
		//create the customerInvoice object and invoice download can be on the show invoice
		//create the invoice number, Invoice #: HOOSLY-[YYYYMMDD]-[VENDOR_ID], which is id passed in
		
		Calendar rightNow = Calendar.getInstance()
		
		int year = rightNow.get(Calendar.YEAR)
		int month = rightNow.get(Calendar.MONTH)
		int day = rightNow.get(Calendar.DAY_OF_MONTH)
		
		def yearStr = String.valueOf(year)
		def monthStr = String.valueOf(month)
		def dayStr = String.valueOf(day)
		
		def invoiceNumber = "HOOSLY-MAINTENANCE-" + yearStr + monthStr + dayStr + "-" + id
		
		System.out.println("invoice number = " + invoiceNumber)
		
		def customerMaintenanceInvoice = CustomerMaintenanceInvoice.findById(id)
		
		customerMaintenanceInvoice.invoiceNumber = invoiceNumber
		
		def filename = "INVOICE-CUSTOMER-" + invoiceNumber + ".pdf"
		
		System.out.println("filename = " + filename)
		
		//Get the customer details from customer onboarding object
		
		if (customerMaintenanceInvoice.customer != null) {
			
			def customerOnboarding = CustomerOnboarding.findByCustomer(customerMaintenanceInvoice.customer)
			
			System.out.println("customer onboarding")
			//TODO: Get the hoosly business details from Jermane
			
			//Get the customer maintenance details
			
			if (customerOnboarding != null) {
				def customerMaintenance = customerMaintenanceInvoice.customerMaintenance
				System.out.println("customer maintenance")
				if (customerMaintenance != null) {
					def vendor = customerMaintenance.vendorOnboarding
					System.out.println("vendor")
					if (vendor != null) {
						def vendorOnboarding = VendorOnboarding.findByVendor(vendor.id)
						
						System.out.println("vendor onboarding")
						def mypdf = new ByteArrayOutputStream().withStream { outputStream ->
							pdfRenderingService.render(
								[controller:this,
								template: "/customerMaintenanceInvoice/invoice",
								model:[customerMaintenance: customerMaintenance, customerMaintenanceInvoice: customerMaintenanceInvoice, customerOnboarding: customerOnboarding, vendorOnboarding: vendorOnboarding]],
								outputStream // <- ataylor added this parameter
							).toByteArray()   // <- I added this
						}
					
						customerMaintenanceInvoice.fileUpload = mypdf
						customerMaintenanceInvoice.filename = filename
						
						try {
				            customerMaintenanceInvoiceService.save(customerMaintenanceInvoice)
				        } catch (ValidationException e) {
				            respond customerMaintenanceInvoice.errors, view:'show'
				            return
				        }
						
						response.contentType = 'application/pdf'
						//response.setHeader("Content-disposition", "attachment; filename=\"" + filename + "\"")
						
						response.outputStream << mypdf
						}
					}
				}
			}
		return
	}
	
    def save(CustomerMaintenanceInvoice customerMaintenanceInvoice) {
        if (customerMaintenanceInvoice == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceInvoiceService.save(customerMaintenanceInvoice)
        } catch (ValidationException e) {
            respond customerMaintenanceInvoice.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerMaintenanceInvoice.label', default: 'CustomerMaintenanceInvoice'), customerMaintenanceInvoice.id])
                redirect customerMaintenanceInvoice
            }
            '*' { respond customerMaintenanceInvoice, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerMaintenanceInvoiceService.get(id)
    }

    def update(CustomerMaintenanceInvoice customerMaintenanceInvoice) {
        if (customerMaintenanceInvoice == null) {
            notFound()
            return
        }

        try {
            customerMaintenanceInvoiceService.save(customerMaintenanceInvoice)
        } catch (ValidationException e) {
            respond customerMaintenanceInvoice.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerMaintenanceInvoice.label', default: 'CustomerMaintenanceInvoice'), customerMaintenanceInvoice.id])
                redirect customerMaintenanceInvoice
            }
            '*'{ respond customerMaintenanceInvoice, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerMaintenanceInvoiceService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerMaintenanceInvoice.label', default: 'CustomerMaintenanceInvoice'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerMaintenanceInvoice.label', default: 'CustomerMaintenanceInvoice'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
