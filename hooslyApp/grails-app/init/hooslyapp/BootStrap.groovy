package hooslyapp
import security.*
import grails.gorm.transactions.Transactional


class BootStrap {

    def init = { servletContext ->
	addTestUsers()

    }
    def destroy = {
    }

    @Transactional void addTestUsers() {
	def adminRole = new Role(authority: 'ROLE_ADMIN').save()
		
				def testUser = new User(username: 'liveoakhome', password: 'jermane').save()
		
				 UserRole.create(testUser, adminRole, true)
				 
		
    }
}
