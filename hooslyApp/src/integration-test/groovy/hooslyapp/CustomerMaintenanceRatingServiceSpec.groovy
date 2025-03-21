package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerMaintenanceRatingServiceSpec extends Specification {

    CustomerMaintenanceRatingService customerMaintenanceRatingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerMaintenanceRating(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceRating(...).save(flush: true, failOnError: true)
        //CustomerMaintenanceRating customerMaintenanceRating = new CustomerMaintenanceRating(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceRating(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceRating(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerMaintenanceRating.id
    }

    void "test get"() {
        setupData()

        expect:
        customerMaintenanceRatingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerMaintenanceRating> customerMaintenanceRatingList = customerMaintenanceRatingService.list(max: 2, offset: 2)

        then:
        customerMaintenanceRatingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerMaintenanceRatingService.count() == 5
    }

    void "test delete"() {
        Long customerMaintenanceRatingId = setupData()

        expect:
        customerMaintenanceRatingService.count() == 5

        when:
        customerMaintenanceRatingService.delete(customerMaintenanceRatingId)
        sessionFactory.currentSession.flush()

        then:
        customerMaintenanceRatingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerMaintenanceRating customerMaintenanceRating = new CustomerMaintenanceRating()
        customerMaintenanceRatingService.save(customerMaintenanceRating)

        then:
        customerMaintenanceRating.id != null
    }
}
