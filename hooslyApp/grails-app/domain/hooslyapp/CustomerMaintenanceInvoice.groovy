package hooslyapp

class CustomerMaintenanceInvoice {

    Date createTime
    String name
    String description
    Date updateTime
	String filename
	byte[] fileUpload
	Long customer
	String invoiceNumber
	CustomerMaintenance customerMaintenance
		
    static constraints = {
		createTime(nullable:false)
        name(nullable:false, maxSize:500)
        description(nullable:true, maxSize:50000)
        updateTime(nullable:false)
		filename(nullable:true)
		fileUpload(nullable:true, maxSize: 1073741824)
		customer(nullable:false)
		invoiceNumber(nullable:true)
		customerMaintenance(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
