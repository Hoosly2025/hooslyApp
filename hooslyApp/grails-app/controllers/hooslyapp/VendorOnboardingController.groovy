package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder
import grails.gorm.transactions.Transactional
import security.*


@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_VENDOR'])
class VendorOnboardingController {

    VendorOnboardingService vendorOnboardingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond vendorOnboardingService.list(params), model:[vendorOnboardingCount: vendorOnboardingService.count()]
    }

    def show(Long id) {
        respond vendorOnboardingService.get(id)
    }

    def create() {
        respond new VendorOnboarding(params)
    }

	@Transactional
    def save(VendorOnboarding vendorOnboarding) {
        if (vendorOnboarding == null) {
            notFound()
            return
        }

        try {
			def authentication = SecurityContextHolder.getContext().getAuthentication()

	    	if (authentication != null) {
			
				def userDetails = authentication.getPrincipal()
				def authorities = userDetails.authorities
				
				//check if user is ROLE_USER, change it to ROLE_CUSTOMER
				
				if (authorities?.any { it.authority == 'ROLE_USER' }) {
					User user = User.findById(userDetails.id)
					System.out.println("user found: " + user.username)
					Role role = Role.findByAuthority('ROLE_USER')
					System.out.println("role found: " + role.authority)
					
					
					def roleRemoved = UserRole.remove(user, role)
					if (roleRemoved) {
						System.out.println("Role removed: " + role.authority)
						Role roleVendor = Role.findByAuthority('ROLE_VENDOR')
						UserRole.create(user, roleVendor, true)
					}
				}
			}

			
            vendorOnboardingService.save(vendorOnboarding)
        } catch (ValidationException e) {
            respond vendorOnboarding.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), vendorOnboarding.id])
                redirect vendorOnboarding
            }
            '*' { respond vendorOnboarding, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond vendorOnboardingService.get(id)
    }

	@Transactional
    def update(VendorOnboarding vendorOnboarding) {
        if (vendorOnboarding == null) {
            notFound()
            return
        }

        try {
			def authentication = SecurityContextHolder.getContext().getAuthentication()

	    	if (authentication != null) {
			
				def userDetails = authentication.getPrincipal()
				def authorities = userDetails.authorities
				
				//check if user is ROLE_USER, change it to ROLE_CUSTOMER
				
				if (authorities?.any { it.authority == 'ROLE_USER' }) {
					User user = User.findById(userDetails.id)
					System.out.println("user found: " + user.username)
					Role role = Role.findByAuthority('ROLE_USER')
					System.out.println("role found: " + role.authority)
					
					
					def roleRemoved = UserRole.remove(user, role)
					if (roleRemoved) {
						System.out.println("Role removed: " + role.authority)
						Role roleVendor = Role.findByAuthority('ROLE_VENDOR')
						UserRole.create(user, roleVendor, true)
					}
				}
			}
			
            vendorOnboardingService.save(vendorOnboarding)
        } catch (ValidationException e) {
            respond vendorOnboarding.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), vendorOnboarding.id])
                redirect vendorOnboarding
            }
            '*'{ respond vendorOnboarding, [status: OK] }
        }
    }

	@Secured(['ROLE_ADMIN'])
    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        vendorOnboardingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'vendorOnboarding.label', default: 'VendorOnboarding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
