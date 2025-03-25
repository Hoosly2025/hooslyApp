package hooslyapp

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class CustomerController {

    def index() { }
}
