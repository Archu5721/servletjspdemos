<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Time</title>
</head>
<body>
	<c:set var="myTime" value= "<%= new java.util.Date() %>" />
	
	Time on Server= ${myTime}
</body>
</html>