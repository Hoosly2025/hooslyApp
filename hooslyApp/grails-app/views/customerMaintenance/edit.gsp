<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerMaintenance.label', default: 'CustomerMaintenance')}" />
        <title><g:message code="default.edit.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#edit-customerMaintenance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="edit-customerMaintenance" class="content scaffold-edit" role="main">
            <h1><g:message code="default.edit.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.customerMaintenance}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.customerMaintenance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.customerMaintenance}" method="PUT">
                <g:hiddenField name="version" value="${this.customerMaintenance?.version}" />
                <g:hiddenField name="customerOnboarding" value="${sec.loggedInUserInfo(field: 'id')}" />
                <f:field bean="customerMaintenance" property="vendorOnboarding"/>
                <f:field bean="customerMaintenance" property="maintenanceType" widget-optionValue="maintenanceType"/>
                <f:field bean="customerMaintenance" property="maintenanceDetails"/>
                <f:field bean="customerMaintenance" property="maintenanceStatus" widget-optionValue="maintenanceStatus"/>
                <f:field bean="customerMaintenance" property="maintenanceRequestDate"/>
                <f:field bean="customerMaintenance" property="maintenanceScheduledDate"/>
                <f:field bean="customerMaintenance" property="maintenanceCompletionDate"/>
                <f:field bean="customerMaintenance" property="costDetails"/>
                <fieldset class="buttons">
                    <input class="save" type="submit" value="${message(code: 'default.button.update.label', default: 'Update')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
