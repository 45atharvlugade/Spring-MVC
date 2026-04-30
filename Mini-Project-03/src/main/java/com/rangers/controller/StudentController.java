package com.rangers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rangers.entity.Student;
import com.rangers.service.IStudentManagementService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private IStudentManagementService studentService;
	
	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	public String registerStudent(@ModelAttribute Student student) {
	  String msg =	studentService.registerStudent(student); 
	  System.out.println(msg);
	  return "success";
	  
	  
	}
}
