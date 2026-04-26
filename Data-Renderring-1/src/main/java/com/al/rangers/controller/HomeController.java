package com.al.rangers.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	LocalDateTime dateTime =LocalDateTime.now();
	
	/*
	 * @GetMapping("/home") public String getTime(Map<String, Object> map) {
	 * 
	 * LocalDateTime dateTime = LocalDateTime.now(); // ✅ fresh every request
	 * 
	 * map.put("val1", dateTime.getDayOfWeek().toString()); map.put("val2",
	 * dateTime.getMinute()); // no need for String conversion
	 * 
	 * return "home"; }
	 */
	
	/*
	 * // taking Model as the return type
	 * 
	 * @GetMapping("/hello") public Model getTime() {
	 * 
	 * Model model= new BindingAwareModelMap();
	 * model.addAttribute("val1","Hello World");
	 * model.addAttribute("val2",LocalDateTime.now().toString());
	 * 
	 * return model; }
	 */
	
	// taking map as the return type
	
	
	
	
	@GetMapping("hello")
	public Map<Object,String> getTime(){
		
		Map<Object,String> map=new HashMap<Object, String>();
		map.put("val1", "My Name is Atharv Lugade");
		 map.put("val2", "I Know Whom to keep where ");
		return map;
	}
	
	
	// forwarding the request from the One handler method to another handler method.
	
	@GetMapping("/king")
	public String getKingName(Map<String,Object> map) {
		map.put("king1", "Atharv Lugade");
		return "forward:/queen";
	}
	
	
	@GetMapping("/queen")
	public String getQueens(Map<String,Object> map) {
		System.out.println(map.get("king1"));
		map.put("queen1", "Alone");
		
		return "home";
	}
	// taking the ModelAndView as the return is bad approach .
	
}
