<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="main" />
        <title>Customer Dashboard</title>
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
											<h1>Customer Dashboard</h1>
										<br><br>

		<p>
        <div id="controllers" role="navigation">
        	<ul>
        	<h3>Customer Services:</h3>
            		<li class="controller">
            			<g:if test="${customerOnboarding != null}">
                        <g:link controller="customerOnboarding" action="edit" id="${customerOnboarding.id}">Edit Customer Onboarding</g:link>
                        </g:if>
                        <g:else>
                        <g:link controller="customerOnboarding" action="create">Create Customer Onboarding</g:link>
                        </g:else>
                    </li>
                    <li class="controller">
                        <g:link controller="customerMaintenance" action="index">Customer Maintenance</g:link>
                    </li>
                    <li class="controller">
                    	<g:if test="${customerSubscription != null}">
                        <g:link controller="customerSubscription" action="edit" id="${customerSubscription.id}">Edit Customer Subscription</g:link>
                        </g:if>
                        <g:else>
                        <g:link controller="customerSubscription" action="create">Create Customer Subscription</g:link>
                        </g:else>
                    </li>
                    <li class="controller">
                        <g:if test="${customerSubscriptionCurrentPlanType != null}">
                        <g:link controller="customerSubscriptionCurrentPlanType" action="edit" id="${customerSubscriptionCurrentPlanType.id}">Edit Customer Subscription Plan</g:link>
                        </g:if>
                        <g:else>
                        <g:link controller="customerSubscriptionCurrentPlanType" action="create">Create Customer Subscription Plan</g:link>
                        </g:else>
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
                        <g:link controller="customerInvoice" action="index">Customer Invoice</g:link>
                    </li>
                    <li class="controller">
                		<g:link controller="customerVideos" action="index">Customer Videos</g:link>
            		</li>
            		<li class="controller">
                		<g:link controller="customerMaintenanceInvoice" action="index">Customer Maintenance Invoice</g:link>
            		</li>
		<a class="home" href="${createLink(uri: '/')}"><h3>< Back to Homepage</h3></a>
		<g:link controller="customer" action="profile" id="${sec.loggedInUserInfo(field: 'id')}"><h3>Customer Profile ></h3></g:link>
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