package hooslyapp

class CustomerOnboardingPropertyType {

    String propertyType
	
    static constraints = {
		propertyType(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
