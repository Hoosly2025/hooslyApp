package hooslyapp

import grails.gorm.services.Service

@Service(CustomerMaintenancePhotos)
interface CustomerMaintenancePhotosService {

    CustomerMaintenancePhotos get(Serializable id)

    List<CustomerMaintenancePhotos> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerMaintenancePhotos save(CustomerMaintenancePhotos customerMaintenancePhotos)

}