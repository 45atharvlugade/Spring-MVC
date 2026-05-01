package com.al.rangers.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.al.rangers.dto.ActorEditDto;
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
	
//	@GetMapping("/report")
//	public String showReport(Map<String,Object> map) {
//		List<Actor> actorList=actorService.getAllActors();
//		map.put("listActors", actorList);
//		
//		return "show_report";
//	}
	
	@GetMapping("/register")
	public String getRegisterPage(Model model) {
		model.addAttribute("actor", new Actor());
		System.out.println(actorService.getAllActors());
		model.addAttribute("actorList", actorService.getAllActors());
		return "show_data";
	}
	
	@GetMapping("/getData")
	public String getShowDataPage(Model model) {
		 model.addAttribute("actor", new Actor());
		    model.addAttribute("actorList", actorService.getAllActors());
		return "show_data";
	}
	
	@PostMapping("/register")
	public String registerActor(@ModelAttribute Actor actor, RedirectAttributes ra) {

		System.out.println(actorService.getAllActors());
	    if (actor.getActorName() == null || actor.getActorName().trim().isEmpty()) {
	        ra.addFlashAttribute("error", "Name is required!");
	        return "redirect:/actor/register";
	    }

	    String msg = actorService.registerActor(actor);
	    ra.addFlashAttribute("success", msg);

	    return "redirect:/actor/register";
	}
	
	@PostMapping("/delete")
	public String deleteActor(@RequestParam int id,RedirectAttributes ra) {
		String msg=actorService.deleteActorById(id);
		ra.addFlashAttribute("resultMsg", msg);
		return "redirect:/actor/register";	
	}
	
	// pageable object usage in the methods 
	
	@GetMapping("/report")
	public String showData(@PageableDefault(page=0,size=3,sort="category",direction = Sort.Direction.ASC)Pageable pageable,
			Model  model) {
		Page<Actor> page =actorService.showAllData(pageable);
		model.addAttribute("listActors", page);
		
		return "show_report";
	} 
	
	
	@GetMapping("/edit")
	public String getEditPage(Model model,@RequestParam int id) {
	     Actor actor1=actorService.findById(id);
	     model.addAttribute("actor2", actor1);
	     return "edit_actor";
	}
	
	@PostMapping("/edit")
	public String editActor(@ModelAttribute ActorEditDto actor2,
			RedirectAttributes ra
			) {
		try {
			Actor actor1=actorService.findById(actor2.getActorId());
			
			if(actor2.getActorName() != null)
			    actor1.setActorName(actor2.getActorName());

			if(actor2.getAddress() != null)
			    actor1.setAddress(actor2.getAddress());

			if(actor2.getFees() != null)
			    actor1.setFees(actor2.getFees());

			if(actor2.getCategory() != null)
			    actor1.setCategory(actor2.getCategory());
			actorService.editActor(actor1);
			ra.addFlashAttribute("success", "Actor Edited Succes");
		}catch(Exception e) {
			ra.addFlashAttribute("error", "Error in Actor Editing may be Actor does not exist");
		}
		
		
		return "redirect:/actor/register";
	}
}
