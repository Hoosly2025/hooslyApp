package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class CustomerOnboardingPropertyTypeServiceSpec extends Specification {

    CustomerOnboardingPropertyTypeService customerOnboardingPropertyTypeService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new CustomerOnboardingPropertyType(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingPropertyType(...).save(flush: true, failOnError: true)
        //CustomerOnboardingPropertyType customerOnboardingPropertyType = new CustomerOnboardingPropertyType(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingPropertyType(...).save(flush: true, failOnError: true)
        //new CustomerOnboardingPropertyType(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //customerOnboardingPropertyType.id
    }

    void "test get"() {
        setupData()

        expect:
        customerOnboardingPropertyTypeService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<CustomerOnboardingPropertyType> customerOnboardingPropertyTypeList = customerOnboardingPropertyTypeService.list(max: 2, offset: 2)

        then:
        customerOnboardingPropertyTypeList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        customerOnboardingPropertyTypeService.count() == 5
    }

    void "test delete"() {
        Long customerOnboardingPropertyTypeId = setupData()

        expect:
        customerOnboardingPropertyTypeService.count() == 5

        when:
        customerOnboardingPropertyTypeService.delete(customerOnboardingPropertyTypeId)
        sessionFactory.currentSession.flush()

        then:
        customerOnboardingPropertyTypeService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        CustomerOnboardingPropertyType customerOnboardingPropertyType = new CustomerOnboardingPropertyType()
        customerOnboardingPropertyTypeService.save(customerOnboardingPropertyType)

        then:
        customerOnboardingPropertyType.id != null
    }
}
