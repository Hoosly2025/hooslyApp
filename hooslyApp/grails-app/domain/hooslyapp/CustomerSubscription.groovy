package hooslyapp

class CustomerSubscription {

    CustomerOnboarding customerOnboarding

	Date subscriptionStart
	Date renewal
	String paymentMethod
	Date lastPayment
	Date nextBilling
	
    static constraints = {
		customerOnboarding(nullable:false)
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
