package hooslyapp

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ANONYMOUS'])
class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {
}
