<%@ page import = "jspbasics.Sum"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>For Loop</title>
</head>
<body>
	<jsp:include page="Header.jsp"></jsp:include>
	<h1>For Loop</h1>
	<%
		for(int i=1;i<=5;i++){
			out.println("<br/>Hello!!");
		}
	
	
	%>
	<br/>
	Sum : <%= Sum.add(10, 30) %>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>