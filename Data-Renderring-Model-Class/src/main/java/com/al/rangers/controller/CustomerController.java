package com.al.rangers.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.al.rangers.model.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@GetMapping("/invoice")
	public String getInvoice(Map<String,Object> map) {
		
		Customer cust= new Customer(1001,"Atharv","Pune",89000.00);
		map.put("custData",cust);
		
		return "invoice";
	}
	
	// gttp get the list of the model class objects.
	
	@GetMapping("/listcustomer")
	public String getCustomerNameList(Map<String,Object> map) {
		/*
		 * Customer cust1= new Customer(1001,"F","Pune",89000.00); Customer cust2= new
		 * Customer(1002,"E","Pune",89000.00); Customer cust3= new
		 * Customer(1003,"D","Pune",89000.00); Customer cust4= new
		 * Customer(1004,"C","Pune",89000.00); Customer cust5= new
		 * Customer(1005,"B","Pune",89000.00);
		 */

		List<Customer> list = List.of(/* cust1,cust2,cust3,cust4,cust5 */);
		map.put("listCustomer", list);
		
		return "listcustomer";
	
	
	
	}
}
