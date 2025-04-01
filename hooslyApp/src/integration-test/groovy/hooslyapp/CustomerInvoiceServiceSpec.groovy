package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerInvoiceServiceSpec extends Specification {

    CustomerInvoiceService customerInvoiceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerInvoice(...).save(flush: true, failOnError: true)
        //new CustomerInvoice(...).save(flush: true, failOnError: true)
        //CustomerInvoice customerInvoice = new CustomerInvoice(...).save(flush: true, failOnError: true)
        //new CustomerInvoice(...).save(flush: true, failOnError: true)
        //new CustomerInvoice(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerInvoice.id
    }

    void "test get"() {
        setupData()

        expect:
        customerInvoiceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerInvoice> customerInvoiceList = customerInvoiceService.list(max: 2, offset: 2)

        then:
        customerInvoiceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerInvoiceService.count() == 5
    }

    void "test delete"() {
        Long customerInvoiceId = setupData()

        expect:
        customerInvoiceService.count() == 5

        when:
        customerInvoiceService.delete(customerInvoiceId)
        sessionFactory.currentSession.flush()

        then:
        customerInvoiceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerInvoice customerInvoice = new CustomerInvoice()
        customerInvoiceService.save(customerInvoice)

        then:
        customerInvoice.id != null
    }
}
