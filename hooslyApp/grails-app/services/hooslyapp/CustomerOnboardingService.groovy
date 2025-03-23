package hooslyapp

import grails.gorm.services.Service

@Service(CustomerOnboarding)
interface CustomerOnboardingService {

    CustomerOnboarding get(Serializable id)

    List<CustomerOnboarding> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerOnboarding save(CustomerOnboarding customerOnboarding)

}