<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<spring:url var="res" value="/adminResources" />
<spring:url var="sharedRes" value="/sharedResources" />

<c:set var="currentLocation"
	value="${requestScope['javax.servlet.forward.request_uri']}" />
<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!doctype html>
<html lang="en-US">
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-type" content="text/html; charset=utf-8" />
<title>${title}</title>
<meta name="description" content="" />
<meta name="Author" content="Dorin Grigoras [www.stepofweb.com]" />

<script>
	window.menu = '${title}';
</script>

<!-- mobile settings -->
<meta name="viewport"
	content="width=device-width, maximum-scale=1, initial-scale=1, user-scalable=0" />

<!-- WEB FONTS -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700,800&amp;subset=latin,latin-ext,cyrillic,cyrillic-ext"
	rel="stylesheet" type="text/css" />

<!-- CORE CSS -->
<link href="${res}/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<!-- THEME CSS -->
<link href="${res}/css/essentials.css" rel="stylesheet" type="text/css" />
<link href="${res}/css/layout.css" rel="stylesheet" type="text/css" />
<link href="${res}/css/color_scheme/green.css" rel="stylesheet"
	type="text/css" id="color_scheme" />
<link href="${sharedRes}/css/myapp.css" rel="stylesheet" type="text/css" />

</head>
<!--
		.boxed = boxed version
	-->
<body>


	<!-- WRAPPER -->
	<div id="wrapper" class="clearfix">

		<!-- sidebar-->
		<%@include file="./shared/sidebar.jsp"%>

		<!-- header-->
		<%@include file="./shared/header.jsp"%>

		<!-- MIDDLE -->
		<section id="middle">

			<!-- page title -->
			<header id="page-header">
				<h1>${title}</h1>
				<ol class="breadcrumb">
					<li><a href="${contextRoot}/manage/home">Home</a></li>
					<li class="active">${title}</li>
				</ol>
			</header>
			<!-- /page title -->


			<div id="content" class="dashboard padding-20">

				<!-- home comes here-->
				<c:if test="${userClickAdminHome == true}">
					<%@include file="adminHome.jsp"%>
				</c:if>


				<!-- about comes here-->
				<c:if test="${userClickAdminAbout == true}">
					<%@include file="adminAbout.jsp"%>
				</c:if>

				<!-- services comes here-->
				<c:if test="${userClickAdminService == true}">
					<%@include file="adminService.jsp"%>
				</c:if>
				
				<!-- products comes here-->
				<c:if test="${userClickAdminProduct == true}">
					<%@include file="adminProduct.jsp"%>
				</c:if>

			</div>
		</section>
		<!-- /MIDDLE -->

	</div>

	<!-- JAVASCRIPT FILES -->
	<script type="text/javascript">
		var plugin_path = '${res}/plugins/';
	</script>
	<script type="text/javascript"
		src="${res}/plugins/jquery/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${res}/js/app.js"></script>
	<script type="text/javascript"
		src="${sharedRes}/plugins/jquery/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="${sharedRes}/js/myapp.js"></script>
</body>
</html>