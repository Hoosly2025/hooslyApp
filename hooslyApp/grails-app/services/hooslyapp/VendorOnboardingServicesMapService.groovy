package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboardingServicesMap)
interface VendorOnboardingServicesMapService {

    VendorOnboardingServicesMap get(Serializable id)

    List<VendorOnboardingServicesMap> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboardingServicesMap save(VendorOnboardingServicesMap vendorOnboardingServicesMap)

}