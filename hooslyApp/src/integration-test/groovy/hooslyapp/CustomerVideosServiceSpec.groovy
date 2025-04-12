package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerVideosServiceSpec extends Specification {

    CustomerVideosService customerVideosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerVideos(...).save(flush: true, failOnError: true)
        //new CustomerVideos(...).save(flush: true, failOnError: true)
        //CustomerVideos customerVideos = new CustomerVideos(...).save(flush: true, failOnError: true)
        //new CustomerVideos(...).save(flush: true, failOnError: true)
        //new CustomerVideos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerVideos.id
    }

    void "test get"() {
        setupData()

        expect:
        customerVideosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerVideos> customerVideosList = customerVideosService.list(max: 2, offset: 2)

        then:
        customerVideosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerVideosService.count() == 5
    }

    void "test delete"() {
        Long customerVideosId = setupData()

        expect:
        customerVideosService.count() == 5

        when:
        customerVideosService.delete(customerVideosId)
        sessionFactory.currentSession.flush()

        then:
        customerVideosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerVideos customerVideos = new CustomerVideos()
        customerVideosService.save(customerVideos)

        then:
        customerVideos.id != null
    }
}
