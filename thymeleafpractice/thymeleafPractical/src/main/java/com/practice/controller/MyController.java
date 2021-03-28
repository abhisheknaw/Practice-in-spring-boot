package com.practice.controller;






import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class MyController {
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="/about", method= RequestMethod.GET)
	public String about(Model model)
	{
		System.out.println("inside about handler.....");
		
		//putting data in model
		model.addAttribute("name","Abhishek Nawani");
		
		model.addAttribute("currentDate", new Date().toLocaleString());
		return "about.html";
		//about.html
	}	
	
	//handling iteration
	
	@GetMapping("/example-loop")
	public String iterateHandler(Model m)
	{
		List<String> names = List.of("Abhishek","Akshita","Akshat","Ansh");
		m.addAttribute("names",names);
		return "iterate";
	}
	
	//handler for including fragments
	
	@GetMapping("/service")
	public String serviceHandler(Model ma)
	{
		ma.addAttribute("title","hey come to my page");
		ma.addAttribute("subtitle","how are you");
		return "service";
	}
	
	//inheriting dynamically
	
	@GetMapping("/aboutnew")
	public String aboutnew()
	{
		return "aboutnew";
	}
}
