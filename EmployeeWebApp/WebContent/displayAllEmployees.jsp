<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/styles2.css">
</head>
<body>

	<%@ include file="hrHomePage.jsp"%>
	<h3>All Employees</h3>
	<br>
	<table id="employeeTbl"> 
	
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>
		
		<c:forEach var="employee" items="${employeeList}">
			<tr>
				<td>${ employee.id}</td>
				<td>${ employee.name} </td>
				<td>${ employee.department} </td>
				<td>${ employee.salary} </td>
			</tr>
		</c:forEach>
		
		
	</table>

</body>
</html>