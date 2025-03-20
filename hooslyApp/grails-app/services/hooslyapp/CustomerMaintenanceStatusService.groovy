package hooslyapp

import grails.gorm.services.Service

@Service(CustomerMaintenanceStatus)
interface CustomerMaintenanceStatusService {

    CustomerMaintenanceStatus get(Serializable id)

    List<CustomerMaintenanceStatus> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerMaintenanceStatus save(CustomerMaintenanceStatus customerMaintenanceStatus)

}