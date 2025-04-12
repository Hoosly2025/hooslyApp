package hooslyapp

class CustomerVideos {

    Date createTime
	String name
	String description
	Date updateTime
    Long customer
	String video
	
    static constraints = {
		createTime(nullable:false)
        name(nullable:false, maxSize:500)
        description(nullable:true, maxSize:1000)
        updateTime(nullable:false)
        customer(nullable:false)
		video(nullable:true)
    }
    
    static mapping = {
    	version false
    }
}
