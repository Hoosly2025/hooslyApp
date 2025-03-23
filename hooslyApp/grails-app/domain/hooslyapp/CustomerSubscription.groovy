package hooslyapp

class CustomerSubscription {

    CustomerOnboarding customerOnboarding

	//TODO: current plan type could be a drop down
    CustomerSubscriptionCurrentPlanType currentPlanType
    Date subscriptionStart
	Date renewal
	String paymentMethod
	Date lastPayment
	Date nextBilling
	
    static constraints = {
		customerOnboarding(nullable:false)
	    currentPlanType(nullable:false)
        subscriptionStart(nullable:false)
        renewal(nullable:false)	
		paymentMethod(nullable:false, maxSize:100)
        lastPayment(nullable:false)
        nextBilling(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
