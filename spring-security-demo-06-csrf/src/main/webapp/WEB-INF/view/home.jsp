<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Homepage</title>
</head>
<body>
<h2>This is our home page - Yo</h2>
<hr>

<p> 
Welcome to spring security base app home page.
</p>

<!-- add a logout button -->
<form:form action="${pageContext.request.contextPath}/logout" method="POST">

<input type="submit" value="Logout">

</form:form>
</body>
</html>