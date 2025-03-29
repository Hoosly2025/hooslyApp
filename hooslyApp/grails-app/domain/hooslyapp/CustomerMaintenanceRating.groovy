package hooslyapp

import security.*

class CustomerMaintenanceRating {

	CustomerMaintenance customerMaintenance
	User reviewer
    Integer maintenanceRating
	String maintenanceReview
	
    static constraints = {
		customerMaintenance(nullable:true)
		reviewer(nullable:true)
		maintenanceRating(nullable:true)
		maintenanceReview(nullable:true, maxSize:500)
    }
    
    static mapping = {
    	version false
    }
}
