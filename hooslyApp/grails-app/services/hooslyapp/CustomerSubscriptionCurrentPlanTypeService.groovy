package hooslyapp

import grails.gorm.services.Service

@Service(CustomerSubscriptionCurrentPlanType)
interface CustomerSubscriptionCurrentPlanTypeService {

    CustomerSubscriptionCurrentPlanType get(Serializable id)

    List<CustomerSubscriptionCurrentPlanType> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerSubscriptionCurrentPlanType save(CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType)

}