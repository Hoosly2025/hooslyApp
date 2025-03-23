package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerSubscriptionCurrentPlanTypeServiceSpec extends Specification {

    CustomerSubscriptionCurrentPlanTypeService customerSubscriptionCurrentPlanTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //new CustomerSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType = new CustomerSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //new CustomerSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //new CustomerSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerSubscriptionCurrentPlanType.id
    }

    void "test get"() {
        setupData()

        expect:
        customerSubscriptionCurrentPlanTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerSubscriptionCurrentPlanType> customerSubscriptionCurrentPlanTypeList = customerSubscriptionCurrentPlanTypeService.list(max: 2, offset: 2)

        then:
        customerSubscriptionCurrentPlanTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerSubscriptionCurrentPlanTypeService.count() == 5
    }

    void "test delete"() {
        Long customerSubscriptionCurrentPlanTypeId = setupData()

        expect:
        customerSubscriptionCurrentPlanTypeService.count() == 5

        when:
        customerSubscriptionCurrentPlanTypeService.delete(customerSubscriptionCurrentPlanTypeId)
        sessionFactory.currentSession.flush()

        then:
        customerSubscriptionCurrentPlanTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerSubscriptionCurrentPlanType customerSubscriptionCurrentPlanType = new CustomerSubscriptionCurrentPlanType()
        customerSubscriptionCurrentPlanTypeService.save(customerSubscriptionCurrentPlanType)

        then:
        customerSubscriptionCurrentPlanType.id != null
    }
}
