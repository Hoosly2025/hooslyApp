package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorRatingServiceSpec extends Specification {

    VendorRatingService vendorRatingService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorRating(...).save(flush: true, failOnError: true)
        //new VendorRating(...).save(flush: true, failOnError: true)
        //VendorRating vendorRating = new VendorRating(...).save(flush: true, failOnError: true)
        //new VendorRating(...).save(flush: true, failOnError: true)
        //new VendorRating(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorRating.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorRatingService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorRating> vendorRatingList = vendorRatingService.list(max: 2, offset: 2)

        then:
        vendorRatingList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorRatingService.count() == 5
    }

    void "test delete"() {
        Long vendorRatingId = setupData()

        expect:
        vendorRatingService.count() == 5

        when:
        vendorRatingService.delete(vendorRatingId)
        sessionFactory.currentSession.flush()

        then:
        vendorRatingService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorRating vendorRating = new VendorRating()
        vendorRatingService.save(vendorRating)

        then:
        vendorRating.id != null
    }
}
