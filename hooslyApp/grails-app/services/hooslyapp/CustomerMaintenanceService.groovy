package hooslyapp

import grails.gorm.services.Service

@Service(CustomerMaintenance)
interface CustomerMaintenanceService {

    CustomerMaintenance get(Serializable id)

    List<CustomerMaintenance> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerMaintenance save(CustomerMaintenance customerMaintenance)

}