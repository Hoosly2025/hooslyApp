package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerSubscriptionServiceSpec extends Specification {

    CustomerSubscriptionService customerSubscriptionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerSubscription(...).save(flush: true, failOnError: true)
        //new CustomerSubscription(...).save(flush: true, failOnError: true)
        //CustomerSubscription customerSubscription = new CustomerSubscription(...).save(flush: true, failOnError: true)
        //new CustomerSubscription(...).save(flush: true, failOnError: true)
        //new CustomerSubscription(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerSubscription.id
    }

    void "test get"() {
        setupData()

        expect:
        customerSubscriptionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerSubscription> customerSubscriptionList = customerSubscriptionService.list(max: 2, offset: 2)

        then:
        customerSubscriptionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerSubscriptionService.count() == 5
    }

    void "test delete"() {
        Long customerSubscriptionId = setupData()

        expect:
        customerSubscriptionService.count() == 5

        when:
        customerSubscriptionService.delete(customerSubscriptionId)
        sessionFactory.currentSession.flush()

        then:
        customerSubscriptionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerSubscription customerSubscription = new CustomerSubscription()
        customerSubscriptionService.save(customerSubscription)

        then:
        customerSubscription.id != null
    }
}
