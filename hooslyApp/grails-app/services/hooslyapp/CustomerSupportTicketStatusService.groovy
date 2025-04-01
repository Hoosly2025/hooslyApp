package hooslyapp

import grails.gorm.services.Service

@Service(CustomerSupportTicketStatus)
interface CustomerSupportTicketStatusService {

    CustomerSupportTicketStatus get(Serializable id)

    List<CustomerSupportTicketStatus> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerSupportTicketStatus save(CustomerSupportTicketStatus customerSupportTicketStatus)

}