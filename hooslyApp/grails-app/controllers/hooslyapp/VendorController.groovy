package hooslyapp

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class VendorController {

    def index() { }
}
