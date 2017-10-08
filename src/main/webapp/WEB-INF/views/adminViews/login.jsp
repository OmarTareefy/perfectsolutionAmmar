<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url var="res" value="/resources" />

<c:set var="currentLocation"
	value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:set var="locale" value="${pageContext.response.locale}" />
<c:set var="valid">
this.setCustomValidity('<spring:message code="validationMessage" />')
</c:set>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>${title}</title>
<meta name="description" content="This is the perfectsolution website" />
<meta name="Author" content="perfectsolution" />
<!-- mobile settings -->
<meta name="viewport" content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />

<!-- mobile settings -->
<meta name="viewport"
	content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />
<!--[if IE]><meta http-equiv='X-UA-Compatible' content='IE=edge,chrome=1'><![endif]-->

<!-- WEB FONTS : use %7C instead of | (pipe) -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600%7CRaleway:300,400,500,600,700%7CLato:300,400,400italic,600,700"
	rel="stylesheet" type="text/css" />

<!-- CORE CSS -->
<link href="${res}/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<!-- THEME CSS -->
<link href="${res}/css/essentials.css" rel="stylesheet" type="text/css" />
<link href="${res}/css/layout.css" rel="stylesheet" type="text/css" />

<!-- PAGE LEVEL SCRIPTS -->
<link href="${res}/css/header-1.css" rel="stylesheet" type="text/css" />
<link href="${res}/css/color_scheme/green.css" rel="stylesheet"
	type="text/css" id="color_scheme" />

<!-- REVOLUTION SLIDER -->
<link href="${res}/plugins/slider.revolution/css/extralayers.css"
	rel="stylesheet" type="text/css" />
<link href="${res}/plugins/slider.revolution/css/settings.css"
	rel="stylesheet" type="text/css" />

<c:choose>
	<c:when test="${locale == 'ar'}">
		<link href="${res}/css/layout-RTL.css" rel="stylesheet"
			type="text/css" />
		<link href="${res}/plugins/bootstrap/RTL/bootstrap-rtl-merged.min.css"
			rel="stylesheet" type="text/css" />

		<link href="${res}/css/myapp_rtl.css" rel="stylesheet" type="text/css" />

	</c:when>
	<c:otherwise>
		<link href="${res}/css/myapp_ltr.css" rel="stylesheet" type="text/css" />
	</c:otherwise>
</c:choose>


<link href="${res}/css/myapp.css" rel="stylesheet" type="text/css" />

</head>

<!--
		.boxed = boxed version
	-->
<body>
	<div class="wrapper">
		<!-- Navigation comes here-->

		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="container">
				<!-- brand and toggle ger grouped for better mobile dispaly -->
				<div class="navbar-header">
					<a class="navbar-brand" href="${contextRoot}/home">Online
						Shopping</a>
				</div>
			</div>



		</nav>


		<!-- Page Content -->
		<div class="content">

			<div class="container">
			
			<!-- will be displayed if the credientials are wrong -->
			<c:if test="${not empty message}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-danger">
							${message}
						</div>
					</div>
				</div>
			</c:if>

			<!-- will be displayed if the user has logged out -->
			<c:if test="${not empty logout}">
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="alert alert-success">
							${logout}
						</div>
					</div>
				</div>
			</c:if>
						
				<div class="row">
					<div class="col-md-offset-3 col-md-6">
						<div class="panel panel-primary">

							<div class="panel-heading">
								<h4>Login</h4>
							</div>

							<div class="panel-body">

								<!-- Form Elements -->
								<form action="${contextRoot}/login" class="form-horizontal" method="POST" id="loginForm">

									<div class="form-group">
										<label for="username" class="control-label col-md-4">Email: </label>
										<div class="col-md-8">
											<input type="text" name="username" id="username" autofocus="autofocus" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<label for="password" class="control-label col-md-4">Password: </label>
										<div class="col-md-8">
											<input type="password" name="password" id="password" class="form-control" />
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-offset-4 col-md-8">
											<input type="submit" value="Login" class="btn btn-primary" />
											<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>


	<!-- JAVASCRIPT FILES -->
	<script type="text/javascript">
		var plugin_path = '${res}/plugins/';
	</script>
	<script type="text/javascript"
		src="${res}/plugins/jquery/jquery-3.2.1.min.js"></script>

	<script type="text/javascript" src="${res}/js/scripts.js"></script>


	<!-- REVOLUTION SLIDER -->
	<script type="text/javascript"
		src="${res}/plugins/slider.revolution/js/jquery.themepunch.tools.min.js"></script>
	<script type="text/javascript"
		src="${res}/plugins/slider.revolution/js/jquery.themepunch.revolution.min.js"></script>
	<script type="text/javascript"
		src="${res}/js/view/demo.revolution_slider.js"></script>

	<!-- self coded script -->
	<script src="${res}/js/myapp.js"></script>
</body>
</html>