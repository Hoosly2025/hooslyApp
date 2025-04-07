<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerSupportTicket.label', default: 'CustomerSupportTicket')}" />
        <title><g:message code="default.create.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#create-customerSupportTicket" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="create-customerSupportTicket" class="content scaffold-create" role="main">
            <h1><g:message code="default.create.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${this.customerSupportTicket}">
            <ul class="errors" role="alert">
                <g:eachError bean="${this.customerSupportTicket}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                </g:eachError>
            </ul>
            </g:hasErrors>
            <g:form resource="${this.customerSupportTicket}" method="POST">
                <fieldset class="form">
                    <f:all bean="customerSupportTicket" except="ticketStatus, creator"/>
                </fieldset>
                <div style="margin-left:27px;">
                <f:field bean="customerSupportTicket" property="ticketStatus" widget-optionValue="ticketStatus"/>
                <g:hiddenField name="creator" value="${sec.loggedInUserInfo(field: 'id')}" />
                </div>
                <fieldset class="buttons">
                    <g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
