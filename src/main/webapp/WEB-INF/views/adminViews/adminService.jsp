

<div class="row">

	<div class="col-md-12">

		<!-- ------ -->
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-transparent">
				<strong>Manage Services</strong>
			</div>

			<div class="panel-body">


				<!-- Alert-->
				<c:if test="${not empty message}">
					<!-- Success -->
					<c:if test="${message == 'success'}">
						<div class="alert alert-success alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Thank you! A service has been added/updated successfully.</strong>
						</div>
					</c:if>
					<c:if test="${message == 'failure'}">
						<div class="alert alert-danger alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>There was an issue adding a service.</strong>
						</div>
					</c:if>

				</c:if>
				<!-- /Alert Success -->

				<sf:form modelAttribute="service"
					action="${contextRoot}/manage/service/" method="POST"
					enctype="multipart/form-data"
					data-success="Sent! Thank you!"
					data-toastr-position="top-right">
					<fieldset>
						

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Name En*</label>
									<sf:input type="text" path="nameEn"
										class="form-control"/>
									<sf:errors path="nameEn" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Name Ar*</label>
									<sf:input type="text" path="nameAr"
										class="form-control"/>
									<sf:errors path="nameAr" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Description En*</label>
									<sf:textarea path="DescriptionEn" rows="4"
										class="summernote form-control"></sf:textarea>
									<sf:errors path="DescriptionEn" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Description Ar*</label>
									<sf:textarea path="DescriptionAr" rows="4"
										class="summernote form-control"></sf:textarea>
									<sf:errors path="DescriptionAr" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Select an Image*</label>
										<sf:input type="file" path="file" id="file" class="form-control" />
										<sf:errors path="file" cssClass="help-block" element="em" />
								</div>
							</div>
						</div>
						
						<label class="switch switch-success switch-round">
							<input type="checkbox" checked="" name="switchProduct" id="switchProduct" path="active">
							<span class="switch-label" data-on="YES" data-off="NO"></span>
						</label>

					</fieldset>

					<div class="row">
						<div class="col-md-12">
							<button type="submit"
								class="btn btn-3d btn-teal btn-xlg btn-block margin-top-30">
								Submit
							</button>
						</div>
					</div>
					<!-- Hidden fields for Service -->
					<sf:hidden path="active" />
					<sf:hidden path="id" />
					<sf:hidden path="code" />
					<sf:hidden path="categoryId" />
					
				</sf:form>

			</div>

		</div>
		<!-- /----- -->

	</div>

</div>
