package hooslyapp

import grails.gorm.services.Service

@Service(VendorSubscription)
interface VendorSubscriptionService {

    VendorSubscription get(Serializable id)

    List<VendorSubscription> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorSubscription save(VendorSubscription vendorSubscription)

}