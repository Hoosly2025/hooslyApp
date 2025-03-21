package hooslyapp

class VendorSubscriptionPlan {

    String planName
	Double planFee
	Integer planDays
	String planDescription
	
    static constraints = {
		planName(nullable:false)
		planFee(nullable:true)
		planDays(nullable:false)
		planDescription(nullable:false, maxSize:500)
    }
    
    static mapping = {
    	version false
    }
}
