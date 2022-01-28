package com.mockpage.schoolwebapp.schoolpage.home.controller;
  
  import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import
  org.springframework.validation.BindingResult;
import
  org.springframework.web.bind.annotation.GetMapping;
import
  org.springframework.web.bind.annotation.ModelAttribute;
import
  org.springframework.web.bind.annotation.PostMapping;
import
  org.springframework.web.bind.annotation.RequestMapping;
import
  org.springframework.web.bind.annotation.RequestParam;

import
  com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.model.User_Roles;
import
  com.mockpage.schoolwebapp.schoolpage.home.service.SchoolUserServiceImpl;
import com.mockpage.schoolwebapp.schoolpage.home.validator.CaptchaValidator;
  
  @Controller
  @RequestMapping("/home") 
  public class SchoolUserController {
  
	  protected Logger logger = LoggerFactory.getLogger(this.getClass());
  
	  @Autowired 
	  private SchoolUserServiceImpl userservice;
  
	  @Autowired 
	  private CaptchaValidator captchavalidator;
  
	  @GetMapping("/register") 
	  public String registerForm(Model model) {
		  model.addAttribute("user", new SchoolUser()); 
		  model.addAttribute("userroles",User_Roles.values());
		  return "userform"; 
	  }
  
	  @PostMapping("/register/save") 
	  public String userCheck(
			  @RequestParam("g-recaptcha-response") String captcha,
			  @Valid @ModelAttribute("user") SchoolUser user, 
			  BindingResult result, 
			  Model model) {
		  
		  model.addAttribute("roles",User_Roles.values());
		    	System.out.println(user);
		  userservice.saveSchoolUser(user);
		  System.out.println(userservice.findUserByEmail(user.getEmail()));
		  return "redirect:/home/register?success";
  }
 
  }