package com.al.rangers.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.al.rangers.entity.User;
import com.al.rangers.service.IUserService;

@Controller
public class UserController {

	@Autowired
	private IUserService service;
	
	// show form
	@GetMapping("/form")
	public String showForm(Map<String,Object> map) {
		map.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user) {
		service.registerUser(user);
		return "forwar:home";
	}
	
	@GetMapping("/home")
	public String requestHome(Map<String,Object> map) {
		
		
		
		return "dashboard";
	}
	
	
}
