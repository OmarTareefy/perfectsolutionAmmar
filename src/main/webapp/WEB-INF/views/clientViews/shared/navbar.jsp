<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<div id="header" class="navbar-toggleable-md sticky clearfix">

	<!-- TOP NAV -->
	<header id="topNav">
		<div class="container">

			<!-- Mobile Menu Button -->
			<button class="btn btn-mobile" data-toggle="collapse"
				data-target=".nav-main-collapse">
				<i class="fa fa-bars"></i>
			</button>

			<!-- BUTTONS -->
			<ul class="float-right nav nav-pills nav-second-main">
			</ul>
			<!-- /BUTTONS -->


			<!-- Logo -->
			<a class="logo float-left" href="${contextRoot}/home"> <img
				src="${res}/images/_smarty/logo_dark.png" alt="" />
			</a>

			<!-- 
							Top Nav 
							
							AVAILABLE CLASSES:
							submenu-dark = dark sub menu
						-->
			<div class="navbar-collapse collapse float-right nav-main-collapse">
				<nav class="nav-main">
					<ul id="topMain" class="nav nav-pills nav-main">
						<li><a href="${currentLocation}?language=en"> English </a></li>
						<li><a href="${currentLocation}?language=ar"> Arabic </a></li>
						<li><a href="${contextRoot}/home"> <spring:message
									code="home" />
						</a></li>

						<li><a href="${contextRoot}/contact"> <spring:message
									code="contact" />
						</a></li>
						<li><a href="${contextRoot}/about"> <spring:message
									code="about" />
						</a></li>
						
						<li class="dropdown"><a class="dropdown-toggle" href="#"><spring:message
									code="services" /></a>
							<ul class="dropdown-menu">


								<c:forEach items="${services}" var="service">
									<li><a href="${contextRoot}/service/${service.id}">
										<c:choose>
											<c:when test="${locale == 'en'}">
												${service.nameEn}
											</c:when>
											<c:otherwise>
												${service.nameAr}
											</c:otherwise>
										</c:choose>
									</a></li>
								</c:forEach>



						</ul></li>

							<li><a href="${contextRoot}/manage/home"> <spring:message
								code="manage" />
							</a></li>						
						<!-- 
						<security:authorize access="hasAuthority('ADMIN')">
							<li><a href="${contextRoot}/manage"> <spring:message
								code="manage" />
							</a></li>
						</security:authorize>
						 -->

						<!-- 
										MENU ANIMATIONS
											.nav-animate-fadeIn
											.nav-animate-fadeInUp
											.nav-animate-bounceIn
											.nav-animate-bounceInUp
											.nav-animate-flipInX
											.nav-animate-flipInY
											.nav-animate-zoomIn
											.nav-animate-slideInUp

											.nav-hover-animate 		= animate text on hover

											.hover-animate-bounceIn = bounceIn effect on mouse over of main menu
									-->

					</ul>

				</nav>
			</div>

		</div>
	</header>
	<!-- /Top Nav -->

</div>
