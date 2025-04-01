package hooslyapp

import grails.gorm.services.Service

@Service(CustomerInvoice)
interface CustomerInvoiceService {

    CustomerInvoice get(Serializable id)

    List<CustomerInvoice> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerInvoice save(CustomerInvoice customerInvoice)

}