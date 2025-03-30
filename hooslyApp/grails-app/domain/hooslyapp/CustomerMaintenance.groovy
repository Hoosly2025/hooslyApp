package hooslyapp

import security.*

class CustomerMaintenance {

	User customerOnboarding
    User vendorOnboarding
    
    //TODO: Maintenance Type
    CustomerMaintenanceType maintenanceType
    String maintenanceDetails
    
    //TODO: Maintenance Status, Open, in progress, completed
    CustomerMaintenanceStatus maintenanceStatus
    
    Date maintenanceRequestDate
    Date maintenanceScheduledDate
    Date maintenanceCompletionDate
    
    Double costDetails
    
    static constraints = {
		customerOnboarding(nullable:false)
		vendorOnboarding(nullable:true)
	    maintenanceType(nullable:false)
        maintenanceDetails(nullable:false, maxSize:500)
        maintenanceStatus(nullable:false)	
		maintenanceRequestDate(nullable:false)
        maintenanceScheduledDate(nullable:false)
        maintenanceCompletionDate(nullable:false)
        costDetails(nullable:true)
        
    }
    
    static mapping = {
    	version false
    }
}
