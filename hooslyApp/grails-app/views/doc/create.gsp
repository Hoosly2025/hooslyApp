<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'doc.label', default: 'Doc')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-doc" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-doc" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.doc}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.doc}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.doc}" method="POST" enctype="multipart/form-data">
                <fieldset class="form">
                    <f:all bean="doc" except="user, filename, fileUpload"/>
                </fieldset>
                <g:hiddenField name="user" value="${sec.loggedInUserInfo(field: 'id')}" />
                <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Upload Doc:</h4></div>
                	<br>
              				Please upload a file.<br>
              		<div>
                  <input type="file" name="myFile" />
              </div>	
                </fieldset>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
