<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
 "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
	<head>
	<title>Customer Maintenance Invoice</title>
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
											<p><span style="font-size:35px;color:#000000">Customer Maintenance Invoice</span></p>
										</header>
										<g:if test="${customerMaintenanceInvoice}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Invoice Number: <f:display bean="customerMaintenanceInvoice" property="invoiceNumber"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Date: <f:display bean="customerMaintenanceInvoice" property="createTime"/></span></p>
										</g:if>	
										<g:if test="${customerMaintenance}">
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Maintenance Details: <f:display bean="customerMaintenance" property="maintenanceDetails"/></span></p>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Maintenance Completion Date: <f:display bean="customerMaintenance" property="maintenanceCompletionDate"/></span></p>
										<br></br>
										<p><span style="font-size:20px;color:#000000;font-family: Arial, Helvetica, sans-serif;">Total Due: <f:display bean="customerMaintenance" property="costDetails"/></span></p>
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
										<p><span style="font-size:30px;color:#000000">Vendor Details:</span></p>
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