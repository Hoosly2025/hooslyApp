package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorVideosServiceSpec extends Specification {

    VendorVideosService vendorVideosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorVideos(...).save(flush: true, failOnError: true)
        //new VendorVideos(...).save(flush: true, failOnError: true)
        //VendorVideos vendorVideos = new VendorVideos(...).save(flush: true, failOnError: true)
        //new VendorVideos(...).save(flush: true, failOnError: true)
        //new VendorVideos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorVideos.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorVideosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorVideos> vendorVideosList = vendorVideosService.list(max: 2, offset: 2)

        then:
        vendorVideosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorVideosService.count() == 5
    }

    void "test delete"() {
        Long vendorVideosId = setupData()

        expect:
        vendorVideosService.count() == 5

        when:
        vendorVideosService.delete(vendorVideosId)
        sessionFactory.currentSession.flush()

        then:
        vendorVideosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorVideos vendorVideos = new VendorVideos()
        vendorVideosService.save(vendorVideos)

        then:
        vendorVideos.id != null
    }
}
