
			<!-- HOME -->
			<section id="home">
						
				<div class="container text-center">
					
					<h1 class="m-0 fs-50 fw-300 wow fadeInUp" data-wow-delay="0.4s">
						<c:choose>
							<c:when test="${locale == 'en'}">
								${client.nameEn}
							</c:when>
							<c:otherwise>
								${client.nameAr}
							</c:otherwise>
						</c:choose>
					</h1>

					<div class="row mt-100 text-left">

						<div class="offset-md-2 col-md-8 col-sm-12 mb-30">
						
							<img class="img-fluid images" src="${AdminRes}/myImages/${client.code}.jpg"/>
						</div>

						
					</div>

				</div>

			</section>
			<!-- /HOME -->

			<!-- FEATURES -->
			<section id="features" class="pt-30">
				<div class="container">

					<header class="text-center mb-30">
						<h2 class="mb-30">
							<spring:message code="clients"/>
						</h2>
						<hr />
					</header>

					<!-- FEATURED BOXES 3 -->
					<div class="row">
						<c:forEach items="${activeClients}" var="client">

							<div class="col-md-3 col-xs-6">
								<div class="text-center">
								<img alt="" class="ico-light ico-lg ico-rounded img-icon" src="${AdminRes}/myImages/${client.code}.jpg"/>
								<a href="${contextRoot}/client/${client.id}" >	<h4 class="h4-icon-hover">
									<c:choose>
										<c:when test="${locale == 'en'}">
											${client.nameEn}
										</c:when>
										<c:otherwise>
											${client.nameAr}
										</c:otherwise>
									</c:choose>
								</h4></a>
								
								</div>
							</div>

    						
						</c:forEach>
					</div>
					<!-- /FEATURED BOXES 3 -->

				</div>
			</section>
			<!-- /FEATURES -->
