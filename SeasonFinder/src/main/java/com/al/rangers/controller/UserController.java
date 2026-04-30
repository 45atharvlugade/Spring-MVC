package com.al.rangers.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.al.rangers.model.User;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

	@GetMapping("/")
	private String home() {
		return "home";
	}
	
	@GetMapping("/register")
	private String getRegister(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}
	
	@PostMapping("/register")
	private String getRegister(@ModelAttribute User user,HttpSession session) {
		System.out.println(((User) user).getUserId());
		System.out.println(user.getUserName());
		System.out.println(user.getUserAddress());
		System.out.println(user.getUserEmail());
		System.out.println(user.getMobileNumber());
		
		session.setAttribute("id", user.getUserId());
		session.setAttribute("name", user.getUserName());
		session.setAttribute("email", user.getUserEmail());
		session.setAttribute("number", user.getMobileNumber());
		session.setAttribute("address", user.getUserAddress());
		return "forward:success";
	}
	
	@GetMapping("/success")
	private String getUserSuccess(HttpSession session,Model model) {
		
		String userEmail=(String)session.getAttribute("email");
		String userId=(String)session.getAttribute("id");
		String userName=(String)session.getAttribute("name");
		
		model.addAttribute("Id", userId);
		model.addAttribute("email", userEmail);
		model.addAttribute("name", userName);
		
		return "success";
	}
}
