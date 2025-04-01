<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Admin Dashboard</title>
    </head>
    <body>
    <div id="content" role="main">
    <section class="row colset-2-its">
        <div class="nav" role="navigation">
											<ul>
												<!--<li><button class="button"><span style="color:#ffffff"><g:link controller="customer" action="index"><span style="color:#20395d">Customer Homepage</span></g:link></span></button></li>
												<li><button class="button"><span style="color:#ffffff"><g:link controller="vendor" action="index"><span style="color:#20395d">Vendor Homepage</span></g:link></span></button></li>
												<br><br>
												 
												
												<li><a href="left-sidebar.html">Login</a></li>-->
											</ul>
										</div>
										
										<h1>Admin Dashboard</h1>
										<br><br>

		<p>
        <div id="controllers" role="navigation">
        	<ul>
            		<h3>User Administration:</h3>
            
                    <li class="controller">
                        <g:link controller="user" action="search">User Management</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="role" action="search">Role Management</g:link>
                    </li>
                    <h3>Customer Administration:</h3>
            
                    <li class="controller">
                        <g:link controller="customerMaintenance" action="index">Customer Maintenance</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerMaintenanceRating" action="index">Customer Maintenance Rating</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerMaintenanceStatus" action="index">Customer Maintenance Status</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerMaintenanceType" action="index">Customer Maintenance Type</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerOnboarding" action="index">Customer Onboarding</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerOnboardingMaintenanceFrequency" action="index">Customer Onboarding Maintenance Frequency</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerOnboardingPropertyType" action="index">Customer Onboarding Property Type</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerOnboardingServiceInterests" action="index">Customer Onboarding Service Interests</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerOnboardingServiceInterestsMap" action="index">Customer Onboarding Service Interests Map</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerSubscription" action="index">Customer Subscription</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerSubscriptionPlan" action="index">Customer Subscription Plan</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerSubscriptionCurrentPlanType" action="index">Customer Subscription Current Plan Type</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerPhotos" action="index">Customer Photos</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerMaintenancePhotos" action="index">Customer Maintenance Photos</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerSupportTicket" action="index">Customer Support Ticket</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="customerSupportTicketStatus" action="index">Customer Support Ticket Status</g:link>
                    </li>
                	<h3>Vendor Administration:</h3>
                	<li class="controller">
                        <g:link controller="vendorOnboardingCategories" action="index">Vendor Onboarding Categories</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="vendorOnboarding" action="index">Vendor Onboarding</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="vendorOnboardingServiceArea" action="index">Vendor Onboarding Service Area</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="vendorOnboardingServices" action="index">Vendor Onboarding Services</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="vendorSubscription" action="index">Vendor Subscription</g:link>
                    </li>
                    <li class="controller">
                        <g:link controller="vendorSubscriptionPlan" action="index">Vendor Subscription Plan</g:link>
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
                    <a class="home" href="${createLink(uri: '/')}"><h3>< Back to Homepage</h3></a>
                    <br>
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