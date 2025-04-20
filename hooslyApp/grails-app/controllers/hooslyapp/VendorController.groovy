package hooslyapp

import security.*

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorController {

	VendorCertificationsService vendorCertificationsService
	VendorLicensesService vendorLicensesService
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() { 
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
	        def userDetails = authentication.getPrincipal()
	
	        // Access user details
	        def userId = userDetails.id
	        
	    	def vendorOnboarding = VendorOnboarding.findByVendor(userId)
	    	def vendorSubscription = VendorSubscription.findByVendor(userId)
		    
		    def vendorSubscriptionCurrentPlanType
		    
		    if (vendorSubscription != null) {
				vendorSubscriptionCurrentPlanType = VendorSubscriptionCurrentPlanType.findByVendorSubscription(vendorSubscription.id)
			}
		    respond userDetails, model:[vendorOnboarding: vendorOnboarding, vendorSubscription: vendorSubscription, vendorSubscriptionCurrentPlanType: vendorSubscriptionCurrentPlanType]
		}
	}
    
    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS', 'ROLE_USER'])
    def profile(Long id) {
		def vendorOnboarding = VendorOnboarding.findByVendor(id)
		
		def vendorPhotos = VendorPhotos.findAllByVendor(id)
		def vendorVideos = VendorVideos.findAllByVendor(id)
		
		def vendorCertifications = VendorCertifications.findAllByVendor(id)
		def vendorLicenses = VendorLicenses.findAllByVendor(id)
		
		respond vendorOnboarding, model:[vendorPhotos: vendorPhotos, vendorVideos: vendorVideos, vendorCertifications: vendorCertifications, vendorLicenses: vendorLicenses]
		//find photos with user id
		
		//find videos with user id
		//find certifications & licenses for user id
		
		//allow rating
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def downloadLicense(long id) {
		VendorLicenses vendorLicensesInstance = vendorLicensesService.get(id)
		if ( vendorLicensesInstance == null) {
			flash.message = "Vendor Licenses not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${vendorLicensesInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << vendorLicensesInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def downloadCertification(long id) {
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
}
