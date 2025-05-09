package hooslyapp

import security.*

class VendorInvoice {

    Date createTime
    String name
    String description
    Date updateTime
	String filename
	byte[] fileUpload
	Long vendor
	String invoiceNumber
		
    static constraints = {
		createTime(nullable:false)
        name(nullable:false, maxSize:500)
        description(nullable:true, maxSize:50000)
        updateTime(nullable:false)
		filename(nullable:true)
		fileUpload(nullable:true, maxSize: 1073741824)
		vendor(nullable:false)
		invoiceNumber(nullable:true)
    }
    
    static mapping = {
    	version false
    }
}
