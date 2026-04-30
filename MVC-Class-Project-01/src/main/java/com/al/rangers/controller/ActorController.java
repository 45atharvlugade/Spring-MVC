package com.al.rangers.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
