package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class VendorPhotosServiceSpec extends Specification {

    VendorPhotosService vendorPhotosService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new VendorPhotos(...).save(flush: true, failOnError: true)
        //new VendorPhotos(...).save(flush: true, failOnError: true)
        //VendorPhotos vendorPhotos = new VendorPhotos(...).save(flush: true, failOnError: true)
        //new VendorPhotos(...).save(flush: true, failOnError: true)
        //new VendorPhotos(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //vendorPhotos.id
    }

    void "test get"() {
        setupData()

        expect:
        vendorPhotosService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<VendorPhotos> vendorPhotosList = vendorPhotosService.list(max: 2, offset: 2)

        then:
        vendorPhotosList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        vendorPhotosService.count() == 5
    }

    void "test delete"() {
        Long vendorPhotosId = setupData()

        expect:
        vendorPhotosService.count() == 5

        when:
        vendorPhotosService.delete(vendorPhotosId)
        sessionFactory.currentSession.flush()

        then:
        vendorPhotosService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        VendorPhotos vendorPhotos = new VendorPhotos()
        vendorPhotosService.save(vendorPhotos)

        then:
        vendorPhotos.id != null
    }
}
