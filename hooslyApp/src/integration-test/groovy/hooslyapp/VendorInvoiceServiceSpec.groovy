package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorInvoiceServiceSpec extends Specification {

    VendorInvoiceService vendorInvoiceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorInvoice(...).save(flush: true, failOnError: true)
        //new VendorInvoice(...).save(flush: true, failOnError: true)
        //VendorInvoice vendorInvoice = new VendorInvoice(...).save(flush: true, failOnError: true)
        //new VendorInvoice(...).save(flush: true, failOnError: true)
        //new VendorInvoice(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorInvoice.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorInvoiceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorInvoice> vendorInvoiceList = vendorInvoiceService.list(max: 2, offset: 2)

        then:
        vendorInvoiceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorInvoiceService.count() == 5
    }

    void "test delete"() {
        Long vendorInvoiceId = setupData()

        expect:
        vendorInvoiceService.count() == 5

        when:
        vendorInvoiceService.delete(vendorInvoiceId)
        sessionFactory.currentSession.flush()

        then:
        vendorInvoiceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorInvoice vendorInvoice = new VendorInvoice()
        vendorInvoiceService.save(vendorInvoice)

        then:
        vendorInvoice.id != null
    }
}
