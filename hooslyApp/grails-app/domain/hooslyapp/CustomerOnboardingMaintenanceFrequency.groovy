package hooslyapp

class CustomerOnboardingMaintenanceFrequency {

    String maintenanceFrequency

    static constraints = {
		maintenanceFrequency(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
