package hooslyapp

import security.*

class CustomerOnboarding {

	User customer
    String firstName
	String lastName
	String phone
	String streetAddress
	String city
	String state
	String zipCode
	
	//TODO: property type could be a drop down
	CustomerOnboardingPropertyType propertyType
	String propertySize
	String numberOfUnits
	
	//TODO: drop down
	CustomerOnboardingMaintenanceFrequency frequencyMaintenance
	
	//TODO: service interests could be a drop down, list of check boxes
	//CustomerOnboardingServiceInterestsMap serviceInterests
	Date createTime
	Date updateTime
	
    static constraints = {
		customer(nullable:false)
		firstName(nullable:false, maxSize:500)
        lastName(nullable:false, maxSize:500)
        phone(nullable:false, maxSize:50)
        streetAddress(nullable:false, maxSize:100)
        city(nullable:false, maxSize:50)
        state(nullable:false, maxSize:50)
        zipCode(nullable:false, maxSize:50)
        propertyType(nullable:false)
        propertySize(nullable:false, maxSize:50)
        numberOfUnits(nullable:true, maxSize:50)
        frequencyMaintenance(nullable:false)
        //serviceInterests(nullable:false)
        createTime(nullable:false)
        updateTime(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
