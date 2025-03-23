package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorOnboardingServiceAreaServiceSpec extends Specification {

    VendorOnboardingServiceAreaService vendorOnboardingServiceAreaService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorOnboardingServiceArea(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServiceArea(...).save(flush: true, failOnError: true)
        //VendorOnboardingServiceArea vendorOnboardingServiceArea = new VendorOnboardingServiceArea(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServiceArea(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServiceArea(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorOnboardingServiceArea.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorOnboardingServiceAreaService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorOnboardingServiceArea> vendorOnboardingServiceAreaList = vendorOnboardingServiceAreaService.list(max: 2, offset: 2)

        then:
        vendorOnboardingServiceAreaList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorOnboardingServiceAreaService.count() == 5
    }

    void "test delete"() {
        Long vendorOnboardingServiceAreaId = setupData()

        expect:
        vendorOnboardingServiceAreaService.count() == 5

        when:
        vendorOnboardingServiceAreaService.delete(vendorOnboardingServiceAreaId)
        sessionFactory.currentSession.flush()

        then:
        vendorOnboardingServiceAreaService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorOnboardingServiceArea vendorOnboardingServiceArea = new VendorOnboardingServiceArea()
        vendorOnboardingServiceAreaService.save(vendorOnboardingServiceArea)

        then:
        vendorOnboardingServiceArea.id != null
    }
}
