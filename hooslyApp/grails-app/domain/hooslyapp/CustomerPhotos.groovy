package hooslyapp

import security.*

class CustomerPhotos {

	Date createTime
	String name
	String description
	Date updateTime
    Long customer
	byte[] imageOne
	byte[] imageTwo
	byte[] imageThree
	
    static constraints = {
		createTime(nullable:false)
        name(nullable:false, maxSize:500)
        description(nullable:true, maxSize:1000)
        updateTime(nullable:false)
        customer(nullable:false)
		imageOne(nullable:true, maxSize: 1024 * 1024 * 2)
		imageTwo(nullable:true, maxSize: 1024 * 1024 * 2)
		imageThree(nullable:true, maxSize: 1024 * 1024 * 2)
    }
    
    static mapping = {
    	version false
    }
}
