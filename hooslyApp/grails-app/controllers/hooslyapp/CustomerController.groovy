package hooslyapp

import security.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerController {

    def index() { }
    
    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS', 'ROLE_USER'])
    def profile(Long id) {
		System.out.println("id =" + id)
		def user = User.findById(id)
		def customerOnboarding = CustomerOnboarding.findByCustomer(user)
		respond customerOnboarding
		//find user with that id
		//find customer onboarding for the user id
		//find photos with user id
	}
}
