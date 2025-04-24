package hooslyapp

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class DocServiceSpec extends Specification {

    DocService docService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Doc(...).save(flush: true, failOnError: true)
        //new Doc(...).save(flush: true, failOnError: true)
        //Doc doc = new Doc(...).save(flush: true, failOnError: true)
        //new Doc(...).save(flush: true, failOnError: true)
        //new Doc(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //doc.id
    }

    void "test get"() {
        setupData()

        expect:
        docService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Doc> docList = docService.list(max: 2, offset: 2)

        then:
        docList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        docService.count() == 5
    }

    void "test delete"() {
        Long docId = setupData()

        expect:
        docService.count() == 5

        when:
        docService.delete(docId)
        sessionFactory.currentSession.flush()

        then:
        docService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Doc doc = new Doc()
        docService.save(doc)

        then:
        doc.id != null
    }
}
