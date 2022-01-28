package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockpage.schoolwebapp.schoolpage.home.service.ISchoolUserService;

@Controller
@RequestMapping("/home")
public class LoginController{

	@Autowired
	private ISchoolUserService userservice;
	
	@GetMapping("/login")
	public String adminLogin() {
		return "login";
	}
	
	@PostMapping("/login/auth_user")
	public String validLogin(Model model,
			@Valid @RequestParam String username, 
			@Valid @RequestParam String password) {
		
		User user = (User) userservice.loadUserByUsername(username);
		Collection<GrantedAuthority> authorities = user.getAuthorities();
		
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equals("ADMIN")) {
				return "redirect:/home/admin/portal";
			}
			else if(grantedAuthority.getAuthority().equals("PARENT")) {
				return "redirect:/home/parent/portal";
			}
			else if(grantedAuthority.getAuthority().equals("TEACHER")) {
				return "redirect:/home/teacher/portal";
			}
		}
		return "redirect:/home";
	}
}