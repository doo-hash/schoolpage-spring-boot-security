package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mockpage.schoolwebapp.schoolpage.home.model.Role;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.service.ArticleService;
import com.mockpage.schoolwebapp.schoolpage.home.service.ISchoolUserService;

@Controller
public class HomeController {

	@Autowired
	private ArticleService articleservice;
	
	@Autowired
	private ISchoolUserService userservice;
	
	@ModelAttribute("userrole")
	public String userRole(Authentication authentication) {
		String userrole = null;
		if(authentication != null) {
			String userid = authentication.getName();
			SchoolUser user = userservice.findUserByUserId(userid);
			SchoolUser userbyemail = userservice.findUserByEmail(userid);
			
			if(user != null) {
				Collection<Role> roles = user.getRoles();
				for (Role role : roles) {
					if(role.getRolename().equals("ADMIN")) {
						userrole = "admin";
					}
					else if(role.getRolename().equals("TEACHER")) {
						userrole = "teacher";
					}
					else if(role.getRolename().equals("PARENT")) {
						userrole = "parent";
					}
					else {
						userrole = "user";
					}
				}
			}
			
			if(userbyemail != null) {
				Collection<Role> rolesemail = userbyemail.getRoles();
				for (Role role : rolesemail) {
					if(role.getRolename().equals("ADMIN")) {
						userrole = "admin";
					}
					else if(role.getRolename().equals("TEACHER")) {
						userrole = "teacher";
					}
					else if(role.getRolename().equals("PARENT")) {
						userrole = "parent";
					}
					else {
						userrole = "user";
					}
				}
			}
			
		}
		
		return userrole;
	}
	
	@RequestMapping({"/","/home"})
	public String home(Model model,Authentication authentication) {
		model.getAttribute(userRole(authentication));
		articleservice.saveAll();
		Iterable<SchoolArticles> schoolArticles = articleservice.findAll();
		model.addAttribute("articles",schoolArticles);
		return "index";
	}
	
}
