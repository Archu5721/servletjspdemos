<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>declaration</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1>LowerCase</h1>
	<%!
	
		String toLowercase(String data){
			return data.toLowerCase();
	}
	%>
	
	<p>LowerCase : <%= toLowercase("ARCHATHA") %>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>