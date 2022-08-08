<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List</title>
</head>
<body>
	<c:forEach var="student" items="${mylist}">
		${student} <br/>
	</c:forEach>
</body>
</html>