package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorCertificationsServiceSpec extends Specification {

    VendorCertificationsService vendorCertificationsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorCertifications(...).save(flush: true, failOnError: true)
        //new VendorCertifications(...).save(flush: true, failOnError: true)
        //VendorCertifications vendorCertifications = new VendorCertifications(...).save(flush: true, failOnError: true)
        //new VendorCertifications(...).save(flush: true, failOnError: true)
        //new VendorCertifications(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorCertifications.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorCertificationsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorCertifications> vendorCertificationsList = vendorCertificationsService.list(max: 2, offset: 2)

        then:
        vendorCertificationsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorCertificationsService.count() == 5
    }

    void "test delete"() {
        Long vendorCertificationsId = setupData()

        expect:
        vendorCertificationsService.count() == 5

        when:
        vendorCertificationsService.delete(vendorCertificationsId)
        sessionFactory.currentSession.flush()

        then:
        vendorCertificationsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorCertifications vendorCertifications = new VendorCertifications()
        vendorCertificationsService.save(vendorCertifications)

        then:
        vendorCertifications.id != null
    }
}
