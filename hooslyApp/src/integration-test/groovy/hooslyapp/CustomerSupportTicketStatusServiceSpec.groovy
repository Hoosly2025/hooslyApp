package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerSupportTicketStatusServiceSpec extends Specification {

    CustomerSupportTicketStatusService customerSupportTicketStatusService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerSupportTicketStatus(...).save(flush: true, failOnError: true)
        //new CustomerSupportTicketStatus(...).save(flush: true, failOnError: true)
        //CustomerSupportTicketStatus customerSupportTicketStatus = new CustomerSupportTicketStatus(...).save(flush: true, failOnError: true)
        //new CustomerSupportTicketStatus(...).save(flush: true, failOnError: true)
        //new CustomerSupportTicketStatus(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerSupportTicketStatus.id
    }

    void "test get"() {
        setupData()

        expect:
        customerSupportTicketStatusService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerSupportTicketStatus> customerSupportTicketStatusList = customerSupportTicketStatusService.list(max: 2, offset: 2)

        then:
        customerSupportTicketStatusList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerSupportTicketStatusService.count() == 5
    }

    void "test delete"() {
        Long customerSupportTicketStatusId = setupData()

        expect:
        customerSupportTicketStatusService.count() == 5

        when:
        customerSupportTicketStatusService.delete(customerSupportTicketStatusId)
        sessionFactory.currentSession.flush()

        then:
        customerSupportTicketStatusService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerSupportTicketStatus customerSupportTicketStatus = new CustomerSupportTicketStatus()
        customerSupportTicketStatusService.save(customerSupportTicketStatus)

        then:
        customerSupportTicketStatus.id != null
    }
}
