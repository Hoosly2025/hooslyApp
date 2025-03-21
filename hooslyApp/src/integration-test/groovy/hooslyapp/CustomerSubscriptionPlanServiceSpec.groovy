package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerSubscriptionPlanServiceSpec extends Specification {

    CustomerSubscriptionPlanService customerSubscriptionPlanService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerSubscriptionPlan(...).save(flush: true, failOnError: true)
        //new CustomerSubscriptionPlan(...).save(flush: true, failOnError: true)
        //CustomerSubscriptionPlan customerSubscriptionPlan = new CustomerSubscriptionPlan(...).save(flush: true, failOnError: true)
        //new CustomerSubscriptionPlan(...).save(flush: true, failOnError: true)
        //new CustomerSubscriptionPlan(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerSubscriptionPlan.id
    }

    void "test get"() {
        setupData()

        expect:
        customerSubscriptionPlanService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerSubscriptionPlan> customerSubscriptionPlanList = customerSubscriptionPlanService.list(max: 2, offset: 2)

        then:
        customerSubscriptionPlanList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerSubscriptionPlanService.count() == 5
    }

    void "test delete"() {
        Long customerSubscriptionPlanId = setupData()

        expect:
        customerSubscriptionPlanService.count() == 5

        when:
        customerSubscriptionPlanService.delete(customerSubscriptionPlanId)
        sessionFactory.currentSession.flush()

        then:
        customerSubscriptionPlanService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerSubscriptionPlan customerSubscriptionPlan = new CustomerSubscriptionPlan()
        customerSubscriptionPlanService.save(customerSubscriptionPlan)

        then:
        customerSubscriptionPlan.id != null
    }
}
