package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboardingServiceArea)
interface VendorOnboardingServiceAreaService {

    VendorOnboardingServiceArea get(Serializable id)

    List<VendorOnboardingServiceArea> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboardingServiceArea save(VendorOnboardingServiceArea vendorOnboardingServiceArea)

}