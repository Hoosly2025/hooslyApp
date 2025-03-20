package hooslyapp

class CustomerMaintenanceType {

    String maintenanceType

    static constraints = {
		maintenanceType(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
