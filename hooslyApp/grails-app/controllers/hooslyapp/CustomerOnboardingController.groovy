package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder
import grails.gorm.transactions.Transactional
import security.*

@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_CUSTOMER'])
class CustomerOnboardingController {

    CustomerOnboardingService customerOnboardingService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

	@Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond customerOnboardingService.list(params), model:[customerOnboardingCount: customerOnboardingService.count()]
    }

    def show(Long id) {
        respond customerOnboardingService.get(id)
    }

    def create() {
        respond new CustomerOnboarding(params)
    }

	@Transactional
    def save(CustomerOnboarding customerOnboarding) {
        if (customerOnboarding == null) {
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
						Role roleCustomer = Role.findByAuthority('ROLE_CUSTOMER')
						UserRole.create(user, roleCustomer, true)
					}
				}
			}
			
            customerOnboardingService.save(customerOnboarding)
        } catch (ValidationException e) {
            respond customerOnboarding.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), customerOnboarding.id])
                redirect customerOnboarding
            }
            '*' { respond customerOnboarding, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond customerOnboardingService.get(id)
    }

	@Transactional
    def update(CustomerOnboarding customerOnboarding) {
        if (customerOnboarding == null) {
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
						Role roleCustomer = Role.findByAuthority('ROLE_CUSTOMER')
						UserRole.create(user, roleCustomer, true)
					}
				}
			}

            customerOnboardingService.save(customerOnboarding)
        } catch (ValidationException e) {
            respond customerOnboarding.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), customerOnboarding.id])
                redirect customerOnboarding
            }
            '*'{ respond customerOnboarding, [status: OK] }
        }
    }

	@Secured(['ROLE_ADMIN'])
	def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        customerOnboardingService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'customerOnboarding.label', default: 'CustomerOnboarding'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
