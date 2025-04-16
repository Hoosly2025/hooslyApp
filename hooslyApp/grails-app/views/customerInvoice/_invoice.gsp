<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
	<title>Customer Invoice</title>
	</head>
	<body class="homepage">
	
		<!-- Header Wrapper -->
		<div id="header-wrapper">
			<div class="container">
				
					
				<!-- Intro -->
				<div class="row">
					<div class="12u">
						<section>
							<div>
								<div class="row">
									<div class="12u">
										<section class="box">
										<asset:image src="liveoakhomefooter.png" alt="Hoosly Logo"/>
										<header>
											<p><span style="font-size:35px;color:#000000">Invoice</span></p>
										</header>
										<g:if test="${customerInvoice}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Invoice Number: <f:display bean="customerInvoice" property="invoiceNumber"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Date: <f:display bean="customerInvoice" property="createTime"/></span></p>
										</g:if>	
										<g:if test="${customerSubscription}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Subscription Start: <f:display bean="customerSubscription" property="subscriptionStart"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Renewal: <f:display bean="customerSubscription" property="renewal"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Payment Method: <f:display bean="customerSubscription" property="paymentMethod"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Last Payment: <f:display bean="customerSubscription" property="lastPayment"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Next Billing: <f:display bean="customerSubscription" property="nextBilling"/></span></p>
										</g:if>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Billed to:</span></p>
										<g:if test="${customerOnboarding}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">First name: <f:display bean="customerOnboarding" property="firstName"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Last name: <f:display bean="customerOnboarding" property="lastName"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Phone: <f:display bean="customerOnboarding" property="phone"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Street Address: <f:display bean="customerOnboarding" property="streetAddress"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">City: <f:display bean="customerOnboarding" property="city"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">State: <f:display bean="customerOnboarding" property="state"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Zip Code: <f:display bean="customerOnboarding" property="zipCode"/></span></p>
										</g:if>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Service Plan:</span></p>
										<g:if test="${customerSubscriptionPlan}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Plan name: <f:display bean="customerSubscriptionPlan" property="planName"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Plan fee: <f:display bean="customerSubscriptionPlan" property="planFee"/></span></p>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Total Due: ${customerSubscriptionPlan.planFee}</span></p>
										</g:if>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Payment Options:</span></p>
										<p><span style="font-size:25px;color:#000000">Pay Online: Payment Link</span></p>
										<p><span style="font-size:25px;color:#000000">Bank Transfer: Bank Details</span></p>
										<p><span style="font-size:25px;color:#000000">Auto Pay Setup: Auto Pay Link</span></p>
										<br></br>
										<p><span style="font-size:22px;color:#000000">Questions? Contact billing@hoosly.com</span></p>
										</section>
									</div>
								</div>
							</div>
						</section>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>