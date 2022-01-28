package com.mockpage.schoolwebapp.schoolpage.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;
import com.mockpage.schoolwebapp.schoolpage.home.service.ArticleService;

@Controller
public class HomeController {

	@Autowired
	private ArticleService articleservice;
	
	
	@RequestMapping({"/","/home"})
	public String home(Model model) {
		
		articleservice.saveAll();
		Iterable<SchoolArticles> schoolArticles = articleservice.findAll();
		model.addAttribute("articles",schoolArticles);
			
		return "index";
	}
	
}
