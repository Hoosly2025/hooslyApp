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
		<a class="home" href="${createLink(uri: '/')}"><h3>< Back to Homepage</h3></a>
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