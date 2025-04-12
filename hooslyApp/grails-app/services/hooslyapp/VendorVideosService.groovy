package hooslyapp

import grails.gorm.services.Service

@Service(VendorVideos)
interface VendorVideosService {

    VendorVideos get(Serializable id)

    List<VendorVideos> list(Map args)

    Long count()

    void delete(Serializable id)

    VendorVideos save(VendorVideos vendorVideos)

}