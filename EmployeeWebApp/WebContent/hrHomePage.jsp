<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HR-Home</title>
<link rel="stylesheet" type="text/css" href="./css/styles2.css">
</head>
<body>

	<%
		String userName = (String) session.getAttribute("userName");
	%>
	
	<h4> Hi :<%=userName%></h4>
	
	<h1>Welcome to HR home page</h1>
	<hr>
	
	<div class="container">
		<a href="#" >Search employee using ID</a>
		<br>
		<br>
		<form action="GetEmployeeById">
			<input type="text" name="searchByIDText" id="searchByIDText" placeholder="Enter Id">
			<button>Search</button>
		</form>
	</div>
	
	<br>
	<div class="container">
		<a href="GetAllEmployees" >Get all Employees</a>
		<br>
		<br>
	</div>
	<hr class="moreGap" >
</body>
</html>