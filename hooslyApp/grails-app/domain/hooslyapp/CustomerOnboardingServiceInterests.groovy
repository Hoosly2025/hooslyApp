package hooslyapp

class CustomerOnboardingServiceInterests {

    String serviceInterest

    static constraints = {
		serviceInterest(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
