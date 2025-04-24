package hooslyapp

import grails.gorm.services.Service

@Service(Doc)
interface DocService {

    Doc get(Serializable id)

    List<Doc> list(Map args)

    Long count()

    void delete(Serializable id)

    Doc save(Doc doc)

}