package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorOnboardingCategoriesMapServiceSpec extends Specification {

    VendorOnboardingCategoriesMapService vendorOnboardingCategoriesMapService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorOnboardingCategoriesMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingCategoriesMap(...).save(flush: true, failOnError: true)
        //VendorOnboardingCategoriesMap vendorOnboardingCategoriesMap = new VendorOnboardingCategoriesMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingCategoriesMap(...).save(flush: true, failOnError: true)
        //new VendorOnboardingCategoriesMap(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorOnboardingCategoriesMap.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorOnboardingCategoriesMapService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorOnboardingCategoriesMap> vendorOnboardingCategoriesMapList = vendorOnboardingCategoriesMapService.list(max: 2, offset: 2)

        then:
        vendorOnboardingCategoriesMapList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorOnboardingCategoriesMapService.count() == 5
    }

    void "test delete"() {
        Long vendorOnboardingCategoriesMapId = setupData()

        expect:
        vendorOnboardingCategoriesMapService.count() == 5

        when:
        vendorOnboardingCategoriesMapService.delete(vendorOnboardingCategoriesMapId)
        sessionFactory.currentSession.flush()

        then:
        vendorOnboardingCategoriesMapService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorOnboardingCategoriesMap vendorOnboardingCategoriesMap = new VendorOnboardingCategoriesMap()
        vendorOnboardingCategoriesMapService.save(vendorOnboardingCategoriesMap)

        then:
        vendorOnboardingCategoriesMap.id != null
    }
}
