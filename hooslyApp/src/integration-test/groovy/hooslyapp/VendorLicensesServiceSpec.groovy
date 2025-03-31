package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorLicensesServiceSpec extends Specification {

    VendorLicensesService vendorLicensesService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorLicenses(...).save(flush: true, failOnError: true)
        //new VendorLicenses(...).save(flush: true, failOnError: true)
        //VendorLicenses vendorLicenses = new VendorLicenses(...).save(flush: true, failOnError: true)
        //new VendorLicenses(...).save(flush: true, failOnError: true)
        //new VendorLicenses(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorLicenses.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorLicensesService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorLicenses> vendorLicensesList = vendorLicensesService.list(max: 2, offset: 2)

        then:
        vendorLicensesList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorLicensesService.count() == 5
    }

    void "test delete"() {
        Long vendorLicensesId = setupData()

        expect:
        vendorLicensesService.count() == 5

        when:
        vendorLicensesService.delete(vendorLicensesId)
        sessionFactory.currentSession.flush()

        then:
        vendorLicensesService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorLicenses vendorLicenses = new VendorLicenses()
        vendorLicensesService.save(vendorLicenses)

        then:
        vendorLicenses.id != null
    }
}
