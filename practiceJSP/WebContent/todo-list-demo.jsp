<%@ page import="java.util.*" %>
<html>
<body>
<!-- step 1 - create HTML form -->

<!-- this will submit data right back to same page -->
<form action="todo-list-demo.jsp">
	Add items to the List : <input type="text" name="todo-text"/>
		<input type="submit" value="Add Item"/>
</form>


<!-- step 2 - add new Item to TODO list -->
 <br>
 <br>
<%

String item = request.getParameter("todo-text");

//get the todo items from the session

List<String> items = (List<String>) session.getAttribute("myToDoList");

// if the todo items dosent exist then create a new one
if(items == null){
	items = new ArrayList<String>();
	session.setAttribute("myToDoList", items);
}

//see if there is form data to add
String todoText = request.getParameter("todo-text");
if(todoText != null){
	items.add(todoText);
}
%>

<!-- Display all "to-do " items from session -->
<h3>To do items :</h3><br>
<ol>
<%
	for(String ListItem : items){
		out.println("<li>"+ListItem+"</li><br>");
	}
%>
</ol>

<!-- step 3 - display all todo item from session -->

</body>
</html>
