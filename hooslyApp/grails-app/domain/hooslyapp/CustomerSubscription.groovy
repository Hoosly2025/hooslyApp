package hooslyapp

import security.*

class CustomerSubscription {

    Long customerId

	Date subscriptionStart
	Date renewal
	String paymentMethod
	Date lastPayment
	Date nextBilling
	
    static constraints = {
		customerId(nullable:false)
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
