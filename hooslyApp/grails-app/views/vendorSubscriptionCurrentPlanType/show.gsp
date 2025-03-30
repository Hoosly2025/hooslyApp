<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'vendorSubscriptionCurrentPlanType.label', default: 'VendorSubscriptionCurrentPlanType')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-vendorSubscriptionCurrentPlanType" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-vendorSubscriptionCurrentPlanType" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin-left:50px;">
            Vendor Subscription: <f:display bean="vendorSubscriptionCurrentPlanType" property="vendorSubscription.vendor"/><br>
            Plan Type: <f:display bean="vendorSubscriptionCurrentPlanType" property="planType.planName"/><br>
            Subscription End: <f:display bean="vendorSubscriptionCurrentPlanType" property="subscriptionEnd"/><br>
            Auto Renew: <f:display bean="vendorSubscriptionCurrentPlanType" property="autoRenew"/><br>
            </div>
            <g:form resource="${this.vendorSubscriptionCurrentPlanType}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.vendorSubscriptionCurrentPlanType}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
