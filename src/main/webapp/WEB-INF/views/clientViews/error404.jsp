<!-- 
				PAGE HEADER 
				
				CLASSES:
					.page-header-xs	= 20px margins
					.page-header-md	= 50px margins
					.page-header-lg	= 80px margins
					.page-header-xlg= 130px margins
					.dark			= dark page header

					.shadow-before-1 	= shadow 1 header top
					.shadow-after-1 	= shadow 1 header bottom
					.shadow-before-2 	= shadow 2 header top
					.shadow-after-2 	= shadow 2 header bottom
					.shadow-before-3 	= shadow 3 header top
					.shadow-after-3 	= shadow 3 header bottom
			-->
<section class="page-header dark">
	<div class="container">

		<h1><spring:message code="pageNotFound" /></h1>

		<!-- breadcrumbs -->
		<ol class="breadcrumb">
			<li><a href="${contextRoot}/home"><spring:message code="home" /></a></li>
			<li class="active"><spring:message code="erro404" /></li>
		</ol>
		<!-- /breadcrumbs -->

	</div>
</section>
<!-- /PAGE HEADER -->




<!-- -->
<section class="section-xlg">
	<div class="container">

		<div class="row">

			<div class="col-md-6 col-sm-6 hidden-xs-down">

				<div class="error-404">404</div>

			</div>

			<div class="col-md-6 col-sm-6">

				<h3 class="m-0">
					<spring:message code="sorryPageNotFound" />
				</h3>

				<div class="divider mb-0">
					<!-- divider -->
				</div>

				<a class="fs-16 font-lato" href="index.html"><i
					class="glyphicon glyphicon-menu-left mr-10 fs-12"></i><spring:message code="backToMainPage" /></a>

			</div>

		</div>

	</div>
</section>
<!-- / -->
