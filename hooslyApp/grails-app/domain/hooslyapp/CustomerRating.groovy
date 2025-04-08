package hooslyapp

class CustomerRating {

    Long customer
	Long reviewer
    Integer maintenanceRating
	String maintenanceReview
	
    static constraints = {
		customer(nullable:false)
		reviewer(nullable:false)
		maintenanceRating(nullable:true)
		maintenanceReview(nullable:true, maxSize:500)
    }
    
    static mapping = {
    	version false
    }
}
