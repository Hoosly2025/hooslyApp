package hooslyapp

import grails.gorm.services.Service

@Service(VendorPhotos)
interface VendorPhotosService {

    VendorPhotos get(Serializable id)

    List<VendorPhotos> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorPhotos save(VendorPhotos vendorPhotos)

}