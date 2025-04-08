package hooslyapp

import grails.gorm.services.Service

@Service(CustomerRating)
interface CustomerRatingService {

    CustomerRating get(Serializable id)

    List<CustomerRating> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerRating save(CustomerRating customerRating)

}