<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Custom Login Page</title>
</head>
<body>

	<div class="container">
		<div class="row row-cols-1">

			<h3>My Custom Login Page</h3>


			<form:form
				action="${pageContext.request.contextPath}/authenticateTheUser"
				method="POST">

				<!-- check for login error -->
				<c:if test="${param.error != null}">
					<i style="color: red"> Sorry! You entered invalid username or
						password. </i>
				</c:if>

				<p>
					<input type="text" name="username" placeholder="User Name" />
				</p>
				<p>
					<input type="password" name="password" placeholder="Password" />
				</p>

				<input type="submit" value="Login" />
				<!-- name attributes are important. -->
			</form:form>
		</div>
	</div>
</body>
</html>