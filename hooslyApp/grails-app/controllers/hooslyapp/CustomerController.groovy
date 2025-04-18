package hooslyapp

import security.*

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerController {

    def index() { }
    
    @Secured(['ROLE_ADMIN', 'ROLE_ANONYMOUS', 'ROLE_USER'])
    def profile(Long id) {
		System.out.println("id =" + id)
		def customerOnboarding = CustomerOnboarding.findByCustomer(id)
		
		def customerPhotos = CustomerPhotos.findAllByCustomer(id)
		def customerVideos = CustomerVideos.findAllByCustomer(id)
		
		respond customerOnboarding, model:[customerPhotos: customerPhotos, customerVideos: customerVideos]
		
		//find photos with user id
		
		//find videos with user id
		
		//allow rating
	}
}
