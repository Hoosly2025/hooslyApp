package hooslyapp

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class CustomerController {

    def index() { }
}
