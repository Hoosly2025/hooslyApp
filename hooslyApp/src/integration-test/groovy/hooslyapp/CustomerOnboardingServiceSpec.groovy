package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerOnboardingServiceSpec extends Specification {

    CustomerOnboardingService customerOnboardingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerOnboarding(...).save(flush: true, failOnError: true)
        //new CustomerOnboarding(...).save(flush: true, failOnError: true)
        //CustomerOnboarding customerOnboarding = new CustomerOnboarding(...).save(flush: true, failOnError: true)
        //new CustomerOnboarding(...).save(flush: true, failOnError: true)
        //new CustomerOnboarding(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerOnboarding.id
    }

    void "test get"() {
        setupData()

        expect:
        customerOnboardingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerOnboarding> customerOnboardingList = customerOnboardingService.list(max: 2, offset: 2)

        then:
        customerOnboardingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerOnboardingService.count() == 5
    }

    void "test delete"() {
        Long customerOnboardingId = setupData()

        expect:
        customerOnboardingService.count() == 5

        when:
        customerOnboardingService.delete(customerOnboardingId)
        sessionFactory.currentSession.flush()

        then:
        customerOnboardingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerOnboarding customerOnboarding = new CustomerOnboarding()
        customerOnboardingService.save(customerOnboarding)

        then:
        customerOnboarding.id != null
    }
}
