package com.al.rangers.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.al.rangers.model.Bird;

@Controller
public class ZooController {
	
	@Autowired
	

	@GetMapping("/")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("/registerBird")
	public String register1(Map<String,Object> map) {
		map.put("bird", new Bird());
		return "register";
	}
	
	@PostMapping("/registerBird")
	public String registerBird(@ModelAttribute Bird bird,Model model) {
		model.addAttribute("bird", bird);
		return "redirect:loginBird";
	}
	
	@GetMapping("/registerAnimal")
	public String register2(Map<String,Object> map) {
		map.put("bird", new Bird());
		return "register";
	}
	
	@PostMapping("/registerAnimal")
	public String registerAnimal(@ModelAttribute Bird bird,Model model) {
		model.addAttribute("bird", bird);
		return "redirect:loginAnimal";
	}
	
}
