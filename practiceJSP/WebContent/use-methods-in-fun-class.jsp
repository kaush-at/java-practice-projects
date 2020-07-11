<%@ page import="com.web.servlets.MyFun"  %>
<html>
<body>
 <center><h1>Use java class instead of declaration tags</h1></center>
 <center><h5>we can use java class to avoid use more java code inside JSP like expresssion tags to creating methods</h5></center>
 <br>
 <br>
 <h6>Direct use with whole path</h6>
 Lets check MyFun methods <%= com.web.servlets.MyFun.makeItLower("MAKE IT LOWER") %>
 <br>
  <h6>import the class</h6>
 Lets check MyFun methods <%= MyFun.makeItLower("MAKE IT LOWER") %>
</body>

</html>