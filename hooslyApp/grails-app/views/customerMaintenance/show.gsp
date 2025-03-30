<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerMaintenance.label', default: 'CustomerMaintenance')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-customerMaintenance" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-customerMaintenance" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin-left:50px;">
            Customer Onboarding: <f:display bean="customerMaintenance" property="customerOnboarding"/><br>
            Vendor Onboarding: <f:display bean="customerMaintenance" property="vendorOnboarding"/><br>
            Maintenance Type: <f:display bean="customerMaintenance" property="maintenanceType.maintenanceType"/><br>
            Maintenance Details: <f:display bean="customerMaintenance" property="maintenanceDetails"/><br>
            Maintenance Status: <f:display bean="customerMaintenance" property="maintenanceStatus.maintenanceStatus"/><br>
            Maintenance Request Date: <f:display bean="customerMaintenance" property="maintenanceRequestDate"/><br>
            Maintenance Scheduled Date: <f:display bean="customerMaintenance" property="maintenanceScheduledDate"/><br>
            Maintenance Completion Date: <f:display bean="customerMaintenance" property="maintenanceCompletionDate"/><br>
            Cost Details: <f:display bean="customerMaintenance" property="costDetails"/><br>
            </div>
            <g:form resource="${this.customerMaintenance}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.customerMaintenance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
