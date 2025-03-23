package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerMaintenanceServiceSpec extends Specification {

    CustomerMaintenanceService customerMaintenanceService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerMaintenance(...).save(flush: true, failOnError: true)
        //new CustomerMaintenance(...).save(flush: true, failOnError: true)
        //CustomerMaintenance customerMaintenance = new CustomerMaintenance(...).save(flush: true, failOnError: true)
        //new CustomerMaintenance(...).save(flush: true, failOnError: true)
        //new CustomerMaintenance(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerMaintenance.id
    }

    void "test get"() {
        setupData()

        expect:
        customerMaintenanceService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerMaintenance> customerMaintenanceList = customerMaintenanceService.list(max: 2, offset: 2)

        then:
        customerMaintenanceList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerMaintenanceService.count() == 5
    }

    void "test delete"() {
        Long customerMaintenanceId = setupData()

        expect:
        customerMaintenanceService.count() == 5

        when:
        customerMaintenanceService.delete(customerMaintenanceId)
        sessionFactory.currentSession.flush()

        then:
        customerMaintenanceService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerMaintenance customerMaintenance = new CustomerMaintenance()
        customerMaintenanceService.save(customerMaintenance)

        then:
        customerMaintenance.id != null
    }
}
