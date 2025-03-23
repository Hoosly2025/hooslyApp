package hooslyapp

import grails.gorm.services.Service

@Service(CustomerSubscription)
interface CustomerSubscriptionService {

    CustomerSubscription get(Serializable id)

    List<CustomerSubscription> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerSubscription save(CustomerSubscription customerSubscription)

}