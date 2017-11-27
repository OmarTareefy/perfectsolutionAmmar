<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"
%>
<div id="header"
	class="navbar-toggleable-md shadow-after-3  sticky clearfix"
>

	<!-- TOP NAV -->
	<header id="topNav">
		<div class="container">

			<!-- Mobile Menu Button -->
			<button class="btn btn-mobile" data-toggle="collapse"
				data-target=".nav-main-collapse"
			>
				<i class="fa fa-bars"></i>
			</button>

			<!-- BUTTONS -->
			<ul class="float-right nav nav-pills nav-second-main">
			</ul>
			<!-- /BUTTONS -->


			<!-- Logo -->
			<a class="logo float-left" href="${contextRoot}/home"> <img
				src="${res}/myImages/shared/CompanyLogo1.png" alt=""
			/>
			</a>

			<!-- 
							Top Nav 
							
							AVAILABLE CLASSES:
							submenu-dark = dark sub menu
						-->
			<div class="navbar-collapse collapse float-right nav-main-collapse">
				<nav class="nav-main">
					<ul id="topMain" class="nav nav-pills nav-main">


						<li><c:choose>
								<c:when test="${locale == 'en'}">
									<a href="${currentLocation}?language=ar"> <img
										src="${res}/myImages/shared/ar.png" alt=""
									/></a>
								</c:when>
								<c:otherwise>

									<a href="${currentLocation}?language=en"><img
										src="${res}/myImages/shared/en.png" class="lang-icon" salt=""
									/></a>
								</c:otherwise>
							</c:choose></li>

						<li><a href="${contextRoot}/home"> <spring:message
									code="home"
								/>
						</a></li>
												<li class="dropdown"><a class="dropdown-toggle" href="#"><spring:message
									code="products"
								/></a>
							<ul class="dropdown-menu">

								<c:forEach items="${activeProductCategoriesMap}" var="entry">

									<li class="dropdown"><a class="dropdown-toggle" href="#">
											<c:choose>
												<c:when test="${locale == 'en'}">
									${entry.key.nameEn}
									</c:when>
												<c:otherwise>
														${entry.key.nameAr}
													</c:otherwise>
											</c:choose>

									</a>
										<ul class="dropdown-menu">
											<c:forEach items="${entry.value}" var="product">
												<li><a href="${contextRoot}/product/${product.id}">
														<c:choose>
															<c:when test="${locale == 'en'}">
														${product.nameEn}
													</c:when>
															<c:otherwise>
														${product.nameAr}
													</c:otherwise>
														</c:choose>
												</a></li>
											</c:forEach>
										</ul></li>

								</c:forEach>
							</ul></li>


						<li class="dropdown"><a class="dropdown-toggle" href="#"><spring:message
									code="services"/></a>
							<ul class="dropdown-menu">


								<c:forEach items="${activeServiceCategoriesMap}" var="entry">

									<li class="dropdown"><a class="dropdown-toggle" href="#">
											<c:choose>
												<c:when test="${locale == 'en'}">
									${entry.key.nameEn}
									</c:when>
												<c:otherwise>
														${entry.key.nameAr}
													</c:otherwise>
											</c:choose>

									</a>
										<ul class="dropdown-menu">
											<c:forEach items="${entry.value}" var="service">
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

								</c:forEach>



							</ul></li>




						<li class="dropdown"><a class="dropdown-toggle" href="#"><spring:message
									code="clients"/></a>
							<ul class="dropdown-menu">


								<c:forEach items="${activeClients}" var="client">

									<li><a href="${contextRoot}/client/${client.id}">
											<c:choose>
												<c:when test="${locale == 'en'}">
														${client.nameEn}
												</c:when>
												<c:otherwise>
													${client.nameAr}
												</c:otherwise>
											</c:choose>
									</a></li>
								</c:forEach>
						</ul></li>
						
						
						<li><a href="${contextRoot}/contact"> <spring:message
									code="contact"
								/>
						</a></li>
						<li><a href="${contextRoot}/about"> <spring:message
									code="about"
								/>
						</a></li>

<li><a href="${contextRoot}/manage/home"> <spring:message
										code="manage"
									/>
							</a></li>
							
						<!-- 
						<security:authorize access="hasAuthority('ADMIN')">
							<li><a href="${contextRoot}/manage/home"> <spring:message
										code="manage"
									/>
							</a></li>
						</security:authorize> -->

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
