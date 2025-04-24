package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class TaskStatusController {

    TaskStatusService taskStatusService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond taskStatusService.list(params), model:[taskStatusCount: taskStatusService.count()]
    }

    def show(Long id) {
        respond taskStatusService.get(id)
    }

    def create() {
        respond new TaskStatus(params)
    }

    def save(TaskStatus taskStatus) {
        if (taskStatus == null) {
            notFound()
            return
        }

        try {
            taskStatusService.save(taskStatus)
        } catch (ValidationException e) {
            respond taskStatus.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'taskStatus.label', default: 'TaskStatus'), taskStatus.id])
                redirect taskStatus
            }
            '*' { respond taskStatus, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond taskStatusService.get(id)
    }

    def update(TaskStatus taskStatus) {
        if (taskStatus == null) {
            notFound()
            return
        }

        try {
            taskStatusService.save(taskStatus)
        } catch (ValidationException e) {
            respond taskStatus.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'taskStatus.label', default: 'TaskStatus'), taskStatus.id])
                redirect taskStatus
            }
            '*'{ respond taskStatus, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        taskStatusService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'taskStatus.label', default: 'TaskStatus'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'taskStatus.label', default: 'TaskStatus'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
