package com.al.rangers.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestParamOperationController {

	/*
	 * @GetMapping("/process") public String
	 * process(@RequestParam(name="sno",required = false,defaultValue ="102")
	 * Integer no,@RequestParam("sname") String name) { System.out.println("sno " +
	 * no+ "sname "+name); return "show_data"; }
	 */
	
	// binding the data with the @RequestParam -> String,List<String>,Set<String> ---------> (passing multiple values)
	
	@GetMapping("/process")  // http://localhost:8080/SeasonFinder/process?sno=1000&sname=Kingoshan&sadd=Atharv&sadd=300&sadd=pune&sadd=300
	public String process(@RequestParam Integer sno,
			              @RequestParam String sname,
			              @RequestParam(name="sadd") String[] address,
			              @RequestParam(name="sadd") List<String> listAddress,
			              @RequestParam(name="sadd") Set<String> SetAddres
			              
			 ) {
		System.out.println(sno);
		System.out.println(sname);
		System.out.println(Arrays.toString(address));
		System.out.println(listAddress);
		System.out.println(SetAddres);
		
		return "show_data";
	}
	@GetMapping("/process1") //  http://localhost:8080/SeasonFinder/process1?sno=1000&sname=Kingoshan&sname=man&sname=men
	public String process1(@RequestParam Integer sno,
			              @RequestParam String sname  
			 ) {
		System.out.println(sno);
		System.out.println(sname);	
		return "show_data";
	}
	
	// takign input as comma seperated 
}
