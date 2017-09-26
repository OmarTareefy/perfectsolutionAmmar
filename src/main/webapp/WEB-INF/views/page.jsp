<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<spring:url var="res" value="/resources" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<c:set var="locale" value="${pageContext.response.locale}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<title>${title}</title>
<meta name="description" content="This is the perfectsolution website" />
<meta name="Author" content="perfectsolution" />

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


<c:if test="${locale == 'ar'}"> 
	<link href="${res}/css/layout-RTL.css"
		rel="stylesheet" type="text/css" />
	<link href="${res}/plugins/bootstrap/RTL/bootstrap-rtl-merged.min.css"
		rel="stylesheet" type="text/css" />
</c:if>


<link href="${res}/css/myapp.css"
	rel="stylesheet" type="text/css" />

</head>

<body class="smoothscroll enable-animation <spring:message code='ifArabic'/>">


	<!-- slidetop comes here-->

	<%@include file="./shared/slidetop.jsp"%>



	<!-- wrapper -->
	<div id="wrapper">



		<!-- navbar comes here-->
		<%@include file="./shared/navbar.jsp"%>


		<!-- home comes here-->
		<c:if test="${userClickHome == true}">
			<%@include file="home.jsp"%>
		</c:if>
		
		<!-- Contact us comes here-->
		<c:if test="${userClickContact == true}">
			<%@include file="contact.jsp"%>
		</c:if>
		



		<%@include file="./shared/footer.jsp"%>

	</div>
	<!-- /wrapper -->

	<!-- SCROLL TO TOP -->
	<a href="#" id="toTop"></a>


	<!-- PRELOADER -->
	<div id="preloader">
		<div class="inner">
			<span class="loader"></span>
		</div>
	</div>
	<!-- /PRELOADER -->



	<!-- JAVASCRIPT FILES -->
	<script type="text/javascript">
		var plugin_path = '${res}/plugins/';
	</script>
	<script type="text/javascript"
		src="${res}/plugins/jquery/jquery-3.2.1.min.js"></script>

	<script type="text/javascript" src="${res}/js/scripts.js"></script>

	<!-- STYLESWITCHER - REMOVE -->
	<script async type="text/javascript"
		src="demo_files/styleswitcher/styleswitcher.js"></script>

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