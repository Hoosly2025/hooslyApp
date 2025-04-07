package hooslyapp

class VendorSubscriptionCurrentPlanType {

	Long vendorSubscription
    VendorSubscriptionPlan planType
	Date subscriptionEnd
	Boolean autoRenew
	
    static constraints = {
		vendorSubscription(nullable:false)
		planType(nullable:false)
		subscriptionEnd(nullable:true)
		autoRenew(nullable:true)
    }
    
    static mapping = {
    	version false
    }
}
