package hooslyapp

class CustomerMaintenanceRating {

    Integer maintenanceRating
	String maintenanceReview
	
    static constraints = {
		maintenanceRating(nullable:true)
		maintenanceReview(nullable:true, maxSize:500)
    }
    
    static mapping = {
    	version false
    }
}
