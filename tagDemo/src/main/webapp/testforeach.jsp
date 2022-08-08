<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ForEach Tag</title>
</head>
<body>
	<% String Fruits[]={"Apple","Orange","Pomo","WaterMelon"};
	   pageContext.setAttribute("myfruit",Fruits);
	%>
	<c:forEach  var="fruit" items="${myfruit}" >
		${fruit}<br/>
	</c:forEach>
</body>
</html>