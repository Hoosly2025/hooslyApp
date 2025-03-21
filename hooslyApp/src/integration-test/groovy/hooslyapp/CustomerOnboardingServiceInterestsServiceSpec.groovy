package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerOnboardingServiceInterestsServiceSpec extends Specification {

    CustomerOnboardingServiceInterestsService customerOnboardingServiceInterestsService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerOnboardingServiceInterests(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingServiceInterests(...).save(flush: true, failOnError: true)
        //CustomerOnboardingServiceInterests customerOnboardingServiceInterests = new CustomerOnboardingServiceInterests(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingServiceInterests(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingServiceInterests(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerOnboardingServiceInterests.id
    }

    void "test get"() {
        setupData()

        expect:
        customerOnboardingServiceInterestsService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerOnboardingServiceInterests> customerOnboardingServiceInterestsList = customerOnboardingServiceInterestsService.list(max: 2, offset: 2)

        then:
        customerOnboardingServiceInterestsList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerOnboardingServiceInterestsService.count() == 5
    }

    void "test delete"() {
        Long customerOnboardingServiceInterestsId = setupData()

        expect:
        customerOnboardingServiceInterestsService.count() == 5

        when:
        customerOnboardingServiceInterestsService.delete(customerOnboardingServiceInterestsId)
        sessionFactory.currentSession.flush()

        then:
        customerOnboardingServiceInterestsService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerOnboardingServiceInterests customerOnboardingServiceInterests = new CustomerOnboardingServiceInterests()
        customerOnboardingServiceInterestsService.save(customerOnboardingServiceInterests)

        then:
        customerOnboardingServiceInterests.id != null
    }
}
