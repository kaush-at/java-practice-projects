<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee-Home</title>
<link rel="stylesheet" type="text/css" href="./css/styles2.css">
</head>
<body>
	
	<%
		String userName = (String) session.getAttribute("userName");
	%>
	
	<h4> Hi :<%=userName%></h4>
	<a href="GetProfileServlet"><h4>Profile</h4></a>
	
	<h1>Welcome to Employees Home Page</h1>
	<hr>
	
	
</body>
</html>