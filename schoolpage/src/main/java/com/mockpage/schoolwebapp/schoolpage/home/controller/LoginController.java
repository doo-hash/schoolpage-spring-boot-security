package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
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
			else if(grantedAuthority.getAuthority().equals("USER")) {
				return "redirect:/home/user/portal";
			}
		}
		return "redirect:/home";
	}
	
	@GetMapping("/admin/portal")
	public String adminPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser admin = userservice.findUserByUserId(userid); 
		model.addAttribute("admin",admin);
		return "admin_portal";
	}
	
	@GetMapping("/parent/portal")
	public String parentPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser parent = userservice.findUserByUserId(userid); 
		model.addAttribute("parent",parent);
		return "parent_portal";
	}

	@GetMapping("/teacher/portal")
	public String teacherPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser teacher = userservice.findUserByUserId(userid); 
		model.addAttribute("teacher",teacher);
		return "teacher_portal";
	}
	
	@GetMapping("/user/portal")
	public String userPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		model.addAttribute("user",user);
		return "userportal";
	}
	
	@GetMapping("/{userrole}/notifications")
	public String usernotification(@PathVariable String userrole,Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		model.addAttribute("user",user);
		model.addAttribute("userrole",userrole);
		return "notifications";
	}
	
	@GetMapping("/{userrole}/settings")
	public String usersettings(@PathVariable String userrole,Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		model.addAttribute("user",user);
		model.addAttribute("userrole",userrole);
		return "settings";
	}
	
	@GetMapping("/{userrole}/edit")
	public String userUpdate(@PathVariable String userrole,Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		model.addAttribute("user",user);
		model.addAttribute("userrole",userrole);
		return "useredit";
	}
	
	@GetMapping("/{userrole}/remove")
	public String userdelete(@PathVariable String userrole,Authentication authentication,Model model) {
		String userid = authentication.getName();
		userservice.deleteUser(userid);
		return "redirect:/home/login?delete";
	}
}