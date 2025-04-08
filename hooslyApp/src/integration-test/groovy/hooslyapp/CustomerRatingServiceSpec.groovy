package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerRatingServiceSpec extends Specification {

    CustomerRatingService customerRatingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerRating(...).save(flush: true, failOnError: true)
        //new CustomerRating(...).save(flush: true, failOnError: true)
        //CustomerRating customerRating = new CustomerRating(...).save(flush: true, failOnError: true)
        //new CustomerRating(...).save(flush: true, failOnError: true)
        //new CustomerRating(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerRating.id
    }

    void "test get"() {
        setupData()

        expect:
        customerRatingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerRating> customerRatingList = customerRatingService.list(max: 2, offset: 2)

        then:
        customerRatingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerRatingService.count() == 5
    }

    void "test delete"() {
        Long customerRatingId = setupData()

        expect:
        customerRatingService.count() == 5

        when:
        customerRatingService.delete(customerRatingId)
        sessionFactory.currentSession.flush()

        then:
        customerRatingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerRating customerRating = new CustomerRating()
        customerRatingService.save(customerRating)

        then:
        customerRating.id != null
    }
}
