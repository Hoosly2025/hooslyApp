package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerMaintenancePhotosServiceSpec extends Specification {

    CustomerMaintenancePhotosService customerMaintenancePhotosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerMaintenancePhotos(...).save(flush: true, failOnError: true)
        //new CustomerMaintenancePhotos(...).save(flush: true, failOnError: true)
        //CustomerMaintenancePhotos customerMaintenancePhotos = new CustomerMaintenancePhotos(...).save(flush: true, failOnError: true)
        //new CustomerMaintenancePhotos(...).save(flush: true, failOnError: true)
        //new CustomerMaintenancePhotos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerMaintenancePhotos.id
    }

    void "test get"() {
        setupData()

        expect:
        customerMaintenancePhotosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerMaintenancePhotos> customerMaintenancePhotosList = customerMaintenancePhotosService.list(max: 2, offset: 2)

        then:
        customerMaintenancePhotosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerMaintenancePhotosService.count() == 5
    }

    void "test delete"() {
        Long customerMaintenancePhotosId = setupData()

        expect:
        customerMaintenancePhotosService.count() == 5

        when:
        customerMaintenancePhotosService.delete(customerMaintenancePhotosId)
        sessionFactory.currentSession.flush()

        then:
        customerMaintenancePhotosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerMaintenancePhotos customerMaintenancePhotos = new CustomerMaintenancePhotos()
        customerMaintenancePhotosService.save(customerMaintenancePhotos)

        then:
        customerMaintenancePhotos.id != null
    }
}
