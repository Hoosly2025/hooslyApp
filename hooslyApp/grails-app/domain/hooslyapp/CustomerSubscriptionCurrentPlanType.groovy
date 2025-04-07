package hooslyapp

class CustomerSubscriptionCurrentPlanType {

	Long customerSubscription
    CustomerSubscriptionPlan planType
	Date subscriptionEnd
	Boolean autoRenew

    static constraints = {
		customerSubscription(nullable:false)
		planType(nullable:false)
		subscriptionEnd(nullable:true)
		autoRenew(nullable:true)
		
    }
    
    static mapping = {
    	version false
    }
}
