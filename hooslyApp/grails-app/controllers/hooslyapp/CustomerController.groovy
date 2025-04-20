package hooslyapp

import security.*

import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerController {

	@Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def index() { 
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
	        def userDetails = authentication.getPrincipal()
	
	        // Access user details
	        def userId = userDetails.id
	        
	    	def customerOnboarding = CustomerOnboarding.findByCustomer(userId)
	    	def customerSubscription = CustomerSubscription.findByCustomer(userId)
		    
		    def customerSubscriptionCurrentPlanType
		    
		    if (customerSubscription != null) {
				customerSubscriptionCurrentPlanType = CustomerSubscriptionCurrentPlanType.findByCustomerSubscription(customerSubscription.id)
			}
		    respond userDetails, model:[customerOnboarding: customerOnboarding, customerSubscription: customerSubscription, customerSubscriptionCurrentPlanType: customerSubscriptionCurrentPlanType]
		}
	}
    
    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS', 'ROLE_USER'])
    def profile(Long id) {
		def customerOnboarding = CustomerOnboarding.findByCustomer(id)
		
		def customerPhotos = CustomerPhotos.findAllByCustomer(id)
		def customerVideos = CustomerVideos.findAllByCustomer(id)
		
		respond customerOnboarding, model:[customerPhotos: customerPhotos, customerVideos: customerVideos]
		
		//find photos with user id
		
		//find videos with user id
		
		//allow rating
	}
}
