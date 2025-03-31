package hooslyapp

import grails.gorm.services.Service

@Service(CustomerPhotos)
interface CustomerPhotosService {

    CustomerPhotos get(Serializable id)

    List<CustomerPhotos> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerPhotos save(CustomerPhotos customerPhotos)

}