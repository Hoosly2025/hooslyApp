package hooslyapp

import grails.gorm.services.Service

@Service(VendorSubscriptionPlan)
interface VendorSubscriptionPlanService {

    VendorSubscriptionPlan get(Serializable id)

    List<VendorSubscriptionPlan> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorSubscriptionPlan save(VendorSubscriptionPlan vendorSubscriptionPlan)

}