<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'vendorCertifications.label', default: 'VendorCertifications')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-vendorCertifications" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-vendorCertifications" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.vendorCertifications}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.vendorCertifications}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.vendorCertifications}" method="PUT" enctype="multipart/form-data">
                <g:hiddenField name="version" value="${this.vendorCertifications?.version}" />
                <fieldset class="form">
                    <f:all bean="vendorCertifications" except="vendor, filename, fileUpload"/>
                </fieldset>
                <g:hiddenField name="vendor" value="${sec.loggedInUserInfo(field: 'id')}" />
                 <fieldset style="margin-left:340px;">
                	<div style="float:left;width:50" class="post"><h4>Upload Vendor Certifications:</h4></div>
                	<br>
              				Please upload a pdf.<br>
              		<div>
                  <input type="file" name="myFile" />
              </div>	
                </fieldset>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
