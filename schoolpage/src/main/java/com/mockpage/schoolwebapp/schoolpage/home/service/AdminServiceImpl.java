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
		System.out.println(adminupdate);
		adminRepo.save(adminupdate);
		SchoolUser updateUser = userRepo.findByUserid(adminupdate.getAdminId());
		System.out.println(updateUser);
		updateUser.setFirstname(adminupdate.getFirstName());
		updateUser.setLastname(adminupdate.getLastName());
		updateUser.setPhonenumber(adminupdate.getPhonenumber());
		updateUser.setDesignation(adminupdate.getDesignation());
		System.out.println(updateUser);
		userRepo.save(updateUser);
		System.out.println(userRepo.findByUserid(updateUser.getUserid()));
	}

}
