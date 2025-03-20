package hooslyapp

class CustomerMaintenanceStatus {

	String maintenanceStatus

    static constraints = {
		maintenanceStatus(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
