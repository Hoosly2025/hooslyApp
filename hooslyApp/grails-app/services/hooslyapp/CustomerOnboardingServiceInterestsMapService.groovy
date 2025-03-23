package hooslyapp

import grails.gorm.services.Service

@Service(CustomerOnboardingServiceInterestsMap)
interface CustomerOnboardingServiceInterestsMapService {

    CustomerOnboardingServiceInterestsMap get(Serializable id)

    List<CustomerOnboardingServiceInterestsMap> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerOnboardingServiceInterestsMap save(CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap)

}