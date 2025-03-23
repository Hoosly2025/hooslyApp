package hooslyapp

class VendorOnboardingServiceArea {

    String serviceArea

    static constraints = {
		serviceArea(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
