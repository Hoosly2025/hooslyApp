package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerMaintenanceTypeServiceSpec extends Specification {

    CustomerMaintenanceTypeService customerMaintenanceTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerMaintenanceType(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceType(...).save(flush: true, failOnError: true)
        //CustomerMaintenanceType customerMaintenanceType = new CustomerMaintenanceType(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceType(...).save(flush: true, failOnError: true)
        //new CustomerMaintenanceType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerMaintenanceType.id
    }

    void "test get"() {
        setupData()

        expect:
        customerMaintenanceTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerMaintenanceType> customerMaintenanceTypeList = customerMaintenanceTypeService.list(max: 2, offset: 2)

        then:
        customerMaintenanceTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerMaintenanceTypeService.count() == 5
    }

    void "test delete"() {
        Long customerMaintenanceTypeId = setupData()

        expect:
        customerMaintenanceTypeService.count() == 5

        when:
        customerMaintenanceTypeService.delete(customerMaintenanceTypeId)
        sessionFactory.currentSession.flush()

        then:
        customerMaintenanceTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerMaintenanceType customerMaintenanceType = new CustomerMaintenanceType()
        customerMaintenanceTypeService.save(customerMaintenanceType)

        then:
        customerMaintenanceType.id != null
    }
}
