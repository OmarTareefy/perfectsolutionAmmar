

<div class="row">

	<div class="col-md-12">

		<!-- ------ -->
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-transparent">
				<strong>Manage Configurations</strong>
			</div>

			<div class="panel-body">


				<!-- Alert-->
				<c:if test="${not empty message}">
					<!-- Success -->
					<c:if test="${message == 'success'}">
						<div class="alert alert-success alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Thank you! Configurations have been updated successfully.</strong>
						</div>
					</c:if>
					<c:if test="${message == 'failure'}">
						<div class="alert alert-danger alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>There was an issue updating Configuration page.</strong>
						</div>
					</c:if>

				</c:if>
				<!-- /Alert Success -->
				
				<div class="fancy-form">
					<label>Subscribers</label>
					<textarea rows="5" class="form-control word-count" data-info="textarea-words-info">${subscribers}
					</textarea>
				
				</div><br><br>

				<sf:form modelAttribute="configuration"
					action="${contextRoot}/manage/configuration/" method="POST"
					data-success="Sent! Thank you!"
					data-toastr-position="top-right">
					<fieldset>
						

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Gmail Sender Mail Username*</label>
									<sf:input type="text" path="gmailSenderMailUsername"
										class="form-control"/>
									<sf:errors path="gmailSenderMailUsername" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Gmail Sender Mail Password*</label>
									<sf:input type="text" path="gmailSenderMailPassword"
										class="form-control"/>
									<sf:errors path="gmailSenderMailPassword" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Company Mail Address*</label>
									<sf:input type="text" path="companyMailAddress"
										class="form-control"/>
									<sf:errors path="companyMailAddress" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Email Subject*</label>
									<sf:input type="text" path="emailSubject"
										class="form-control"/>
									<sf:errors path="emailSubject" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Company Phone*</label>
									<sf:input type="text" path="companyPhone"
										class="form-control"/>
									<sf:errors path="companyPhone" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Facebook*</label>
									<sf:input type="text" path="facebook"
										class="form-control"/>
									<sf:errors path="facebook" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Twitter*</label>
									<sf:input type="text" path="twitter"
										class="form-control"/>
									<sf:errors path="twitter" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>LinkedIn*</label>
									<sf:input type="text" path="linkedin"
										class="form-control"/>
									<sf:errors path="linkedin" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Youtube*</label>
									<sf:input type="text" path="youtube"
										class="form-control"/>
									<sf:errors path="youtube" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
																		
					</fieldset>

					<div class="row">
						<div class="col-md-12">
							<button type="submit"
								class="btn btn-3d btn-teal btn-xlg btn-block margin-top-30">
								Submit
							</button>
						</div>
					</div>
			
				</sf:form>

			</div>

		</div>
		<!-- /----- -->

	</div>

</div>
