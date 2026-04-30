package com.al.rangers.controller;

import com.al.rangers.DataBindingApplication;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.al.rangers.model.Student;

@Controller
public class StudentOperationsController {

	  private final DataBindingApplication dataBindingApplication;

	StudentOperationsController(DataBindingApplication dataBindingApplication) {
		this.dataBindingApplication = dataBindingApplication;
	}

	  @GetMapping("/")
	  public String showHomePage() {
		  return "welcome";
	  }
	  
	  @GetMapping("/register")
	  public String showStudentFormPage() { 
		  return "register";
	  }
	  
	  @PostMapping("/register")
	  public String registerStudent(Map<String,Object> map , @ModelAttribute("stud") Student st) {
		  
		  System.out.println("Model Class Data"+st);
		  
		  String result=null;
		  
		  if(st.getPercentage()<35) {
			  result="fail";
		  }else {
			  result="pass";
		  }
		  
		  // keep the result is model attribute
		  
		 map.put("resultMessage", result);
		 return "results";
	  }
	  
	   @GetMapping("/result")
	   public void getResult() {
		   
	   }
}
