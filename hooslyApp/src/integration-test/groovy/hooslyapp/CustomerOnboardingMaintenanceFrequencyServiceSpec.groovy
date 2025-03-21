package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerOnboardingMaintenanceFrequencyServiceSpec extends Specification {

    CustomerOnboardingMaintenanceFrequencyService customerOnboardingMaintenanceFrequencyService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerOnboardingMaintenanceFrequency(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingMaintenanceFrequency(...).save(flush: true, failOnError: true)
        //CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency = new CustomerOnboardingMaintenanceFrequency(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingMaintenanceFrequency(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingMaintenanceFrequency(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerOnboardingMaintenanceFrequency.id
    }

    void "test get"() {
        setupData()

        expect:
        customerOnboardingMaintenanceFrequencyService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerOnboardingMaintenanceFrequency> customerOnboardingMaintenanceFrequencyList = customerOnboardingMaintenanceFrequencyService.list(max: 2, offset: 2)

        then:
        customerOnboardingMaintenanceFrequencyList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerOnboardingMaintenanceFrequencyService.count() == 5
    }

    void "test delete"() {
        Long customerOnboardingMaintenanceFrequencyId = setupData()

        expect:
        customerOnboardingMaintenanceFrequencyService.count() == 5

        when:
        customerOnboardingMaintenanceFrequencyService.delete(customerOnboardingMaintenanceFrequencyId)
        sessionFactory.currentSession.flush()

        then:
        customerOnboardingMaintenanceFrequencyService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerOnboardingMaintenanceFrequency customerOnboardingMaintenanceFrequency = new CustomerOnboardingMaintenanceFrequency()
        customerOnboardingMaintenanceFrequencyService.save(customerOnboardingMaintenanceFrequency)

        then:
        customerOnboardingMaintenanceFrequency.id != null
    }
}
