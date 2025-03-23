package hooslyapp

import grails.gorm.services.Service

@Service(VendorOnboardingCategories)
interface VendorOnboardingCategoriesService {

    VendorOnboardingCategories get(Serializable id)

    List<VendorOnboardingCategories> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorOnboardingCategories save(VendorOnboardingCategories vendorOnboardingCategories)

}