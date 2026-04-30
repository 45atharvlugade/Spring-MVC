package com.rangers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rangers.entity.Collage;
import com.rangers.service.ICollageManagementServie;

@Controller
@RequestMapping("/collage")
public class CollageController {

	@Autowired
	private ICollageManagementServie collageService;
	
	@GetMapping("/")
	public String getCollageHome() {
		return "collagehome";
	}
	
	@GetMapping("/registerCollage")
	public String registerCollage(Model model) {	
		model.addAttribute("collage", new Collage());
		return "registerCollage";
	}
	
	@PostMapping("/registerCollage")
	public String registerCollage(@ModelAttribute Collage collage,RedirectAttributes ra) {
		try {
			collageService.registerCollage(collage);
			ra.addFlashAttribute("success", "Registration SuccessFull");
			
		}catch(Exception e) {
			ra.addFlashAttribute("error", "Failed Registration");
		}
		return "redirect:/collage/registerCollage";
	}
}
