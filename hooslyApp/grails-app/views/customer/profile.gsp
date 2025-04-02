<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Customer Profile</title>
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
											<h1>Customer Profile</h1>
										<br><br>

		<p>
        <div id="show-customerOnboarding" class="content scaffold-show" role="main">
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