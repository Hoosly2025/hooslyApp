package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerPhotosServiceSpec extends Specification {

    CustomerPhotosService customerPhotosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerPhotos(...).save(flush: true, failOnError: true)
        //new CustomerPhotos(...).save(flush: true, failOnError: true)
        //CustomerPhotos customerPhotos = new CustomerPhotos(...).save(flush: true, failOnError: true)
        //new CustomerPhotos(...).save(flush: true, failOnError: true)
        //new CustomerPhotos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerPhotos.id
    }

    void "test get"() {
        setupData()

        expect:
        customerPhotosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerPhotos> customerPhotosList = customerPhotosService.list(max: 2, offset: 2)

        then:
        customerPhotosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerPhotosService.count() == 5
    }

    void "test delete"() {
        Long customerPhotosId = setupData()

        expect:
        customerPhotosService.count() == 5

        when:
        customerPhotosService.delete(customerPhotosId)
        sessionFactory.currentSession.flush()

        then:
        customerPhotosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerPhotos customerPhotos = new CustomerPhotos()
        customerPhotosService.save(customerPhotos)

        then:
        customerPhotos.id != null
    }
}
