<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Vendor Dashboard</title>
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
											<h1>Vendor Dashboard</h1>
											<br><br>
											
		<p>
        <div id="controllers" role="navigation">
        	<ul>
        	<li class="controller">
                        <g:link controller="vendorOnboarding" action="index">Vendor Onboarding</g:link>
                    </li>
            <li class="controller">
                        <g:link controller="vendorSubscription" action="index">Vendor Subscription</g:link>
                    </li>      
            <li class="controller">
                        <g:link controller="vendorSubscriptionCurrentPlanType" action="index">Vendor Subscription Current Plan Type</g:link>
                    </li>
            <li class="controller">
                        <g:link controller="vendorPhotos" action="index">Vendor Photos</g:link>
                    </li>
            <li class="controller">
                        <g:link controller="vendorCertifications" action="index">Vendor Certifications</g:link>
                    </li>      
            <li class="controller">
                        <g:link controller="vendorLicenses" action="index">Vendor Licenses</g:link>
                    </li>  
            <li class="controller">
                		<g:link controller="vendorInvoice" action="index">Vendor Invoice</g:link>
            		</li>
            <li class="controller">
                		<g:link controller="vendorRating" action="index">Vendor Rating</g:link>
            		</li>		
            <li class="controller">
                		<g:link controller="customerSupportTicket" action="index">Customer Support Ticket</g:link>
            </li>
		<a class="home" href="${createLink(uri: '/')}"><h3>< Back to Homepage</h3></a>
		<g:link controller="vendor" action="profile" id="${sec.loggedInUserInfo(field: 'id')}"><h3>Vendor Profile ></h3></g:link>
		<g:form controller="logout">
		<g:submitButton name="logout" value="Logout"/>
		</g:form>							
		</ul>
        </div>
        </p>
	</section>
	</div>
    </body>
</html>