package hooslyapp

class CustomerSupportTicketStatus {

    String ticketStatus

    static constraints = {
		ticketStatus(nullable:false, maxSize:100)
    }
    
    static mapping = {
    	version false
    }
}
