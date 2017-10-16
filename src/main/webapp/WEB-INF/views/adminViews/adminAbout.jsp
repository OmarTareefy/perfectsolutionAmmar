

<div class="row">

	<div class="col-md-12">

		<!-- ------ -->
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-transparent">
				<strong>Manage About Us</strong>
			</div>

			<div class="panel-body">


				<!-- Alert-->
				<c:if test="${not empty message}">
					<!-- Success -->
					<c:if test="${message == 'success'}">
						<div class="alert alert-success alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Thank you! About page has been updated successfully.</strong>
							<spring:message code="successfullySent" />
						</div>
					</c:if>
					<c:if test="${message == 'failure'}">
						<div class="alert alert-danger alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>There was an issue updating About page.</strong>
							<spring:message code="issue" />
						</div>
					</c:if>

				</c:if>
				<!-- /Alert Success -->

				<sf:form modelAttribute="about"
					action="${contextRoot}/manage/about/" method="POST"
					data-success="Sent! Thank you!"
					data-toastr-position="top-right">
					<fieldset>
						

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Description En*</label>
									<sf:textarea path="descriptionEn" rows="4"
										class="summernote form-control"></sf:textarea>
									<sf:errors path="descriptionEn" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Description Ar*</label>
									<sf:textarea path="descriptionAr" rows="4"
										class="summernote form-control"></sf:textarea>
									<sf:errors path="descriptionAr" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Mission En*</label>
									<sf:textarea path="missionEn" rows="4"
										class="summernote form-control"></sf:textarea>
									<sf:errors path="missionEn" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Mission Ar*</label>
									<sf:textarea path="missionAr" rows="4"
										class="summernote form-control"></sf:textarea>
									<sf:errors path="missionAr" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Vision En*</label>
									<sf:textarea path="visionEn" rows="4"
										class="summernote form-control" ></sf:textarea>
									<sf:errors path="visionEn" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Vision Ar*</label>
									<sf:textarea path="visionAr" rows="4"
										class="summernote form-control" ></sf:textarea>
									<sf:errors path="visionAr" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
<!-- 
						<div class="row">
							<div class="form-group">
								<div class="col-md-12">
									<label> File Attachment <small class="text-muted">Curriculum
											Vitae - optional</small>
									</label>

									
									<div class="fancy-file-upload fancy-file-primary">
										<i class="fa fa-upload"></i> <input type="file"
											class="form-control" name="contact[attachment]"
											onchange="jQuery(this).next('input').val(this.value);" /> <input
											type="text" class="form-control"
											placeholder="no file selected" readonly="" /> <span
											class="button">Choose File</span>
									</div>
									<small class="text-muted block">Max file size: 10Mb
										(zip/pdf/jpg/png)</small>

								</div>
							</div>
						</div>
 -->
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
