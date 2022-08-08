<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List , tagDemo.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
</head>
<body>
		<%
		List<Student> data=new ArrayList<>();
		data.add(new Student("Jhon","Marshall"));
		data.add(new Student("Mary","maxwell"));
		pageContext.setAttribute("mylist", data);
		%>
		
		<c:forEach var="list" items="${mylist}">
			${list.firstName} ${list.lastName}<br/>
		</c:forEach>
		
		
</body>
</html>