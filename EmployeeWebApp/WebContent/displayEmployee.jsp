<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.kaush.dto.Employee"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./css/styles2.css">
</head>
<body>
	<%
		Employee emp = (Employee) request.getAttribute("employee");
	%>
	<%@ include file="hrHomePage.jsp" %>
	<h3>All Employees</h3>
	<br>
	<table id="employeeTbl"> 
	
		<tr>
			<th>Employee Id</th>
			<th>Employee Name</th>
			<th>Department</th>
			<th>Salary</th>
		</tr>
		
		<tr>
			<td><%=emp.getId() %></td>
			<td><%=emp.getName() %></td>
			<td><%=emp.getDepartment()%></td>
			<td><%=emp.getSalary() %></td>
		</tr>
		
	</table>
	
</body>
</html>