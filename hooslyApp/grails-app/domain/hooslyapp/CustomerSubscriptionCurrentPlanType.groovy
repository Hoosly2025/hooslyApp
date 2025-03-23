package hooslyapp

class CustomerSubscriptionCurrentPlanType {

    CustomerSubscriptionPlan planType
	Date subscriptionEnd
	Boolean autoRenew

    static constraints = {
		planType(nullable:false)
		subscriptionEnd(nullable:true)
		autoRenew(nullable:true)
		
    }
    
    static mapping = {
    	version false
    }
}
