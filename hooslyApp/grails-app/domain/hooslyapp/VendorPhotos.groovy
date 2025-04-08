package hooslyapp

import security.*

class VendorPhotos {

    Date createTime
	String name
	String description
	Date updateTime
    Long vendor
	String filename
	byte[] fileUpload
	
    static constraints = {
		createTime(nullable:false)
        name(nullable:false, maxSize:500)
        description(nullable:true, maxSize:1000)
        updateTime(nullable:false)
        vendor(nullable:false)
		filename(nullable:true)
		fileUpload(nullable:true, maxSize: 1073741824)
    }
    
    static mapping = {
    	version false
    }
}
