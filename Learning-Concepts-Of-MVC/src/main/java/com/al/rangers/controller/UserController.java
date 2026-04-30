package com.al.rangers.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.al.rangers.model.User;


import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@GetMapping("/")
	public String getHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String register(Map<String,Object> map) {
		map.put("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute User user,HttpSession session) {
		if(user!=null) {
	    session.setAttribute("user1", user);
		System.out.println(user.toString());
		return "redirect:/result";
		}else {
			return "redirect:register";
		}
	}
	
	@GetMapping("/result")
	public String getResults(Model model, HttpSession session) {

	    User user = (User) session.getAttribute("user1");

	    if (user == null) {
	        return "redirect:/register"; // 🔥 important fix
	    }

	    model.addAttribute("pn", user.getPhoneNumber());

	    return "result";
	}
}
