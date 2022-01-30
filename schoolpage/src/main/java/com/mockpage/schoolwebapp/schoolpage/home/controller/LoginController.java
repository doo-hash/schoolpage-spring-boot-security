package com.mockpage.schoolwebapp.schoolpage.home.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.GuestUserupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;
import com.mockpage.schoolwebapp.schoolpage.home.service.IAdminService;
import com.mockpage.schoolwebapp.schoolpage.home.service.IGuestUserService;
import com.mockpage.schoolwebapp.schoolpage.home.service.IParentService;
import com.mockpage.schoolwebapp.schoolpage.home.service.ISchoolUserService;
import com.mockpage.schoolwebapp.schoolpage.home.service.ITeacherService;

@Controller
@RequestMapping("/home")
public class LoginController{

	@Autowired
	private ISchoolUserService userservice;
	
	@Autowired
	private IAdminService adminservice;
	
	@Autowired
	private ITeacherService teacherservice;
	
	@Autowired
	private IParentService parentservice;
	
	@Autowired
	private IGuestUserService guestuserservice;
	
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
	
	@GetMapping("/admin/edit")
	public String adminUpdate(Authentication authentication,Model model) {
		String userid = authentication.getName();
		System.out.println(userid);
		SchoolUser user = userservice.findUserByUserId(userid); 
		System.out.println(user);
		model.addAttribute("admin",new Adminupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),user.getDesignation(),null,null));
		return "adminedit";
	}
	
	@PostMapping("/admin/update")
	public String updateAdmin(Authentication authentication,
			@Valid @ModelAttribute("admin") Adminupdate adminupdate,
			BindingResult result,
			Model model) {
		
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String firstName = adminupdate.getFirstName(); 
		String lastName = adminupdate.getLastName(); 
		boolean isfname = false;  
		boolean islname = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(firstName.equals(userobj.getFirstname().toString())) { 
				isfname = true; 
			} 
			if(lastName.equals(userobj.getLastname().toString())) { 
				islname = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isfname || islname) { 
				if(isfname) { model.addAttribute("fnamemsg","already exists!!");} 
				if(islname) { model.addAttribute("lnamemsg","already exists!!");} 
				if(isfname && islname) { model.addAttribute("fnamemsg","already exists!!");
				model.addAttribute("lnamemsg","already exists!!");} 
				model.addAttribute("lnamemsg","already exists!!"); 
				return "adminedit";	
			}
	
			System.out.println(adminupdate);
			adminservice.update(adminupdate);
			return "redirect:/home/admin/edit?success";	
		}
		return "adminedit";
	}
	
	@GetMapping("/teacher/edit")
	public String teacherUpdate(Authentication authentication,Model model) {
		String userid = authentication.getName();
		System.out.println(userid);
		SchoolUser user = userservice.findUserByUserId(userid); 
		System.out.println(user);
		model.addAttribute("teacher",new Teacherupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),user.getDesignation(),null,null));
		return "teacheredit";
	}
	
	@PostMapping("/teacher/update")
	public String updateTeacher(Authentication authentication,
			@Valid @ModelAttribute("teacher") Teacherupdate teacherupdate,
			BindingResult result,
			Model model) {
		
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String firstName = teacherupdate.getFirstName(); 
		String lastName = teacherupdate.getLastName(); 
		boolean isfname = false;  
		boolean islname = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(firstName.equals(userobj.getFirstname().toString())) { 
				isfname = true; 
			} 
			if(lastName.equals(userobj.getLastname().toString())) { 
				islname = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isfname || islname) { 
				if(isfname) { model.addAttribute("fnamemsg","already exists!!");} 
				if(islname) { model.addAttribute("lnamemsg","already exists!!");} 
				if(isfname && islname) { model.addAttribute("fnamemsg","already exists!!");
				model.addAttribute("lnamemsg","already exists!!");} 
				model.addAttribute("lnamemsg","already exists!!"); 
				return "adminedit";	
			}
	
			System.out.println(teacherupdate);
			teacherservice.update(teacherupdate);
			return "redirect:/home/teacher/edit?success";	
		}
		return "teacheredit";
	}
	
	@GetMapping("/parent/edit")
	public String parentUpdate(Authentication authentication,Model model) {
		String userid = authentication.getName();
		System.out.println(userid);
		SchoolUser user = userservice.findUserByUserId(userid); 
		System.out.println(user);
		model.addAttribute("parent",new Parentupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),null));
		return "parentedit";
	}
	
	@PostMapping("/parent/update")
	public String updateParent(Authentication authentication,
			@Valid @ModelAttribute("parent") Parentupdate parentupdate,
			BindingResult result,
			Model model) {
		
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String firstName = parentupdate.getFirstName(); 
		String lastName = parentupdate.getLastName(); 
		boolean isfname = false;  
		boolean islname = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(firstName.equals(userobj.getFirstname().toString())) { 
				isfname = true; 
			} 
			if(lastName.equals(userobj.getLastname().toString())) { 
				islname = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isfname || islname) { 
				if(isfname) { model.addAttribute("fnamemsg","already exists!!");} 
				if(islname) { model.addAttribute("lnamemsg","already exists!!");} 
				if(isfname && islname) { model.addAttribute("fnamemsg","already exists!!");
				model.addAttribute("lnamemsg","already exists!!");} 
				model.addAttribute("lnamemsg","already exists!!"); 
				return "adminedit";	
			}
	
			System.out.println(parentupdate);
			parentservice.update(parentupdate);
			return "redirect:/home/parent/edit?success";	
		}
		return "parentedit";
	}
	
	@GetMapping("/user/edit")
	public String guestUserUpdate(Authentication authentication,Model model) {
		String userid = authentication.getName();
		System.out.println(userid);
		SchoolUser user = userservice.findUserByUserId(userid); 
		System.out.println(user);
		model.addAttribute("guestuser",new GuestUserupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),null,null));
		return "useredit";
	}
	
	@PostMapping("/user/update")
	public String updateUserGuest(Authentication authentication,
			@Valid @ModelAttribute("guestuser") GuestUserupdate userupdate,
			BindingResult result,
			Model model) {
		
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String firstName = userupdate.getFirstName(); 
		String lastName = userupdate.getLastName(); 
		boolean isfname = false;  
		boolean islname = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(firstName.equals(userobj.getFirstname().toString())) { 
				isfname = true; 
			} 
			if(lastName.equals(userobj.getLastname().toString())) { 
				islname = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isfname || islname) { 
				if(isfname) { model.addAttribute("fnamemsg","already exists!!");} 
				if(islname) { model.addAttribute("lnamemsg","already exists!!");} 
				if(isfname && islname) { model.addAttribute("fnamemsg","already exists!!");
				model.addAttribute("lnamemsg","already exists!!");} 
				model.addAttribute("lnamemsg","already exists!!"); 
				return "adminedit";	
			}
	
			System.out.println(userupdate);
			guestuserservice.update(userupdate);
			return "redirect:/home/user/edit?success";	
		}
		return "useredit";
	}
	
}