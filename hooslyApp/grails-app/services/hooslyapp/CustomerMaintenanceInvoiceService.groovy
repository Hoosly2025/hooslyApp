package hooslyapp

import grails.gorm.services.Service

@Service(CustomerMaintenanceInvoice)
interface CustomerMaintenanceInvoiceService {

    CustomerMaintenanceInvoice get(Serializable id)

    List<CustomerMaintenanceInvoice> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerMaintenanceInvoice save(CustomerMaintenanceInvoice customerMaintenanceInvoice)

}