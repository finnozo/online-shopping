<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>Sign Up - Personal</h4>
				</div>
				<div class="panel-body">
					<sf:form method="POST" class="form-horizontal" id="registerForm"
						modelAttribute="user">
						<div class="form-group">
							<label class="control-label col-md-4" for="firstName">First
								Name</label>
							<div class="col-md-8">
								<sf:input path="firstName" type="text" class="form-control"
									placeholder="First Name" />
								<sf:errors path="firstName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="lastName">Last
								Name</label>
							<div class="col-md-8">
								<sf:input path="lastName" type="text" class="form-control"
									placeholder="Last Name" />
								<sf:errors path="lastName" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="email">Email</label>
							<div class="col-md-8">
								<sf:input path="email" type="email" class="form-control"
									placeholder="abc@xyz.com" />
								<sf:errors path="email" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="contactNumber">Contact
								Number</label>
							<div class="col-md-8">
								<sf:input path="contactNumber" type="number" maxlength="10"
									class="form-control" placeholder="XXXXXXXXXX" />
								<sf:errors path="contactNumber" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="password">Password</label>
							<div class="col-md-8">
								<sf:input path="password" type="password" class="form-control"
									placeholder="Password" />
								<sf:errors path="password" cssClass="help-block" element="em" />
							</div>
						</div>

						<div class="form-group">
							<label class="control-label col-md-4" for="confirmPassword">Confirm
								Password</label>
							<div class="col-md-8">
								<sf:input path="confirmPassword" type="password"
									class="form-control" placeholder="Re-Enter Password" />
								<sf:errors path="confirmPassword" cssClass="help-block"
									element="em" />
							</div>
						</div>

						<!-- radio button using bootstrap class of radio-inline -->

						<div class="form-group">
							<label class="control-label col-md-4" for="role">Select
								Role</label>
							<div class="col-md-8">
								<label class="radio-inline"> <sf:radiobutton path="role"
										value="USER" checked="checked" /> User
								</label> <label class="radio-inline"> <sf:radiobutton
										path="role" value="SUPPLIER" /> Supplier
								</label>
							</div>
						</div>

						<div class="form-group">
							<div class="col-md-offset-4 col-md-8">
								<!-- submit button inside the form -->
								<button type="submit" class="btn btn-primary"
									name="_eventId_billing">
									Next - Billing <span class="glyphicon glyphicon-chevron-right"></span>
								</button>

							</div>

						</div>

					</sf:form>

				</div>
			</div>

		</div>
	</div>
</div>

<%@ include file="../shared/flows-footer.jsp"%>