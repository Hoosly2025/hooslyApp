<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerOnboarding.label', default: 'CustomerOnboarding')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-customerOnboarding" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-customerOnboarding" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin-left:50px;">
            Customer: <f:display bean="customerOnboarding" property="customer"/><br>
            First Name: <f:display bean="customerOnboarding" property="firstName"/><br>
            Last Name: <f:display bean="customerOnboarding" property="lastName"/><br>
            Phone: <f:display bean="customerOnboarding" property="phone"/><br>
            First Name: <f:display bean="customerOnboarding" property="streetAddress"/><br>
            Last Name: <f:display bean="customerOnboarding" property="city"/><br>
            Phone: <f:display bean="customerOnboarding" property="state"/><br>
            Zip Code: <f:display bean="customerOnboarding" property="zipCode"/><br>
            Property Type: <f:display bean="customerOnboarding" property="propertyType.propertyType"/><br>
            Property Size: <f:display bean="customerOnboarding" property="propertySize"/><br>
            Number of Units: <f:display bean="customerOnboarding" property="numberOfUnits"/><br>
            Maintenance frequency: <f:display bean="customerOnboarding" property="frequencyMaintenance.maintenanceFrequency"/><br>
            Create Time: <f:display bean="customerOnboarding" property="createTime"/><br>
            Update Time: <f:display bean="customerOnboarding" property="updateTime"/><br>
            
            </div>
            <g:form resource="${this.customerOnboarding}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.customerOnboarding}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
