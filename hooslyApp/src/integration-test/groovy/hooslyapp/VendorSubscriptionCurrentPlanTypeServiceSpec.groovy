package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorSubscriptionCurrentPlanTypeServiceSpec extends Specification {

    VendorSubscriptionCurrentPlanTypeService vendorSubscriptionCurrentPlanTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //new VendorSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //VendorSubscriptionCurrentPlanType vendorSubscriptionCurrentPlanType = new VendorSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //new VendorSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        //new VendorSubscriptionCurrentPlanType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorSubscriptionCurrentPlanType.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorSubscriptionCurrentPlanTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorSubscriptionCurrentPlanType> vendorSubscriptionCurrentPlanTypeList = vendorSubscriptionCurrentPlanTypeService.list(max: 2, offset: 2)

        then:
        vendorSubscriptionCurrentPlanTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorSubscriptionCurrentPlanTypeService.count() == 5
    }

    void "test delete"() {
        Long vendorSubscriptionCurrentPlanTypeId = setupData()

        expect:
        vendorSubscriptionCurrentPlanTypeService.count() == 5

        when:
        vendorSubscriptionCurrentPlanTypeService.delete(vendorSubscriptionCurrentPlanTypeId)
        sessionFactory.currentSession.flush()

        then:
        vendorSubscriptionCurrentPlanTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorSubscriptionCurrentPlanType vendorSubscriptionCurrentPlanType = new VendorSubscriptionCurrentPlanType()
        vendorSubscriptionCurrentPlanTypeService.save(vendorSubscriptionCurrentPlanType)

        then:
        vendorSubscriptionCurrentPlanType.id != null
    }
}
