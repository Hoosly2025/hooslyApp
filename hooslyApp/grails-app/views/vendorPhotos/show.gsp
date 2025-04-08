<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <g:set var="entityName" value="${message(code: 'vendorPhotos.label', default: 'VendorPhotos')}" />
        <title><g:message code="default.show.label" args="[entityName]" /></title>
    </head>
    <body>
        <a href="#show-vendorPhotos" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
        <div class="nav" role="navigation">
            <ul>
                <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
                <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
                <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
            </ul>
        </div>
        <div id="show-vendorPhotos" class="content scaffold-show" role="main">
            <h1><g:message code="default.show.label" args="[entityName]" /></h1>
            <g:if test="${flash.message}">
            <div class="message" role="status">${flash.message}</div>
            </g:if>
            <div style="margin-left:50px;">
            Create Time: <f:display bean="vendorPhotos" property="createTime"/><br>
            Name: <f:display bean="vendorPhotos" property="name"/><br>
            Description: <f:display bean="vendorPhotos" property="description"/><br>
            Filename: <f:display bean="vendorPhotos" property="filename"/><br>
            Vendor: <f:display bean="vendorPhotos" property="vendor"/><br>
            Update Time: <f:display bean="vendorPhotos" property="updateTime"/><br>
            <img src="data:image/jpg;base64,${vendorPhotos.fileUpload?.encodeBase64()}"/>
            </div>
            <g:form resource="${this.vendorPhotos}" method="DELETE">
                <fieldset class="buttons">
                    <g:link class="edit" action="edit" resource="${this.vendorPhotos}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
                    <input class="delete" type="submit" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
                </fieldset>
            </g:form>
        </div>
    </body>
</html>
