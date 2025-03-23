package hooslyapp

import grails.gorm.services.Service

@Service(VendorSubscriptionCurrentPlanType)
interface VendorSubscriptionCurrentPlanTypeService {

    VendorSubscriptionCurrentPlanType get(Serializable id)

    List<VendorSubscriptionCurrentPlanType> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorSubscriptionCurrentPlanType save(VendorSubscriptionCurrentPlanType vendorSubscriptionCurrentPlanType)

}