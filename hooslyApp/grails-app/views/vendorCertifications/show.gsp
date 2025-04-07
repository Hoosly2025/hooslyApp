<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'vendorCertifications.label', default: 'VendorCertifications')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-vendorCertifications" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-vendorCertifications" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin-left:50px;">
            Create Time: <f:display bean="vendorCertifications" property="createTime"/><br>
            Name: <f:display bean="vendorCertifications" property="name"/><br>
            Description: <f:display bean="vendorCertifications" property="description"/><br>
            Filename: <f:display bean="vendorCertifications" property="filename"/><br>
            Vendor: <f:display bean="vendorCertifications" property="vendor"/><br>
            Update Time: <f:display bean="vendorCertifications" property="updateTime"/><br>
            <g:link action="download" resource="${this.vendorCertifications}">Download</g:link>
            </div>
            <g:form resource="${this.vendorCertifications}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.vendorCertifications}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
