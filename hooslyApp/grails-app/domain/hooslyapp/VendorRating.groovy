package hooslyapp

class VendorRating {

    Long vendor
	Long reviewer
    Integer maintenanceRating
	String maintenanceReview
	
    static constraints = {
		vendor(nullable:false)
		reviewer(nullable:false)
		maintenanceRating(nullable:true)
		maintenanceReview(nullable:true, maxSize:500)
    }
    
    static mapping = {
    	version false
    }
}
