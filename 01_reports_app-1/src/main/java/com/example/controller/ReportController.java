package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.entity.CitizenPlan;
import com.example.request.SearchRequest;
import com.example.service.ReportService;



@Controller
public class ReportController {
	
	@Autowired
private ReportService service;
	
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute ("search") SearchRequest search , Model model) {
		
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans", plans);
		init(model);
		
		return"indexs";
	}
	
@RequestMapping("/indexPage")
public String indexPage(Model model) {
	
	model.addAttribute("search", new SearchRequest());
		init(model);
		
		return"indexs";
	
}

private void init(Model model) {
	
	model.addAttribute("names", service.getPlanNames() );
	model.addAttribute("status", service.getPlanStatuses());
}
}
