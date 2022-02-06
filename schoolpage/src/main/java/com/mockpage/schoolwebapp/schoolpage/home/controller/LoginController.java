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
		SchoolUser adminbyemail = userservice.findUserByEmail(userid);
		if(admin != null) {
			model.addAttribute("admin",admin);
		}
		if(adminbyemail != null) {
			model.addAttribute("admin",adminbyemail);
		}
		return "admin_portal";
	}
	
	@GetMapping("/parent/portal")
	public String parentPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser parent = userservice.findUserByUserId(userid); 
		SchoolUser parentbyemail = userservice.findUserByEmail(userid);
		if(parent != null) {
			model.addAttribute("parent",parent);
		}
		if(parentbyemail != null) {
			model.addAttribute("parent",parentbyemail);
		}
		return "parent_portal";
	}

	@GetMapping("/teacher/portal")
	public String teacherPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser teacher = userservice.findUserByUserId(userid); 
		SchoolUser teacherbyemail = userservice.findUserByEmail(userid);
		if(teacher != null) {
			model.addAttribute("teacher",teacher);
		}
		if(teacherbyemail != null) {
			model.addAttribute("teacher",teacherbyemail);
		}
		return "teacher_portal";
	}
	
	@GetMapping("/user/portal")
	public String userPortal(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		if(user != null) {
			model.addAttribute("user",user);
		}
		if(userbyemail != null) {
			model.addAttribute("user",userbyemail);
		}
		return "userportal";
	}
	
	@GetMapping("/{userrole}/notifications")
	public String usernotification(@PathVariable String userrole,Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		if(user != null) {
			model.addAttribute("user",user);
		}
		if(userbyemail != null) {
			model.addAttribute("user",userbyemail);
		}
		model.addAttribute("userrole",userrole);
		return "notifications";
	}
	
	@GetMapping("/{userrole}/settings")
	public String usersettings(@PathVariable String userrole,Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		if(user != null) {
			model.addAttribute("user",user);
		}
		if(userbyemail != null) {
			model.addAttribute("user",userbyemail);
		}
		model.addAttribute("userrole",userrole);
		return "settings";
	}
	
	@GetMapping("/admin/edit")
	public String adminUpdate(Authentication authentication,Model model) {
		String userid = authentication.getName();
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		Adminupdate admin = adminservice.findByAdminId(userid);
		Adminupdate adminbyemail = adminservice.findByEmail(userid);
		
		if(user != null) {
			if(admin == null) {
				model.addAttribute("admin",new Adminupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),user.getDesignation(),null,null));
			}else {
			model.addAttribute("admin",new Adminupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
					user.getEmail(),user.getUserid(),user.getDesignation(),admin.getEducation(),admin.getWork_experience()));
			}
		}
		if(userbyemail != null) {
			if(adminbyemail == null) {
				model.addAttribute("admin",new Adminupdate(userbyemail.getFirstname(),userbyemail.getLastname(),userbyemail.getPhonenumber(),
					userbyemail.getEmail(),userbyemail.getUserid(),userbyemail.getDesignation(),null,null));
			}
			else {
			model.addAttribute("admin",new Adminupdate(userbyemail.getFirstname(),userbyemail.getLastname(),
					userbyemail.getPhonenumber(),
					userbyemail.getEmail(),userbyemail.getUserid(),
					userbyemail.getDesignation(),adminbyemail.getEducation(),adminbyemail.getWork_experience()));
			}
		}
		return "adminedit";
	}
	
	@PostMapping("/admin/update")
	public String updateAdmin(
			@Valid @ModelAttribute("admin") Adminupdate adminupdate,
			BindingResult result,
			Model model) {
		
		String userid = adminupdate.getAdminId();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String email = adminupdate.getEmail(); 
		String phone = adminupdate.getPhonenumber(); 
		boolean isemail = false;  
		boolean isphone = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(email.equals(userobj.getEmail().toString())) { 
				isemail = true; 
			} 
			if(phone.equals(userobj.getPhonenumber().toString())) { 
				isphone = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isemail || isphone) { 
				if(isemail) { model.addAttribute("emailmsg","already exists!!");} 
				if(isphone) { model.addAttribute("phonemsg","already exists!!");} 
				if(isemail && isphone) { model.addAttribute("emailmsg","already exists!!");
				model.addAttribute("phoneemsg","already exists!!");} 
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
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		Teacherupdate teacher = teacherservice.findByTeacherId(userid);
		Teacherupdate teacherbyemail = teacherservice.findByEmail(userid);
		
		if(user != null) {
			if(teacher == null) {
				model.addAttribute("teacher",new Teacherupdate(user.getFirstname(),user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),user.getDesignation(),null,null));
			}
			else {
			model.addAttribute("teacher",new Teacherupdate(user.getFirstname(),user.getLastname(),
					user.getPhonenumber(),
					user.getEmail(),user.getUserid(),user.getDesignation(),
					teacher.getEducation(),teacher.getWork_experience()));
			}
		}
		if(userbyemail != null) {
			if(teacherbyemail == null) {
				model.addAttribute("teacher",new Teacherupdate(userbyemail.getFirstname(),
					userbyemail.getLastname(),userbyemail.getPhonenumber(),
				userbyemail.getEmail(),userbyemail.getUserid(),userbyemail.getDesignation(),null,null));
			}
			else {
			model.addAttribute("teacher",new Teacherupdate(userbyemail.getFirstname(),
					userbyemail.getLastname(),userbyemail.getPhonenumber(),
				userbyemail.getEmail(),userbyemail.getUserid(),userbyemail.getDesignation(),
				teacherbyemail.getEducation(),teacherbyemail.getWork_experience()));
			}
		}
		return "teacheredit";
	}
	
	@PostMapping("/teacher/update")
	public String updateTeacher(
			@Valid @ModelAttribute("teacher") Teacherupdate teacherupdate,
			BindingResult result,
			Model model) {
		
		String userid = teacherupdate.getTeacherId();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String email = teacherupdate.getEmail(); 
		String phone = teacherupdate.getPhonenumber(); 
		boolean isemail = false;  
		boolean isphone = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(email.equals(userobj.getEmail().toString())) { 
				isemail = true; 
			} 
			if(phone.equals(userobj.getPhonenumber().toString())) { 
				isphone = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isemail || isphone) { 
				if(isemail) { model.addAttribute("emailmsg","already exists!!");} 
				if(isphone) { model.addAttribute("phonemsg","already exists!!");} 
				if(isemail && isphone) { model.addAttribute("emailmsg","already exists!!");
				model.addAttribute("phoneemsg","already exists!!");} 
				return "teacheredit";	
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
		
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		Parentupdate parent = parentservice.findByParentId(userid);
		Parentupdate parentbyemail = parentservice.findByEmail(userid);
		
		if(user != null) {
			if(parent == null) {
				model.addAttribute("parent",new Parentupdate(user.getFirstname(),
						user.getLastname(),
						user.getPhonenumber(),
						user.getEmail(),
						user.getUserid(),null));
			}
			else {
				model.addAttribute("parent",new Parentupdate(user.getFirstname(),
						user.getLastname(),
						user.getPhonenumber(),
						user.getEmail(),
						user.getUserid(),
						parent.getStudentName()));
			}
		}
		if(userbyemail != null) {
			if(parentbyemail == null) {
				model.addAttribute("parent",new Parentupdate(userbyemail.getFirstname(),
					userbyemail.getLastname(),userbyemail.getPhonenumber(),
					userbyemail.getEmail(),userbyemail.getUserid(),null));
			}
			else {
			model.addAttribute("parent",new Parentupdate(userbyemail.getFirstname(),
					userbyemail.getLastname(),userbyemail.getPhonenumber(),
					userbyemail.getEmail(),userbyemail.getUserid(),parentbyemail.getStudentName()));
			}
		}
		return "parentedit";
	}
	
	@PostMapping("/parent/update")
	public String updateParent(
			@Valid @ModelAttribute("parent") Parentupdate parentupdate,
			BindingResult result,
			Model model) {
		
		String userid = parentupdate.getParentId();
		SchoolUser user = userservice.findUserByUserId(userid); 
		String email = parentupdate.getEmail(); 
		String phone = parentupdate.getPhonenumber(); 
		boolean isemail = false;  
		boolean isphone = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(email.equals(userobj.getEmail().toString())) { 
				isemail = true; 
			} 
			if(phone.equals(userobj.getPhonenumber().toString())) { 
				isphone = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isemail || isphone) { 
				if(isemail) { model.addAttribute("emailmsg","already exists!!");} 
				if(isphone) { model.addAttribute("phonemsg","already exists!!");} 
				if(isemail && isphone) { model.addAttribute("emailmsg","already exists!!");
				model.addAttribute("phoneemsg","already exists!!");} 
				return "parentedit";	
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
		SchoolUser user = userservice.findUserByUserId(userid); 
		SchoolUser userbyemail = userservice.findUserByEmail(userid);
		GuestUserupdate guestuser = guestuserservice.findByUserId(userid);
		GuestUserupdate guestuserbyemail = guestuserservice.findByEmail(userid);
		if(user != null) {
			if(guestuser == null) {
				model.addAttribute("guestuser",new GuestUserupdate(user.getFirstname(),
						user.getLastname(),user.getPhonenumber(),
				user.getEmail(),user.getUserid(),null,null));
			}else {
			model.addAttribute("guestuser",new GuestUserupdate(user.getFirstname(),
					user.getLastname(),user.getPhonenumber(),
			user.getEmail(),user.getUserid(),guestuser.getEducation(),guestuser.getDescription()));
			}
		}
		if(userbyemail != null) {
			if(guestuserbyemail == null) {
				model.addAttribute("guestuser",new GuestUserupdate(userbyemail.getFirstname(),
					userbyemail.getLastname(),userbyemail.getPhonenumber(),
					userbyemail.getEmail(),userbyemail.getUserid(),null,null));
			}else {
			model.addAttribute("guestuser",new GuestUserupdate(userbyemail.getFirstname(),
					userbyemail.getLastname(),userbyemail.getPhonenumber(),
					userbyemail.getEmail(),userbyemail.getUserid(),guestuserbyemail.getEducation(),
					guestuserbyemail.getDescription()));
			}
		}
		return "useredit";
	}
	
	@PostMapping("/user/update")
	public String updateUserGuest(
			@Valid @ModelAttribute("guestuser") GuestUserupdate userupdate,
			BindingResult result,
			Model model) {
		
		String userid = userupdate.getUserId();
		SchoolUser user = userservice.findUserByUserId(userid); 
		
		String email = userupdate.getEmail(); 
		String phone = userupdate.getPhonenumber(); 
		boolean isemail = false;  
		boolean isphone = false;
		
		List<SchoolUser> allusers = userservice.findAllUsers(); 
		List<SchoolUser> remainingusers = new ArrayList<>();
		
		for (SchoolUser userobj : allusers) { 
			if(!user.toString().equals(userobj.toString())) {
				remainingusers.add(userobj);
			} 
		} 
		
		for(SchoolUser userobj : remainingusers) {
			if(email.equals(userobj.getEmail().toString())) { 
				isemail = true; 
			} 
			if(phone.equals(userobj.getPhonenumber().toString())) { 
				isphone = true; 
			} 
		} 
		if(!result.hasErrors()) { 
			if(isemail || isphone) { 
				if(isemail) { model.addAttribute("emailmsg","already exists!!");} 
				if(isphone) { model.addAttribute("phonemsg","already exists!!");} 
				if(isemail && isphone) { model.addAttribute("emailmsg","already exists!!");
				model.addAttribute("phoneemsg","already exists!!");} 
				return "useredit";	
			}

	
			System.out.println(userupdate);
			guestuserservice.update(userupdate);
			return "redirect:/home/user/edit?success";	
		}
		return "useredit";
	}
	
}