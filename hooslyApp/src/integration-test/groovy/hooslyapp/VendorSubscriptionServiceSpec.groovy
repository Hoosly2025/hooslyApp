package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorSubscriptionServiceSpec extends Specification {

    VendorSubscriptionService vendorSubscriptionService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorSubscription(...).save(flush: true, failOnError: true)
        //new VendorSubscription(...).save(flush: true, failOnError: true)
        //VendorSubscription vendorSubscription = new VendorSubscription(...).save(flush: true, failOnError: true)
        //new VendorSubscription(...).save(flush: true, failOnError: true)
        //new VendorSubscription(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorSubscription.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorSubscriptionService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorSubscription> vendorSubscriptionList = vendorSubscriptionService.list(max: 2, offset: 2)

        then:
        vendorSubscriptionList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorSubscriptionService.count() == 5
    }

    void "test delete"() {
        Long vendorSubscriptionId = setupData()

        expect:
        vendorSubscriptionService.count() == 5

        when:
        vendorSubscriptionService.delete(vendorSubscriptionId)
        sessionFactory.currentSession.flush()

        then:
        vendorSubscriptionService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorSubscription vendorSubscription = new VendorSubscription()
        vendorSubscriptionService.save(vendorSubscription)

        then:
        vendorSubscription.id != null
    }
}
