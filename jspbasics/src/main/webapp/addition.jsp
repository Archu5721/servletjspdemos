<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Addition</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<% 
		int  num1= Integer.parseInt(request.getParameter("number1"));
		int  num2= Integer.parseInt(request.getParameter("number2"));
	%>
	
	<p>Sum of <%= num1 %> and <%= num2 %> is <%= num1+num2 %> </p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>