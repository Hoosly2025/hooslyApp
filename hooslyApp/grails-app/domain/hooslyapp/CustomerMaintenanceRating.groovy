package hooslyapp

import security.*

class CustomerMaintenanceRating {

	Long customerMaintenance
	Long reviewer
    Integer maintenanceRating
	String maintenanceReview
	
    static constraints = {
		customerMaintenance(nullable:false)
		reviewer(nullable:false)
		maintenanceRating(nullable:true)
		maintenanceReview(nullable:true, maxSize:500)
    }
    
    static mapping = {
    	version false
    }
}
