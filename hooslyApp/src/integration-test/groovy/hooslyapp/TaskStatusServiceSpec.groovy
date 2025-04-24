package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class TaskStatusServiceSpec extends Specification {

    TaskStatusService taskStatusService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new TaskStatus(...).save(flush: true, failOnError: true)
        //new TaskStatus(...).save(flush: true, failOnError: true)
        //TaskStatus taskStatus = new TaskStatus(...).save(flush: true, failOnError: true)
        //new TaskStatus(...).save(flush: true, failOnError: true)
        //new TaskStatus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //taskStatus.id
    }

    void "test get"() {
        setupData()

        expect:
        taskStatusService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<TaskStatus> taskStatusList = taskStatusService.list(max: 2, offset: 2)

        then:
        taskStatusList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        taskStatusService.count() == 5
    }

    void "test delete"() {
        Long taskStatusId = setupData()

        expect:
        taskStatusService.count() == 5

        when:
        taskStatusService.delete(taskStatusId)
        sessionFactory.currentSession.flush()

        then:
        taskStatusService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        TaskStatus taskStatus = new TaskStatus()
        taskStatusService.save(taskStatus)

        then:
        taskStatus.id != null
    }
}
