package hooslyapp

import security.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class VendorController {

    def index() { }
    
    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS', 'ROLE_USER'])
    def profile(Long id) {
		System.out.println("id =" + id)
		def user = User.findById(id)
		def vendorOnboarding = VendorOnboarding.findByVendor(user)
		respond vendorOnboarding
		//find user with that id
		//find vendor onboarding for the user id
		//find photos with user id
		//find certifications & licenses for user id
	}
}
