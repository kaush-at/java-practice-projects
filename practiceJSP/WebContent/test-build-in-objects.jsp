<html>
<body>
<h2>JSP built in Objects</h2>
<br>
<br>
<h4>finding what browser that the client is using with help of build in request object</h4>
<!-- User-Agent -> the browser client is using -->
Request user agent : <%= request.getHeader("User-Agent") %>
<br>
<br>
<h4>finding what language that the client browser is using with help of build in request object</h4>
Request user language : <%= request.getLocale() %>
</body>

</html>