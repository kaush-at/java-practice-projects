<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>----JSP expressions----</h3><br>
	Converting a string to upper case <%= new String("Hello world").toUpperCase()%>
	
	<br/><br/>
	
	25 multiplied by 4 equals <%= 25 * 4 %>
	
	<br><br>
	
	Is 75 less than 69? <%= 75<69 %>
	
	<h3>----JSP scriptlets----</h3><br>
	
	<%
		for(int i =0; i < 5; i++){
			out.println("<br>I value is : " + i);
		}
	%>
	
	<h3>----JSP scriptlets----</h3><br>
	<%!
		// declaring a method
		String makeItLower(String data){
		return data.toLowerCase();
	}
	%>
	Lower case "Hello World gives output as : " <%=makeItLower("Hello WORLD") %>
	
</body>
</html>