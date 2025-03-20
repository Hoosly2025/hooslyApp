package hooslyapp

import grails.gorm.services.Service

@Service(CustomerMaintenanceType)
interface CustomerMaintenanceTypeService {

    CustomerMaintenanceType get(Serializable id)

    List<CustomerMaintenanceType> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerMaintenanceType save(CustomerMaintenanceType customerMaintenanceType)

}