package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerOnboardingServiceInterestsMapServiceSpec extends Specification {

    CustomerOnboardingServiceInterestsMapService customerOnboardingServiceInterestsMapService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerOnboardingServiceInterestsMap(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingServiceInterestsMap(...).save(flush: true, failOnError: true)
        //CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap = new CustomerOnboardingServiceInterestsMap(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingServiceInterestsMap(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingServiceInterestsMap(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerOnboardingServiceInterestsMap.id
    }

    void "test get"() {
        setupData()

        expect:
        customerOnboardingServiceInterestsMapService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerOnboardingServiceInterestsMap> customerOnboardingServiceInterestsMapList = customerOnboardingServiceInterestsMapService.list(max: 2, offset: 2)

        then:
        customerOnboardingServiceInterestsMapList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerOnboardingServiceInterestsMapService.count() == 5
    }

    void "test delete"() {
        Long customerOnboardingServiceInterestsMapId = setupData()

        expect:
        customerOnboardingServiceInterestsMapService.count() == 5

        when:
        customerOnboardingServiceInterestsMapService.delete(customerOnboardingServiceInterestsMapId)
        sessionFactory.currentSession.flush()

        then:
        customerOnboardingServiceInterestsMapService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerOnboardingServiceInterestsMap customerOnboardingServiceInterestsMap = new CustomerOnboardingServiceInterestsMap()
        customerOnboardingServiceInterestsMapService.save(customerOnboardingServiceInterestsMap)

        then:
        customerOnboardingServiceInterestsMap.id != null
    }
}
