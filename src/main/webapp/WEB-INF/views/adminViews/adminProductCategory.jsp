

<div class="row">

	<div class="col-md-12">

		<!-- ------ -->
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-transparent">
				<strong>Manage Product Category</strong>
			</div>

			<div class="panel-body">


				<!-- Alert-->
				<c:if test="${not empty message}">
					<!-- Success -->
					<c:if test="${message == 'success'}">
						<div class="alert alert-success alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>Thank you! A product category has been added/updated successfully.</strong>
						</div>
					</c:if>
					<c:if test="${message == 'failure'}">
						<div class="alert alert-danger alert-dismissible mb-30">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							<strong>There was an issue updating A product category.</strong>
						</div>
					</c:if>

				</c:if>
				<!-- /Alert Success -->

				<sf:form modelAttribute="productCategory"
					action="${contextRoot}/manage/productCategory/" method="POST"
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
									<label class="radio">
										<sf:radiobutton path="active" value="1"/><i></i>Active
									</label>
									<label class="radio">
										<sf:radiobutton path="active" value="0"/><i></i>Not Active
									</label>
								</div>
							</div>
						</div>
		
					<sf:hidden path="id" />
					<sf:hidden path="categoryType" />
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
