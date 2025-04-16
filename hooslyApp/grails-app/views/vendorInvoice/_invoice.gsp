<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
	<title>Vendor Invoice</title>
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
										<g:if test="${vendorInvoice}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Invoice Number: ${invoiceNumber}</span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Date: <f:display bean="vendorInvoice" property="createTime"/></span></p>
										</g:if>
										<g:if test="${vendorSubscription}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Subscription Start: <f:display bean="vendorSubscription" property="subscriptionStart"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Renewal: <f:display bean="vendorSubscription" property="renewal"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Payment Method: <f:display bean="vendorSubscription" property="paymentMethod"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Last Payment: <f:display bean="vendorSubscription" property="lastPayment"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Next Billing: <f:display bean="vendorSubscription" property="nextBilling"/></span></p>
										</g:if>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Billed to:</span></p>
										<g:if test="${vendorOnboarding}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Company Name: <f:display bean="vendorOnboarding" property="companyName"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Primary Contact Name: <f:display bean="vendorOnboarding" property="primaryContactName"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Primary Contact Email: <f:display bean="vendorOnboarding" property="primaryContactEmail"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Primary Contact Phone: <f:display bean="vendorOnboarding" property="primaryContactPhone"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Business Street Address: <f:display bean="vendorOnboarding" property="businessStreetAddress"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Business City: <f:display bean="vendorOnboarding" property="businessCity"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Business State: <f:display bean="vendorOnboarding" property="businessState"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Business Zip Code: <f:display bean="vendorOnboarding" property="businessZipCode"/></span></p>
										</g:if>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Service Plan:</span></p>
										<g:if test="${vendorSubscriptionPlan}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Plan name: <f:display bean="vendorSubscriptionPlan" property="planName"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Plan Fee: <f:display bean="vendorSubscriptionPlan" property="planFee"/></span></p>
										<br></br>
										<p><span style="font-size:30px;color:#000000">Total Due: ${vendorSubscriptionPlan.planFee}</span></p>
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