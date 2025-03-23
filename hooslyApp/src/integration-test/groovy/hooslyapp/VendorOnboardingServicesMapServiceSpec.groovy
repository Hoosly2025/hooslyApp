package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorOnboardingServicesMapServiceSpec extends Specification {

    VendorOnboardingServicesMapService vendorOnboardingServicesMapService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorOnboardingServicesMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServicesMap(...).save(flush: true, failOnError: true)
        //VendorOnboardingServicesMap vendorOnboardingServicesMap = new VendorOnboardingServicesMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServicesMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingServicesMap(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorOnboardingServicesMap.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorOnboardingServicesMapService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorOnboardingServicesMap> vendorOnboardingServicesMapList = vendorOnboardingServicesMapService.list(max: 2, offset: 2)

        then:
        vendorOnboardingServicesMapList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorOnboardingServicesMapService.count() == 5
    }

    void "test delete"() {
        Long vendorOnboardingServicesMapId = setupData()

        expect:
        vendorOnboardingServicesMapService.count() == 5

        when:
        vendorOnboardingServicesMapService.delete(vendorOnboardingServicesMapId)
        sessionFactory.currentSession.flush()

        then:
        vendorOnboardingServicesMapService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorOnboardingServicesMap vendorOnboardingServicesMap = new VendorOnboardingServicesMap()
        vendorOnboardingServicesMapService.save(vendorOnboardingServicesMap)

        then:
        vendorOnboardingServicesMap.id != null
    }
}
