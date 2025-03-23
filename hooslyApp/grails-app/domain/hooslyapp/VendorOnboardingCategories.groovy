package hooslyapp

class VendorOnboardingCategories {

    String onboardingCategories

    static constraints = {
		onboardingCategories(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
