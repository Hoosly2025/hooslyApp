package hooslyapp

import grails.gorm.services.Service

@Service(VendorInvoice)
interface VendorInvoiceService {

    VendorInvoice get(Serializable id)

    List<VendorInvoice> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorInvoice save(VendorInvoice vendorInvoice)

}