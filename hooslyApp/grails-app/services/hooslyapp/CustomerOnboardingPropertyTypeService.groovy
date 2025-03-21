package hooslyapp

import grails.gorm.services.Service

@Service(CustomerOnboardingPropertyType)
interface CustomerOnboardingPropertyTypeService {

    CustomerOnboardingPropertyType get(Serializable id)

    List<CustomerOnboardingPropertyType> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerOnboardingPropertyType save(CustomerOnboardingPropertyType customerOnboardingPropertyType)

}