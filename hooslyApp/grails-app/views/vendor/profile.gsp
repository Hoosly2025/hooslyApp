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
        <div id="show-vendorOnboarding" class="content scaffold-show" role="main">
        	<div style="margin-left:50px;">
            Company Name: <f:display bean="vendorOnboarding" property="companyName"/><br>
            Primary Contact Name: <f:display bean="vendorOnboarding" property="primaryContactName"/><br>
    		Primary Contact Email: <f:display bean="vendorOnboarding" property="primaryContactEmail"/><br>
    		Primary Contact Phone: <f:display bean="vendorOnboarding" property="primaryContactPhone"/><br>
    		Business Street Address: <f:display bean="vendorOnboarding" property="businessStreetAddress"/><br>
    		Business City: <f:display bean="vendorOnboarding" property="businessCity"/><br>
    		Business State: <f:display bean="vendorOnboarding" property="businessState"/><br>
    		Business Zip Code: <f:display bean="vendorOnboarding" property="businessZipCode"/><br>
            
            </div>
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