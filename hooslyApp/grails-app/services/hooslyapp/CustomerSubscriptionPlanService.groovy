package hooslyapp

import grails.gorm.services.Service

@Service(CustomerSubscriptionPlan)
interface CustomerSubscriptionPlanService {

    CustomerSubscriptionPlan get(Serializable id)

    List<CustomerSubscriptionPlan> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerSubscriptionPlan save(CustomerSubscriptionPlan customerSubscriptionPlan)

}