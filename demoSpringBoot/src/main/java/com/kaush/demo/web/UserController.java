package com.kaush.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kaush.demo.domain.Product;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/{id}")
	public String displayUser(@PathVariable("id") int userId) {
		return "User found on user id :"+userId;
	}

	// or
	// to automatically map with our method variable 
	/*	
	@RequestMapping("/{id}")
	public String displayUser2(@PathVariable int id) { // this java variable should same as this {name}
		return "User fount on user id :"+id;
		
	}
	*/
	
	/*
	@RequestMapping("/{id}/invoice")
	//public String displayUserInvoices(@PathVariable int id, @RequestParam Date date) {
	public String displayUserInvoices(@PathVariable int id, 
		int Uid, (keep in mind {id} should equal to 
			 * @PathVariable({id} )
			@RequestParam(value="date", required=false) Date dateOrNull) {
		
		return id+ " User purchase product on  : "+ dateOrNull;
		
	}
	*/
	
	@RequestMapping("/{userId}/invoice")
	public String displayUserInvoice(@PathVariable("userId") int id,@RequestParam(value="date", required=false) Date date) {
		return "User found with user Id : " + id + "with invoice date "+date;
	}
	
	/*
		if we need to make @PathVariable optional
		@RequestMapping(path = {"/edit", "/edit/{id}"})  // to hanndle multiple request
		public String editEmployeeById(@PathVariable("id") Optional<Long> id) 
	*/
	
	
	@RequestMapping("/{userId}/items")
	public List<String> displayItemJson(){
		return Arrays.asList("shoes","laptop","buttons");
	} 
	
	@RequestMapping("/{userId}/products")
	public List<Product> productAsJson(){
		return Arrays.asList(new Product(1,"laptop",23.20),new Product(2,"food",13.00),new Product(3,"bag",18.25));
		// if i need to return one single product 
		// return new Product(1,"lap-top",23.20);
	}
	
}
