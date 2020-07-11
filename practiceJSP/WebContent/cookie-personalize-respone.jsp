<html>

<!-- Reading the form data and setting the cookie -->

<%
String favLanguage = request.getParameter("favLanguage");

// create a cookie
Cookie theCookie = new Cookie("myApp.favLanguage", favLanguage);

//set life span(total number of seconds)
theCookie.setMaxAge(60*60*24*365) ;

//send cookie to the browser
response.addCookie(theCookie);

%>
<body>
	<h2>Thanks and we set to your favorite programming language to the : </h2>${param.favLanguage} 
	
	<br><br>
	<a href="cookie-homepage.jsp">Return to the home page</a>
</body>

</html>