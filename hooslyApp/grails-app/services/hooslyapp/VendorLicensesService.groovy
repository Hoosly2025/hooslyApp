package hooslyapp

import grails.gorm.services.Service

@Service(VendorLicenses)
interface VendorLicensesService {

    VendorLicenses get(Serializable id)

    List<VendorLicenses> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorLicenses save(VendorLicenses vendorLicenses)

}