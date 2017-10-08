

<div class="row">

	<div class="col-md-12">

		<!-- ------ -->
		<div class="panel panel-default">
			<div class="panel-heading panel-heading-transparent">
				<strong>Manage About Us</strong>
			</div>

			<div class="panel-body">

				<sf:form class="validate" modelAttribute="about"
					action="${contextRoot}/contact" method="post"
					enctype="multipart/form-data" data-success="Sent! Thank you!"
					data-toastr-position="top-right">
					<fieldset>
						<!-- required [php action request] -->
						<input type="hidden" name="action" value="contact_send" />

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Description En</label>
									<textarea name="contact[experience]" rows="4"
										class="summernote form-control required" path="descriptionEn"></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Description Ar</label>
									<textarea name="contact[experience2]" rows="4"
										class="summernote form-control required" path="descriptionAr"></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Mission En</label>
									<textarea name="contact[experience2]" rows="4"
										class="summernote form-control required" path="missionEn"></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Mission Ar</label>
									<textarea name="contact[experience2]" rows="4"
										class="summernote form-control required" path="missionAr"></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Vision En</label>
									<textarea name="contact[experience2]" rows="4"
										class="summernote form-control required" path="visionEn"></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12 col-sm-12">
									<label>Vision Ar</label>
									<textarea name="contact[experience2]" rows="4"
										class="summernote form-control required" path="visionAr"></textarea>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="form-group">
								<div class="col-md-12">
									<label> File Attachment <small class="text-muted">Curriculum
											Vitae - optional</small>
									</label>

									<!-- custom file upload -->
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

					</fieldset>

					<div class="row">
						<div class="col-md-12">
							<button type="submit"
								class="btn btn-3d btn-teal btn-xlg btn-block margin-top-30">
								SEND APPLICATION <span class="block font-lato">We'll get
									back to you within 48 hours</span>
							</button>
						</div>
					</div>

				</sf:form>

			</div>

		</div>
		<!-- /----- -->

	</div>

</div>
