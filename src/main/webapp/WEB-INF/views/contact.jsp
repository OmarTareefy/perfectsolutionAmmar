<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<section class="page-header">
	<div class="container">

		<h1>
			<spring:message code="contact" />
		</h1>

		<!-- breadcrumbs -->
		<ol class="breadcrumb">
			<li><a href="${contextRoot}/home"><spring:message
						code="home" /></a></li>
			<li class="active"><spring:message code="contact" /></li>
		</ol>
		<!-- /breadcrumbs -->

	</div>
</section>
<!-- /PAGE HEADER -->

<!-- -->
<section>
	<div class="container">

		<div class="row">

			<!-- FORM -->
			<div class="col-md-8 col-sm-8">

				<h3>

					<spring:message code="askQuestion" />
				</h3>
				<hr />

				<!-- Alert-->
				<c:if test="${not empty message}">
					<!-- Success -->
					<c:if test="${message == 'success'}">
						<div class="alert alert-success alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong><spring:message code="thankYou" /></strong>
							<spring:message code="successfullySent" />
						</div>
					</c:if>
					<c:if test="${message == 'failure'}">
						<div class="alert alert-danger alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong><spring:message code="sorry" /></strong>
							<spring:message code="issue" />
						</div>
					</c:if>

				</c:if>
				<!-- /Alert Success -->


				<sf:form modelAttribute="contactMessage"
					action="${contextRoot}/contact" method="post">
					<fieldset>
						<input type="hidden" name="action" value="contact_send" />

						<div class="row">
							<div class="col-md-4">
								<label for="contact:name"><spring:message
										code="fullName" /> *</label>
								<sf:input type="text" required="true" class="form-control"
									path="fullName" id="contact:name" />
								
							</div>
							<div class="col-md-4">
								<label for="contact:email"><spring:message
										code="emailAddress" /> *</label>
								<sf:input required="true" type="email" oninvalid="${validLocli}" value="" class="form-control" path="emailAddress" id="contact:email" />
							</div>
							<div class="col-md-4">
								<label for="contact:phone"><spring:message code="phone" /></label>
								<sf:input type="text" value="" class="form-control" path="phone"
									id="contact:phone" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label for="contact:subject"><spring:message
										code="subject" /> *</label>
								<sf:input required="true" type="text" value=""
									class="form-control" path="subject" id="contact:subject" />
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<label for="contact:message"><spring:message
										code="message" /> *</label>
								<sf:textarea required="true" maxlength="10000" rows="8"
									class="form-control" path="message" id="contact:message"></sf:textarea>
							</div>
						</div>

					</fieldset>

					<div class="row">
						<div class="col-md-12">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-check"></i>
								<spring:message code="sendMessage" />
							</button>
						</div>
					</div>
				</sf:form>

			</div>
			<!-- /FORM -->


			<!-- INFO -->
			<div class="col-md-4 col-sm-4">

				<h3>
					<spring:message code="contact" />
				</h3>
				<hr />

				<p>
					<span class="block"><strong><i class="fa fa-phone"></i>
							<spring:message code="phone"/>:</strong> <a class="phoneDirection" href="tel:<spring:eval expression="@propertyConfigurer.getProperty('companyPhone')" />"><spring:eval expression="@propertyConfigurer.getProperty('companyPhone')" /></a></span> <span
						class="block"><strong><i class="fa fa-envelope"></i>
							<spring:message code="emailAddress" />:</strong> <a href="mailto:<spring:eval expression="@propertyConfigurer.getProperty('companyMailAddress')" />"><spring:eval expression="@propertyConfigurer.getProperty('companyMailAddress')" /></a></span>
							
				</p>

			</div>
			<!-- /INFO -->

		</div>

	</div>
</section>
<!-- / -->
