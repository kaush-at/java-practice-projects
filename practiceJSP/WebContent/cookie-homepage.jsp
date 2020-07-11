<html>
<body>

	<%
		// the default... there are no cookies
	String favLanguage = "Java";

	// get the cookies from the browser request
	Cookie[] theCookies = request.getCookies();

	if (theCookies != null) {
		for (Cookie tempCookie : theCookies) {
			if ("myApp.favLanguage".equals(tempCookie.getName())) {
		favLanguage = tempCookie.getValue();
		break;
			}
		}
	}
	%>
	<!-- now we can personalize the page according to favLanguage -->
	<h1>Training portal</h1>
	<h2>Jobs alert find for <%= favLanguage%></h2>
	<ul>
		<li>blah bla bla</li>
		<li>blah bla bla</li>
	</ul>
	<br>
	<br>
	<h2>New books for <%= favLanguage%></h2>
		<ul>
		<li>blah bla bla</li>
		<li>blah bla bla</li>
	</ul>
	<br>
	<br>
	<h2>Latest news reports for<%= favLanguage%> </h2>
	<ul>
		<li>blah bla bla</li>
		<li>blah bla bla</li>
	</ul>
	<br>
	<br>
	<hr>
	<a href="cookie-personalize-form.html">Personalize this page</a>
</body>

</html>