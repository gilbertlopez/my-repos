<%@ include file="/WEB-INF/views/templates/header.jsp"%>

<div class="container">
	<div class="page-header">
		<h1>Login Page</h1>
		<p class="lead">Please login below</p>
	</div>

	<div class="login-container">
		<div class="login-card">
			<div class="login-form">
				<c:url var="loginUrl" value="/login" />
				<form name="loginForm" action="${loginUrl}" method="post"
					class="form-horizontal">
					<c:if test="${param.error != null}">
						<div class="alert alert-danger">
							<p>Invalid Username and password.</p>
						</div>
					</c:if>
					<c:if test="${param.logout != null}">
						<div class="alert alert-success">
							<p>You have been logged out successfully.</p>
						</div>
					</c:if>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="username"><i
							class="fa fa-user"></i></label> <input type="text" class="form-control"
							id="username" name="username" placeholder="Enter Username"
							required>
					</div>
					<div class="input-group input-sm">
						<label class="input-group-addon" for="password"><i
							class="fa fa-lock"></i></label> <input type="password"
							class="form-control" id="password" name="password"
							placeholder="Enter Password" required>
					</div>
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />

					<div class="form-actions">
						<input type="submit" class="btn btn-block btn-primary btn-default"
							value="Log in">
					</div>
				</form>
			</div>
		</div>
	</div>
	
</div>

<%@ include file="/WEB-INF/views/templates/footer.jsp"%>
