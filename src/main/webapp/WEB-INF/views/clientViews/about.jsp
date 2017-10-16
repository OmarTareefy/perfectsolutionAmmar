
<section class="page-header page-header-xlg parallax parallax-3"
	style="background-image: url('${res}/myImages/about/aboutCover.jpg')">
	<div class="overlay dark-5">
		<!-- dark overlay [1 to 9 opacity] -->
	</div>
	
	<div class="container">
		<h1><spring:message code="about" /></h1>

		<!-- breadcrumbs -->
		<ol class="breadcrumb">
			<li><a href="${contextRoot}/home"><spring:message code="home" /></a></li>
			<li class="active"><spring:message code="about" /></li>
		</ol>
		<!-- /breadcrumbs -->

	</div>
</section>
<!-- /PAGE HEADER -->

<section>
	<div class="container">

		<div class="row">

			<!-- LEFT -->

			<div class=" col-md-10 offset-md-1">

				<img class="float-left" src="${res}/myImages/about/smart-min.png" alt="" />

				<div class="heading-title">
					<h2><spring:message code="whoWeAre" /></h2>
				</div>

				<c:choose>
					<c:when test="${locale == 'en'}">
						${about.descriptionEn}
					</c:when>
					<c:otherwise>
						${about.descriptionAr}
					</c:otherwise>
				</c:choose>


				<div class="row mt-60">

					<div class="col-sm-6">
						<div class="heading-title heading-border-bottom heading-color">
							<h3><spring:message code="mission" /></h3>
						</div>

							<c:choose>
								<c:when test="${locale == 'en'}">
									${about.missionEn}
								</c:when>
								<c:otherwise>
									${about.missionAr}
								</c:otherwise>
							</c:choose>

					</div>

					<div class="col-sm-6">
						<div class="heading-title heading-border-bottom heading-color">
							<h3><spring:message code="vision" /></h3>
						</div>
							<c:choose>
								<c:when test="${locale == 'en'}">
									${about.visionEn}
								</c:when>
								<c:otherwise>
									${about.visionAr}
								</c:otherwise>
							</c:choose>

					</div>

				</div>
			</div>
			<!-- /LEFT -->

		</div>

	</div>
</section>
<!-- / -->
