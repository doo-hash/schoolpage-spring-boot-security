package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mockpage.schoolwebapp.schoolpage.home.model.Admissions;
import com.mockpage.schoolwebapp.schoolpage.home.model.Courses;
import com.mockpage.schoolwebapp.schoolpage.home.model.Role;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.service.AdmissionsService;
import com.mockpage.schoolwebapp.schoolpage.home.service.ArticleService;
import com.mockpage.schoolwebapp.schoolpage.home.service.CoursesService;
import com.mockpage.schoolwebapp.schoolpage.home.service.ISchoolUserService;


@Controller
@RequestMapping("/home")
public class MainController {

	@Autowired
	private ArticleService articleservice;
 
	@Autowired
	private AdmissionsService admissionsService;

	@Autowired
	private CoursesService coursesService;

	@Autowired
	private ISchoolUserService userservice;
	
	
	@ModelAttribute("userrole")
	public String userRole(Authentication authentication) {
		String userrole = null;
		String userid = null;
		
		if(authentication != null) {
			userid = authentication.getName();
			SchoolUser user = userservice.findUserByUserId(userid);
			Collection<Role> roles = user.getRoles();
		
			for (Role role : roles) {
				if(role.getRolename().equals("ADMIN")) {
					userrole = "admin";
				}
				if(role.getRolename().equals("TEACHER")) {
					userrole = "teacher";
				}
				if(role.getRolename().equals("PARENT")) {
					userrole = "parent";
				}
				userrole = "user";
			}
		}
		return userrole;
	}
	
	@GetMapping("/about")
	public String about(Model model,Authentication authentication) {
		model.getAttribute(userRole(authentication));
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("news",news);
		model.addAttribute("title_name","About");
		return "about";
	}
	
	@GetMapping("/admissions")
	public String admissions(Model model,Authentication authentication) {
		Iterable<Admissions> data = admissionsService.findAll();
		model.addAttribute("title_name","Admissions");
		model.addAttribute("admissionsdata",data);
		model.getAttribute(userRole(authentication));
		return "admissions";
	}
	@GetMapping("/news")
	public String news(Model model,Authentication authentication) {
		model.getAttribute(userRole(authentication));
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("articles",news);
		model.addAttribute("title_name","News");
	
		return "blog";
	}

	@GetMapping("/news/articles/{id}")
	public String news_article(@PathVariable Long id,Model model,Authentication authentication) {
		model.getAttribute(userRole(authentication));
		Optional<SchoolArticles> article = articleservice.getById(id);
		if(article.isEmpty()) {
			model.addAttribute("errormsg","Article Not Found");			
		}
		model.addAttribute("newsarticle",article.get());
		model.addAttribute("title_name","News Articles");
		return "news_article";
	}

	@GetMapping("/guidance")
	public String guidance(Model model,Authentication authentication) {
		
		Iterable<SchoolArticles> blog = articleservice.findAll();
		model.addAttribute("articles",blog);
		model.addAttribute("title_name","Guidance");
		model.getAttribute(userRole(authentication));
		return "blog";
	}
	
	@GetMapping("/employment")
	public String employment(Model model,Authentication authentication) {
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("news",news);
		model.addAttribute("title_name","Employment News");
		model.getAttribute(userRole(authentication));
		return "employment";
	}
	
	@GetMapping("/blog")
	public String blog(Model model,Authentication authentication) {

		Iterable<SchoolArticles> schoolArticles = articleservice.findAll();
		model.addAttribute("articles",schoolArticles);
		model.addAttribute("title_name","Blog");
		model.getAttribute(userRole(authentication));
		return "blog";
	}
	
	@GetMapping("/blog/article/{id}")
	public String blog(@PathVariable Long id,Model model,Authentication authentication) {
		model.addAttribute("title_name","Blog Articles");

		Optional<SchoolArticles> article = articleservice.getById(id);
		if(article.isEmpty()) {
			model.addAttribute("errormsg","Article Not Found");			
		}
		model.addAttribute("blogarticle",article.get());
		model.getAttribute(userRole(authentication));
		return "article";
	}

	@GetMapping("/academics/courses")
	public String courses(Model model,Authentication authentication) {
		Iterable<Courses> dept_courses = coursesService.findAll();
		model.addAttribute("dept_courses",dept_courses);
		model.addAttribute("title_name","Academic Courses");
		model.getAttribute(userRole(authentication));
		return "courses";
	}
	
	@GetMapping("/academics/departments")
	public String departments(Model model,Authentication authentication) {
		Iterable<Courses> dept_courses = coursesService.findAll();
		model.addAttribute("dept_courses",dept_courses);
		model.addAttribute("title_name","Academic Departments");
		model.getAttribute(userRole(authentication));
		return "courses";
	}
	
	@GetMapping("/calendar")
	public String calendar(Model model,Authentication authentication) {
		model.addAttribute("title_name","Calendar");
		model.getAttribute(userRole(authentication));
		return "calendar";
	}
	
	@GetMapping("/team")
	public String ourteam(Model model,Authentication authentication) {
		model.addAttribute("title_name","Our Team");
		model.getAttribute(userRole(authentication));
		return "ourteam";
	}
	
	@GetMapping("/activities")
	public String activities(Model model,Authentication authentication) {
		Iterable<SchoolArticles> news = articleservice.findAll();
		model.addAttribute("news",news);
		model.addAttribute("title_name","Activities");
		model.getAttribute(userRole(authentication));
		return "actvities";
	}
}
