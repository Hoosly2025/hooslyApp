package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorSubscriptionPlanServiceSpec extends Specification {

    VendorSubscriptionPlanService vendorSubscriptionPlanService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorSubscriptionPlan(...).save(flush: true, failOnError: true)
        //new VendorSubscriptionPlan(...).save(flush: true, failOnError: true)
        //VendorSubscriptionPlan vendorSubscriptionPlan = new VendorSubscriptionPlan(...).save(flush: true, failOnError: true)
        //new VendorSubscriptionPlan(...).save(flush: true, failOnError: true)
        //new VendorSubscriptionPlan(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorSubscriptionPlan.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorSubscriptionPlanService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorSubscriptionPlan> vendorSubscriptionPlanList = vendorSubscriptionPlanService.list(max: 2, offset: 2)

        then:
        vendorSubscriptionPlanList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorSubscriptionPlanService.count() == 5
    }

    void "test delete"() {
        Long vendorSubscriptionPlanId = setupData()

        expect:
        vendorSubscriptionPlanService.count() == 5

        when:
        vendorSubscriptionPlanService.delete(vendorSubscriptionPlanId)
        sessionFactory.currentSession.flush()

        then:
        vendorSubscriptionPlanService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorSubscriptionPlan vendorSubscriptionPlan = new VendorSubscriptionPlan()
        vendorSubscriptionPlanService.save(vendorSubscriptionPlan)

        then:
        vendorSubscriptionPlan.id != null
    }
}
