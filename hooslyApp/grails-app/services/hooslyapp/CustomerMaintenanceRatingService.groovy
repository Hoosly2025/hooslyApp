package hooslyapp

import grails.gorm.services.Service

@Service(CustomerMaintenanceRating)
interface CustomerMaintenanceRatingService {

    CustomerMaintenanceRating get(Serializable id)

    List<CustomerMaintenanceRating> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerMaintenanceRating save(CustomerMaintenanceRating customerMaintenanceRating)

}