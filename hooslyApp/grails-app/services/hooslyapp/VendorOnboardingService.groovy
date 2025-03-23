package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboarding)
interface VendorOnboardingService {

    VendorOnboarding get(Serializable id)

    List<VendorOnboarding> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboarding save(VendorOnboarding vendorOnboarding)

}