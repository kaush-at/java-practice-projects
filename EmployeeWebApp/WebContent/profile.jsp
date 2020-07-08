<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/styles2.css">
</head>
<body>
	
		<%@ include file="employeeHomePage.jsp" %>
		<div id="main-container">
		
			<img src="https://i.pinimg.com/736x/a7/66/92/a766923c29305a16ce461b2ae54f4c68.jpg"
			alt="profile-image" width="300" height="300" align="left">
			<div align="center">
				<h1>${employee.name}'s User Profile</h1>
				<h3 class="left-h3">Name :${employee.name}</h3>
				<h3 class="left-h3">Department :${employee.department}</h3>
				<h3 class="left-h3">Employee Id :${employee.id}</h3>
				<h3 class="left-h3">Gross Income :${employee.salary}</h3>
			</div>
		</div>
	
</body>
</html>