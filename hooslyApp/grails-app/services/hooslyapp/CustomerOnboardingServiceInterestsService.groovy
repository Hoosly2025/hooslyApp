package hooslyapp

import grails.gorm.services.Service

@Service(CustomerOnboardingServiceInterests)
interface CustomerOnboardingServiceInterestsService {

    CustomerOnboardingServiceInterests get(Serializable id)

    List<CustomerOnboardingServiceInterests> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerOnboardingServiceInterests save(CustomerOnboardingServiceInterests customerOnboardingServiceInterests)

}