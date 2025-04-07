package hooslyapp

import security.*

class CustomerSupportTicket {

    Date createTime
	String name
	String description
	Date updateTime
    Long creator
    User assignee
    CustomerSupportTicketStatus ticketStatus
	
    static constraints = {
		createTime(nullable:false)
        name(nullable:false, maxSize:500)
        description(nullable:true, maxSize:1000)
        updateTime(nullable:false)
        creator(nullable:false)
        assignee(nullable:false)
        ticketStatus(nullable:false)
    }
    
    static mapping = {
    	version false
    }
}
