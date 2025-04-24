package hooslyapp

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*
import grails.plugin.springsecurity.annotation.Secured
import org.springframework.security.core.context.SecurityContextHolder

@Secured(['ROLE_ADMIN', 'ROLE_USER'])
class TaskController {

    TaskService taskService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
	        		
		def authentication = SecurityContextHolder.getContext().getAuthentication()

	    if (authentication != null) {
			
			def userDetails = authentication.getPrincipal()
			
			def authorities = userDetails.authorities
				def taskList
				
                if (authorities?.any { it.authority == 'ROLE_ADMIN' }) {
                    // User has ADMIN role
                    respond userDetails, model:[taskList: taskService.list(params), taskCount: taskService.count()]
                } else {
					def userId = userDetails.id
					taskList = Task.findAllByUser(userId)
					def taskCount = 0
					
					if (taskList != null && taskList.size() > 0) {
						taskCount = taskList.size()
					}
					respond userDetails, model:[taskList: taskList, taskCount: taskCount]
				}
	        
    	}

    }


    def show(Long id) {
        respond taskService.get(id)
    }

    def create() {
        respond new Task(params)
    }

    def save(Task task) {
        if (task == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				task.filename = transferFile.getOriginalFilename()
				task.fileUpload = transferFile.getBytes()
			}
            taskService.save(task)
        } catch (ValidationException e) {
            respond task.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'task.label', default: 'Task'), task.id])
                redirect task
            }
            '*' { respond task, [status: CREATED] }
        }
    }

	@Secured(['ROLE_ADMIN', 'ROLE_USER', 'ROLE_ANONYMOUS'])
	def download(long id) {
		Task taskInstance = taskService.get(id)
		if ( taskInstance == null) {
			flash.message = "Task not found."
			redirect (action:'index')
		} else {
			response.setContentType("APPLICATION/OCTET-STREAM")
			response.setHeader("Content-Disposition", "Attachment;Filename=\"${taskInstance.filename}\"")
			def outputStream = response.getOutputStream()
			outputStream << taskInstance.fileUpload
			outputStream.flush()
			outputStream.close()
		}
	}
	
    def edit(Long id) {
        respond taskService.get(id)
    }

    def update(Task task) {
        if (task == null) {
            notFound()
            return
        }

        try {
			def transferFile = request.getFile('myFile')
			if(transferFile != null && !transferFile.empty) {
				task.filename = transferFile.getOriginalFilename()
				task.fileUpload = transferFile.getBytes()
			}
            taskService.save(task)
        } catch (ValidationException e) {
            respond task.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'task.label', default: 'Task'), task.id])
                redirect task
            }
            '*'{ respond task, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        taskService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'task.label', default: 'Task'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'task.label', default: 'Task'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
