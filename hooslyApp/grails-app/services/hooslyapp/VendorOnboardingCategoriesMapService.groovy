package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboardingCategoriesMap)
interface VendorOnboardingCategoriesMapService {

    VendorOnboardingCategoriesMap get(Serializable id)

    List<VendorOnboardingCategoriesMap> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboardingCategoriesMap save(VendorOnboardingCategoriesMap vendorOnboardingCategoriesMap)

}