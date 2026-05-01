package com.al.rangers.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.al.rangers.entity.Actor;
import com.al.rangers.service.IActorService;

@Controller
@RequestMapping("/actor")
public class ActorController {

	@Autowired
	private IActorService actorService;
	
	@GetMapping("/")
	private String launcHomePage() {
		return "home";
	}
	
	@GetMapping("/report")
	public String showReport(Map<String,Object> map) {
		List<Actor> actorList=actorService.getAllActors();
		map.put("listActors", actorList);
		
		return "show_report";
	}
	
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("actor", new Actor());
		model.addAttribute("actorList", actorService.getAllActors());
		return "show_data";
	}
	
	@PostMapping("/register")
	public String registerActor(@ModelAttribute Actor actor,RedirectAttributes ra) {
		
		System.out.println(actor.getActorId());
		System.out.println(actor.getActorName());
		
		String msg;
		
		try {
			
		msg = actorService.registerActor(actor);
		ra.addAttribute("actorList", actorService.getAllActors());
		ra.addAttribute("success", msg);	
		}catch(Exception e) {
			msg="Actor is Not registered";
			ra.addAttribute("error", msg);
		}
		return "redirect:/actor/register";	
	}
	
	@PostMapping("/delete")
	public String deleteActor(@RequestParam int id,RedirectAttributes ra) {
		String msg=actorService.deleteActorById(id);
		ra.addFlashAttribute("resultMsg", msg);
		return "forward:/actor/register";	
	}
	
}
