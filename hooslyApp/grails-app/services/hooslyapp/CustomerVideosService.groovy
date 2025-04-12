package hooslyapp

import grails.gorm.services.Service

@Service(CustomerVideos)
interface CustomerVideosService {

    CustomerVideos get(Serializable id)

    List<CustomerVideos> list(Map args)

    Long count()

    void delete(Serializable id)

    CustomerVideos save(CustomerVideos customerVideos)

}