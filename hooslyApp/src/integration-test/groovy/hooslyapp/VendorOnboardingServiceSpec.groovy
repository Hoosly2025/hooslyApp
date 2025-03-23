package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorOnboardingServiceSpec extends Specification {

    VendorOnboardingService vendorOnboardingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorOnboarding(...).save(flush: true, failOnError: true)
        //new VendorOnboarding(...).save(flush: true, failOnError: true)
        //VendorOnboarding vendorOnboarding = new VendorOnboarding(...).save(flush: true, failOnError: true)
        //new VendorOnboarding(...).save(flush: true, failOnError: true)
        //new VendorOnboarding(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorOnboarding.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorOnboardingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorOnboarding> vendorOnboardingList = vendorOnboardingService.list(max: 2, offset: 2)

        then:
        vendorOnboardingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorOnboardingService.count() == 5
    }

    void "test delete"() {
        Long vendorOnboardingId = setupData()

        expect:
        vendorOnboardingService.count() == 5

        when:
        vendorOnboardingService.delete(vendorOnboardingId)
        sessionFactory.currentSession.flush()

        then:
        vendorOnboardingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorOnboarding vendorOnboarding = new VendorOnboarding()
        vendorOnboardingService.save(vendorOnboarding)

        then:
        vendorOnboarding.id != null
    }
}
