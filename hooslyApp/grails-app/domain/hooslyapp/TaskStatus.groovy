package hooslyapp

class TaskStatus {

    String status

    static constraints = {
		status(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
