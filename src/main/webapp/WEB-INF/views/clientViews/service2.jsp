
			<!-- HOME -->
			<section id="home">
						
				<div class="container text-center">
					
					<h1 class="m-0 fs-50 fw-300 wow fadeInUp" data-wow-delay="0.4s">${service.nameEn}</h1>	

					<div class="row mt-100 text-left">

						<div class="col-md-8 col-sm-12 mb-30">
							<img class="img-fluid" src="${res}/demo_files/images/laptop.png" alt="" />
						</div>

						<div class="col-md-4 col-sm-12">
						
							${service.descriptionEn}
						</div>
					</div>

				</div>

			</section>
			<!-- /HOME -->

			<!-- FEATURES -->
			<section id="features" class="pt-30">
				<div class="container">

					<header class="text-center mb-30">
						<h2 class="mb-30">Our Services</h2>
						<hr />
					</header>

					<!-- FEATURED BOXES 3 -->
					<div class="row">
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
							<img alt="" class="ico-light ico-lg ico-rounded img-icon" src="${res}/demo_files/images/laptop.png">
								<h4>Pixel Perfect</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
							</div>
						</div>
						





						
						<c:forEach begin="0" end="10" varStatus="loop">

							<div class="col-md-3 col-xs-6">
								<div class="text-center">
								<img alt="" class="ico-light ico-lg ico-rounded img-icon" src="${res}/demo_files/images/laptop.png">
							<a href="${contextRoot}/service/1" >	<h4 class="h4-icon-hover">Pixel Perfect</h4></a>
									<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
								</div>
							</div>

    						
						</c:forEach>






						
						
						
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-piechart"></i>
								<h4>Graphs</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
							</div>
						</div>
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-strategy"></i>
								<h4>Startegy</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
							</div>
						</div>
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-streetsign"></i>
								<h4>SEO Optimized</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus. </p>
							</div>
						</div>
			
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-trophy"></i>
								<h4>Winners</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
							</div>
						</div>
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-gears"></i>
								<h4>Responsive</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
							</div>
						</div>
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-tools"></i>
								<h4>Costomizable</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus.</p>
							</div>
						</div>
						<div class="col-md-3 col-xs-6">
							<div class="text-center">
								<i class="ico-light ico-lg ico-rounded ico-hover et-layers"></i>
								<h4>Easy to Modify</h4>
								<p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus. </p>
							</div>
						</div>
					</div>
					<!-- /FEATURED BOXES 3 -->

				</div>
			</section>
			<!-- /FEATURES -->
