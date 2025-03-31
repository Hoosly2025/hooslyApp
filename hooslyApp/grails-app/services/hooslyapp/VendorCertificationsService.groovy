package hooslyapp

import grails.gorm.services.Service

@Service(VendorCertifications)
interface VendorCertificationsService {

    VendorCertifications get(Serializable id)

    List<VendorCertifications> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorCertifications save(VendorCertifications vendorCertifications)

}