package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.UserAdminRepository;

@Service
public class AdminServiceImpl implements IAdminService {

	private UserAdminRepository adminRepo;
	private SchoolUserRepository userRepo;
	
	public AdminServiceImpl(UserAdminRepository adminRepo, SchoolUserRepository userRepo) {
		super();
		this.adminRepo = adminRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<Adminupdate> findAll() {
		List<Adminupdate> findAlladmins = adminRepo.findAll();
		return findAlladmins;
	}


	@Override
	public void update(Adminupdate adminupdate) {
		SchoolUser user = userRepo.findByUserid(adminupdate.getAdminId());
		Adminupdate admin = adminRepo.findByAdminId(adminupdate.getAdminId());
		if(admin == null) {
			adminRepo.save(adminupdate);
		}
		else {
			admin.setFirstName(adminupdate.getFirstName());
			admin.setLastName(adminupdate.getLastName());
			admin.setEmail(adminupdate.getEmail());
			admin.setPhonenumber(adminupdate.getPhonenumber());
			admin.setAdminId(adminupdate.getAdminId());
			admin.setDesignation(adminupdate.getDesignation());
			admin.setEducation(adminupdate.getEducation());
			admin.setWork_experience(adminupdate.getWork_experience());
			adminRepo.save(admin);
		}
		user.setEmail(adminupdate.getEmail());
		user.setPhonenumber(adminupdate.getPhonenumber());
		user.setDesignation(adminupdate.getDesignation());
		userRepo.save(user);
	}


	@Override
	public Adminupdate findByAdminId(String adminid) {
		if(adminid != null) {
			Adminupdate admin = adminRepo.findByAdminId(adminid);
			return admin;
		}
		return null;
	}


	@Override
	public Adminupdate findByEmail(String email) {
		if(email != null) {
			Adminupdate admin = adminRepo.findByEmail(email);
			return admin;
		}
		return null;
	}

}
