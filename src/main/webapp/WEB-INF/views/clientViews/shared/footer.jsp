
<!-- FOOTER -->
<footer id="footer">
	<div class="container">

		<div class="row">

			<div class="col-md-4">
		
				<!-- <img class="footer-logo" src="${res}/images/_smarty/logo-footer.png"
					alt="" /> -->

<!-- 	
				<p>Integer posuere erat a ante venenatis dapibus posuere velit
					aliquet.</p>
 -->
	
				<address>
					<ul class="list-unstyled">
					<!-- 
						<li class="footer-sprite address">PO Box 21132<br> Here
							Weare St, Melbourne<br> Vivas 2355 Australia<br>
						</li> -->
						<li class="footer-sprite phone"><spring:message code="phone"/>:</strong> <a class="phoneDirection" href="tel:${configuration.companyPhone} />">${configuration.companyPhone}</a></span></li>
						<li class="footer-sprite email">
						<!-- <a href="mailto:support@yourname.com">support@yourname.com</a></li>-->
						<spring:message code="emailAddress" />:</strong> <a href="mailto:${configuration.companyMailAddress} />">${configuration.companyMailAddress}</a>
					</ul>
				</address>
	 

			</div>
<!--  
			<div class="col-md-3">

				
				
				<h4 class="letter-spacing-1">LATEST NEWS</h4>
				<ul class="footer-posts list-unstyled">
					<li><a href="#">Donec sed odio dui. Nulla vitae elit
							libero, a pharetra augue</a> <small>29 June 2017</small></li>
					<li><a href="#">Nullam id dolor id nibh ultricies</a> <small>29
							June 2017</small></li>
					<li><a href="#">Duis mollis, est non commodo luctus</a> <small>29
							June 2017</small></li>
				</ul>
				
				

			</div>
 -->
			<div class="col-md-3">

				<!-- Links -->
				<h4 class="letter-spacing-1"><spring:message
									code="explore" /></h4>
				<ul class="footer-links list-unstyled">
					<li><a href="${contextRoot}/home"> <spring:message
									code="home" />
					</a></li>
					<li><a href="${contextRoot}/contact"> <spring:message
									code="contact" />
						</a></li>
						<li><a href="${contextRoot}/about"> <spring:message
									code="about" />
						</a></li>
					<li><a href="#"><spring:message
									code="services" /></a></li>
					<li><a href="#"><spring:message
									code="products" /></a></li>
					
				</ul>
				<!-- /Links -->

			</div>

			<div class="col-md-5">

				<!-- Newsletter Form -->
				<h4 class="letter-spacing-1"><spring:message
									code="keep" /></h4>
				<p><spring:message
									code="subscribeToOurNews" /></p>

				<form class="validate" action="php/newsletter.php" method="post"
					data-success="Subscribed! Thank you!"
					data-toastr-position="bottom-right">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"></i></span>
						<input type="email" id="email" name="email"
							class="form-control required" placeholder="<spring:message
									code="enterEmail" />">
						<span class="input-group-btn">
							<button class="btn btn-success" type="submit"><spring:message
									code="subscribe" /></button>
						</span>
					</div>
				</form>
				<!-- /Newsletter Form -->

				<!-- Social Icons -->
				<div class="mt-20">
					<a href="${configuration.facebook}"
						class="social-icon social-icon-border social-facebook float-left"
						data-toggle="tooltip" data-placement="top" title="Facebook"> <i
						class="icon-facebook"></i> <i class="icon-facebook"></i>
					</a> <a href="${configuration.twitter}"
						class="social-icon social-icon-border social-twitter float-left"
						data-toggle="tooltip" data-placement="top" title="Twitter"> <i
						class="icon-twitter"></i> <i class="icon-twitter"></i>
					</a><a href="${configuration.linkedin}"
						class="social-icon social-icon-border social-linkedin float-left"
						data-toggle="tooltip" data-placement="top" title="Linkedin"> <i
						class="icon-linkedin"></i> <i class="icon-linkedin"></i>
					</a> <a href="${configuration.youtube}"
						class="social-icon social-icon-border social-youtube float-left"
						data-toggle="tooltip" data-placement="top" title="Youtube"> <i
						class="icon-youtube"></i> <i class="icon-youtube"></i>
					</a>

				</div>
				<!-- /Social Icons -->

			</div>

		</div>

	</div>

	<div class="copyright">
		<div class="container">
			<ul class="float-right m-0 list-inline mobile-block">
			
			<!-- 
				<li><a href="#">Terms &amp; Conditions</a></li>
				<li>&bull;</li>
				<li><a href="#">Privacy</a></li>
			</ul> -->
			&copy; All Rights Reserved, Keys Of Quality
		</div>
	</div>
</footer>
<!-- /FOOTER -->