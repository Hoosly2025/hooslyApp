package hooslyapp

class VendorOnboardingServices {

    String onboardingServices

    static constraints = {
		onboardingServices(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
