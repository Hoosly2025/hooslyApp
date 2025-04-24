package hooslyapp

import grails.gorm.services.Service

@Service(TaskStatus)
interface TaskStatusService {

    TaskStatus get(Serializable id)

    List<TaskStatus> list(Map args)

    Long count()

    void delete(Serializable id)

    TaskStatus save(TaskStatus taskStatus)

}