<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <asset:link rel="icon" href="favicon.ico" type="image/x-ico"/>

    <asset:stylesheet src="application.css"/>
	<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark navbar-static-top" role="navigation">
    <a class="navbar-brand" href="/#"><asset:image src="liveoakhomefooter.png" alt="Grails Logo"/></a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" aria-expanded="false" style="height: 0.8px;" id="navbarContent">
        <ul class="nav navbar-nav ml-auto">
            <g:pageProperty name="page.nav"/>
        </ul>
    </div>

</nav>

<g:layoutBody/>

<div class="footer row" role="contentinfo">
    <div class="col">
        <g:link controller="customer" action="index"><asset:image src="advancedgrails.svg" alt="Customers" class="float-left"/></g:link>
        <strong class="centered"><g:link controller="customer" action="index">Customers</g:link></strong>
        <p>Maintenance.</p>

    </div>
    <div class="col">
        <g:link controller="vendor" action="index"><asset:image src="documentation.svg" alt="Vendors" class="float-left"/></g:link>
        <strong class="centered"><g:link controller="vendor" action="index">Vendors</g:link></strong>
        <p>Management.</p>

    </div>
</div>


<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<asset:javascript src="application.js"/>

</body>
</html>
