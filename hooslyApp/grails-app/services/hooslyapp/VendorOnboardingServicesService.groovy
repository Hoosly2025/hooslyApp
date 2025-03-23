package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboardingServices)
interface VendorOnboardingServicesService {

    VendorOnboardingServices get(Serializable id)

    List<VendorOnboardingServices> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboardingServices save(VendorOnboardingServices vendorOnboardingServices)

}