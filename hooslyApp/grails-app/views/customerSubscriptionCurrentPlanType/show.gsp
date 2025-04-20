<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'customerSubscriptionCurrentPlanType.label', default: 'CustomerSubscriptionCurrentPlanType')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-customerSubscriptionCurrentPlanType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <sec:ifAllGranted roles="ROLE_ADMIN">
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            	</sec:ifAllGranted>
            </ul>
        </div>
        <div id="show-customerSubscriptionCurrentPlanType" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin-left:50px;">
            Customer Subscription: <f:display bean="customerSubscriptionCurrentPlanType" property="customerSubscription"/><br>
            Plan Type: <f:display bean="customerSubscriptionCurrentPlanType" property="planType.planName"/><br>
            Subscription End: <f:display bean="customerSubscriptionCurrentPlanType" property="subscriptionEnd"/><br>
            Auto Renew: <f:display bean="customerSubscriptionCurrentPlanType" property="autoRenew"/><br>
            </div>
            <g:form resource="${this.customerSubscriptionCurrentPlanType}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.customerSubscriptionCurrentPlanType}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <sec:ifAllGranted roles="ROLE_ADMIN">
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                	</sec:ifAllGranted>
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
