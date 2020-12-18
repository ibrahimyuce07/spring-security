<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Homepage</title>
</head>
<body>
	<h2>This is our home page - Yo</h2>
	<hr>
	<p>Welcome to spring security base app home page.</p>
	<hr>


	<!-- display username and role -->
	<p>
		User:
		<security:authentication property="principal.username" />
		<br> <br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>
	<hr>


	<security:authorize access="hasRole('MANAGER')">
		<!-- add a link to point to /leaders ... this is for the MANAGER role -->

		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Meeting (For Managers Only)</a>
		</p>
	</security:authorize>



	<security:authorize access="hasRole('ADMIN')">
		<!-- add a link to point to /systems ... this is for the ADMIN role -->

		<p>
			<a href="${pageContext.request.contextPath}/systems">IT System
				Meeting (ADMIN ONLY)</a>
		</p>
	</security:authorize>
	
	<hr>
	
	
	<!-- add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>