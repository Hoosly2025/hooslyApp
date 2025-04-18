<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Vendor Profile</title>
    </head>
    <body>
    <div id="content" role="main">
    <section class="row colset-2-its">
        <div class="nav" role="navigation">
											<ul>
												<!--<li><button class="button"><span style="color:#ffffff"><g:link controller="admin" action="index"><span style="color:#20395d">Admin Homepage</span></g:link></span></button></li>
												<li><button class="button"><span style="color:#ffffff"><g:link controller="vendor" action="index"><span style="color:#20395d">Vendor Homepage</span></g:link></span></button></li>
												<br><br>
												 
												
												<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
											</div>
											<h1>Vendor Profile</h1>
											<br><br>
											
		<p>
		<g:if test="${vendorOnboarding}">
        <div id="show-vendorOnboarding" class="content scaffold-show" role="main">
        	<div style="margin-left:200px;">
        	<p><span style="font-size:25px;color:#000000">Vendor Details:</span></p>
            Company Name: <f:display bean="vendorOnboarding" property="companyName"/><br>
            Primary Contact Name: <f:display bean="vendorOnboarding" property="primaryContactName"/><br>
    		Primary Contact Email: <f:display bean="vendorOnboarding" property="primaryContactEmail"/><br>
    		Primary Contact Phone: <f:display bean="vendorOnboarding" property="primaryContactPhone"/><br>
    		Business Street Address: <f:display bean="vendorOnboarding" property="businessStreetAddress"/><br>
    		Business City: <f:display bean="vendorOnboarding" property="businessCity"/><br>
    		Business State: <f:display bean="vendorOnboarding" property="businessState"/><br>
    		Business Zip Code: <f:display bean="vendorOnboarding" property="businessZipCode"/><br>
            
            </div>
        </g:if>
        <g:if test="${vendorPhotos}">
        <div style="margin-left:200px;">
        <p><span style="font-size:25px;color:#000000">Vendor Photos:</span></p>
        <g:each in="${vendorPhotos}" status="j" var="vendorPhotosInstance">
        <img src="data:image/jpg;base64,${vendorPhotosInstance.fileUpload?.encodeBase64()}"/>
        </g:each>
        </div>
        </g:if>
        <g:if test="${vendorVideos}">
        <div style="margin-left:200px;">
        <p><span style="font-size:25px;color:#000000">Vendor Videos:</span></p>
        <g:each in="${vendorVideos}" status="j" var="vendorVideosInstance">
        <iframe width="560" height="315" src="https://www.youtube.com/embed/${vendorVideosInstance.video}" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </g:each>
        </div>
        </g:if>
        <g:if test="${vendorLicenses}">
        <div style="margin-left:200px;">
        <p><span style="font-size:25px;color:#000000">Vendor Licenses:</span></p>
        <g:each in="${vendorLicenses}" status="j" var="vendorLicensesInstance">
        	Name: ${vendorLicensesInstance.name}<br>
            Description: ${vendorLicensesInstance.description}<br>
            Filename: ${vendorLicensesInstance.filename}<br>
            <g:link controller="vendor" action="downloadLicense" id="${vendorLicensesInstance.id}">Download</g:link>
        </g:each>
        </div>
        </g:if>
        <g:if test="${vendorCertifications}">
        <div style="margin-left:200px;">
        <p><span style="font-size:25px;color:#000000">Vendor Certifications:</span></p>
        <g:each in="${vendorCertifications}" status="j" var="vendorCertificationsInstance">
        	Name: ${vendorCertificationsInstance.name}<br>
            Description: ${vendorCertificationsInstance.description}<br>
            Filename: ${vendorCertificationsInstance.filename}<br>
            <g:link controller="vendor" action="downloadCertification" id="${vendorCertificationsInstance.id}">Download</g:link>
        </g:each>
        </div>
        </g:if>
		<a class="home" href="${createLink(uri: '/')}"><h3>< Back to Homepage</h3></a>
        <g:form controller="logout">
		<g:submitButton name="logout" value="Logout"/>
		</g:form>							
		
        </div>
        </p>
	</section>
	</div>
    </body>
</html>