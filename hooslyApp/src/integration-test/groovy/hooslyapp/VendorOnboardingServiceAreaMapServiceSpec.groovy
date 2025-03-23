package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorOnboardingServiceAreaMapServiceSpec extends Specification {

    VendorOnboardingServiceAreaMapService vendorOnboardingServiceAreaMapService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorOnboardingServiceAreaMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServiceAreaMap(...).save(flush: true, failOnError: true)
        //VendorOnboardingServiceAreaMap vendorOnboardingServiceAreaMap = new VendorOnboardingServiceAreaMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServiceAreaMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServiceAreaMap(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorOnboardingServiceAreaMap.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorOnboardingServiceAreaMapService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorOnboardingServiceAreaMap> vendorOnboardingServiceAreaMapList = vendorOnboardingServiceAreaMapService.list(max: 2, offset: 2)

        then:
        vendorOnboardingServiceAreaMapList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorOnboardingServiceAreaMapService.count() == 5
    }

    void "test delete"() {
        Long vendorOnboardingServiceAreaMapId = setupData()

        expect:
        vendorOnboardingServiceAreaMapService.count() == 5

        when:
        vendorOnboardingServiceAreaMapService.delete(vendorOnboardingServiceAreaMapId)
        sessionFactory.currentSession.flush()

        then:
        vendorOnboardingServiceAreaMapService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorOnboardingServiceAreaMap vendorOnboardingServiceAreaMap = new VendorOnboardingServiceAreaMap()
        vendorOnboardingServiceAreaMapService.save(vendorOnboardingServiceAreaMap)

        then:
        vendorOnboardingServiceAreaMap.id != null
    }
}
