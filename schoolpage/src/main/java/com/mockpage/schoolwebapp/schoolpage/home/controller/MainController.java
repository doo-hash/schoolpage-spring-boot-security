package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mockpage.schoolwebapp.schoolpage.home.model.Admissions;
import com.mockpage.schoolwebapp.schoolpage.home.model.Courses;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;
import com.mockpage.schoolwebapp.schoolpage.home.service.AdmissionsService;
import com.mockpage.schoolwebapp.schoolpage.home.service.ArticleService;
import com.mockpage.schoolwebapp.schoolpage.home.service.CoursesService;


@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	private ArticleService articleservice;
 
	@Autowired
	private AdmissionsService admissionsService;

	@Autowired
	private CoursesService coursesService;

	@GetMapping("/about")
	public String about(Model model) {
		
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("news",news);
		model.addAttribute("title_name","About");
		return "about";
	}
	
	@GetMapping("/admissions")
	public String admissions(Model model) {
		Iterable<Admissions> data = admissionsService.findAll();
		model.addAttribute("title_name","Admissions");
		model.addAttribute("admissionsdata",data);
		return "admissions";
	}
	@GetMapping("/news")
	public String news(Model model) {
		
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("articles",news);
		model.addAttribute("title_name","News");
	
		return "blog";
	}

	@GetMapping("/news/articles/{id}")
	public String news_article(@PathVariable Long id,Model model) {

		Optional<SchoolArticles> article = articleservice.getById(id);
		if(article.isEmpty()) {
			model.addAttribute("errormsg","Article Not Found");			
		}
		model.addAttribute("newsarticle",article.get());
		model.addAttribute("title_name","News Articles");
		return "news_article";
	}

	@GetMapping("/guidance")
	public String guidance(Model model) {
		
		Iterable<SchoolArticles> blog = articleservice.findAll();
		model.addAttribute("articles",blog);
		model.addAttribute("title_name","Guidance");

		return "blog";
	}
	
	@GetMapping("/employment")
	public String employment(Model model) {
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("news",news);
		model.addAttribute("title_name","Employment News");
		return "employment";
	}
	
	@GetMapping("/blog")
	public String blog(Model model) {

		Iterable<SchoolArticles> schoolArticles = articleservice.findAll();
		model.addAttribute("articles",schoolArticles);
		model.addAttribute("title_name","Blog");

		return "blog";
	}
	
	@GetMapping("/blog/article/{id}")
	public String blog(@PathVariable Long id,Model model) {
		model.addAttribute("title_name","Blog Articles");

		Optional<SchoolArticles> article = articleservice.getById(id);
		if(article.isEmpty()) {
			model.addAttribute("errormsg","Article Not Found");			
		}
		model.addAttribute("blogarticle",article.get());
		return "article";
	}

	@GetMapping("/academics/courses")
	public String courses(Model model) {
		Iterable<Courses> dept_courses = coursesService.findAll();
		model.addAttribute("dept_courses",dept_courses);
		model.addAttribute("title_name","Academic Courses");

		return "courses";
	}
	
	@GetMapping("/academics/departments")
	public String departments(Model model) {
		Iterable<Courses> dept_courses = coursesService.findAll();
		model.addAttribute("dept_courses",dept_courses);
		model.addAttribute("title_name","Academic Departments");

		return "courses";
	}
	
	@GetMapping("/calendar")
	public String calendar(Model model) {
		model.addAttribute("title_name","Calendar");
		return "calendar";
	}
	
	@GetMapping("/team")
	public String ourteam(Model model) {
		model.addAttribute("title_name","Our Team");
		return "ourteam";
	}
	
	@GetMapping("/activities")
	public String activities(Model model) {
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("news",news);
		model.addAttribute("title_name","Activities");

		return "actvities";
	}
}
