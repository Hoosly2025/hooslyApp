package hooslyapp

import grails.gorm.services.Service

@Service(VendorRating)
interface VendorRatingService {

    VendorRating get(Serializable id)

    List<VendorRating> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorRating save(VendorRating vendorRating)

}