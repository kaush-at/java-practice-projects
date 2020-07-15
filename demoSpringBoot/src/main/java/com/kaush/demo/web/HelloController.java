package com.kaush.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/* 
 * url pattern => localhost:8080
 * 
@RestController
public class HelloController {

	@RequestMapping(value="/", method=RequestMethod.GET) 
		public String sayHello() {	
			return "<h1>hello</h1>";
		}											

}
*/
/*
 * url pattern => localhost:8080/greetings/basic
 */
@RestController
@RequestMapping("/greetings")
public class HelloController {

	@RequestMapping(value="basic", method=RequestMethod.GET) // without slash is ok
		public String sayHello() {	
			return "<h1>hello</h1>";
		}											

	@RequestMapping(value="/proper", method=RequestMethod.GET) 
	public String sayProperHello() {	
		return "<h1>hello There, How are you..!!</h1>";
	}
	
	// if this is a get request we no need to create @Request Param with their values
	@RequestMapping("/get") 
	public String sayGet() {	
		return "<h1>hello There, default get request</h1>";
	}
	
	@RequestMapping("/form")
	public String returnForm() {	
	return "<form action=\"/greetings/user_greetings\" method=\"POST\">\n" + 
	"  <label for=\"fname\">First name:</label><br>\n" + 
	"  <input type=\"text\" id=\"fname\" name=\"fname\" value=\"John\"><br>\n" + 
	"  <label for=\"lname\">Last name:</label><br>\n" + 
	"  <input type=\"text\" id=\"lname\" name=\"lname\" value=\"Doe\"><br><br>\n" + 
	"  <input type=\"submit\" value=\"Submit\">\n" + 
	"</form>";
	}
	
	@RequestMapping(value="/user_greetings", method=RequestMethod.POST)
	//public String responseForm(@RequestParam("fname")String firstName,@RequestParam("lname")String lastName) {
	/*
	 * instead of giving @RequestParam("fname") we can keep same name as name property of form map with our method
	 */
	public String responseForm(@RequestParam String fname,@RequestParam String lname) {	
		return "Hello There "+fname+" "+lname;	
	
	}
	
	@RequestMapping(value="/orders/{id}", method=RequestMethod.GET) // {id} - is for dynamically catch any given id
	// id is not a request parameter it is a path variable(it is path of the actual url path)
	// to access it we use @PathVariable annotation syntax is same as @RequestParam
	public String getOrders(@PathVariable String id) {
		return "Order Id : "+ id;
		
	}
}