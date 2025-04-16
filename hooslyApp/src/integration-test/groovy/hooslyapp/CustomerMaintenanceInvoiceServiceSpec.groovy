package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerMaintenanceInvoiceServiceSpec extends Specification {

    CustomerMaintenanceInvoiceService customerMaintenanceInvoiceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerMaintenanceInvoice(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceInvoice(...).save(flush: true, failOnError: true)
        //CustomerMaintenanceInvoice customerMaintenanceInvoice = new CustomerMaintenanceInvoice(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceInvoice(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceInvoice(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerMaintenanceInvoice.id
    }

    void "test get"() {
        setupData()

        expect:
        customerMaintenanceInvoiceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerMaintenanceInvoice> customerMaintenanceInvoiceList = customerMaintenanceInvoiceService.list(max: 2, offset: 2)

        then:
        customerMaintenanceInvoiceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerMaintenanceInvoiceService.count() == 5
    }

    void "test delete"() {
        Long customerMaintenanceInvoiceId = setupData()

        expect:
        customerMaintenanceInvoiceService.count() == 5

        when:
        customerMaintenanceInvoiceService.delete(customerMaintenanceInvoiceId)
        sessionFactory.currentSession.flush()

        then:
        customerMaintenanceInvoiceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerMaintenanceInvoice customerMaintenanceInvoice = new CustomerMaintenanceInvoice()
        customerMaintenanceInvoiceService.save(customerMaintenanceInvoice)

        then:
        customerMaintenanceInvoice.id != null
    }
}
