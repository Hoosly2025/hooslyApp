package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorOnboardingCategoriesServiceSpec extends Specification {

    VendorOnboardingCategoriesService vendorOnboardingCategoriesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorOnboardingCategories(...).save(flush: true, failOnError: true)
        //new VendorOnboardingCategories(...).save(flush: true, failOnError: true)
        //VendorOnboardingCategories vendorOnboardingCategories = new VendorOnboardingCategories(...).save(flush: true, failOnError: true)
        //new VendorOnboardingCategories(...).save(flush: true, failOnError: true)
        //new VendorOnboardingCategories(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorOnboardingCategories.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorOnboardingCategoriesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorOnboardingCategories> vendorOnboardingCategoriesList = vendorOnboardingCategoriesService.list(max: 2, offset: 2)

        then:
        vendorOnboardingCategoriesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorOnboardingCategoriesService.count() == 5
    }

    void "test delete"() {
        Long vendorOnboardingCategoriesId = setupData()

        expect:
        vendorOnboardingCategoriesService.count() == 5

        when:
        vendorOnboardingCategoriesService.delete(vendorOnboardingCategoriesId)
        sessionFactory.currentSession.flush()

        then:
        vendorOnboardingCategoriesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorOnboardingCategories vendorOnboardingCategories = new VendorOnboardingCategories()
        vendorOnboardingCategoriesService.save(vendorOnboardingCategories)

        then:
        vendorOnboardingCategories.id != null
    }
}
