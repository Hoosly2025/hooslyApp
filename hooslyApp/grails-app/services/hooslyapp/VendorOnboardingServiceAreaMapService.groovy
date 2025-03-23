package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboardingServiceAreaMap)
interface VendorOnboardingServiceAreaMapService {

    VendorOnboardingServiceAreaMap get(Serializable id)

    List<VendorOnboardingServiceAreaMap> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboardingServiceAreaMap save(VendorOnboardingServiceAreaMap vendorOnboardingServiceAreaMap)

}