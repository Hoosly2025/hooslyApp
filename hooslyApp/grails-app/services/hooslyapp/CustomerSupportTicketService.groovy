package hooslyapp

import grails.gorm.services.Service

@Service(CustomerSupportTicket)
interface CustomerSupportTicketService {

    CustomerSupportTicket get(Serializable id)

    List<CustomerSupportTicket> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerSupportTicket save(CustomerSupportTicket customerSupportTicket)

}