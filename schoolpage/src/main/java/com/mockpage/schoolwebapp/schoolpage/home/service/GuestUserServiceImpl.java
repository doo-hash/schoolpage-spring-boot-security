package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.GuestUserupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.GuestUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;

@Service
public class GuestUserServiceImpl implements IGuestUserService {

	private GuestUserRepository guestuserRepo;
	private SchoolUserRepository userRepo;
	
	public GuestUserServiceImpl(GuestUserRepository guestuserRepo, SchoolUserRepository userRepo) {
		super();
		this.guestuserRepo = guestuserRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<GuestUserupdate> findAll() {
		List<GuestUserupdate> findAllGuestUsers = guestuserRepo.findAll();
		return findAllGuestUsers;
	}


	@Override
	public void update(GuestUserupdate guestuserupdate) {
		SchoolUser user = userRepo.findByUserid(guestuserupdate.getUserId());
		GuestUserupdate guestuser = guestuserRepo.findByUserId(guestuserupdate.getUserId());
		
		if(guestuser == null) {
			guestuserRepo.save(guestuserupdate);
		}
		else {
			guestuser.setFirstName(guestuserupdate.getFirstName());
			guestuser.setLastName(guestuserupdate.getLastName());
			guestuser.setEmail(guestuserupdate.getEmail());
			guestuser.setPhonenumber(guestuserupdate.getPhonenumber());
			guestuser.setUserId(guestuserupdate.getUserId());
			guestuser.setEducation(guestuserupdate.getEducation());
			guestuser.setDescription(guestuserupdate.getDescription());
			guestuserRepo.save(guestuser);
		}
		
		user.setDesignation(guestuserupdate.getDescription());
		user.setEmail(guestuserupdate.getEmail());
		user.setPhonenumber(guestuserupdate.getPhonenumber());
		userRepo.save(user);
	}


	@Override
	public GuestUserupdate findByUserId(String userid) {
		GuestUserupdate user = guestuserRepo.findByUserId(userid);
		return user;
	}


	@Override
	public GuestUserupdate findByEmail(String email) {
		GuestUserupdate user = guestuserRepo.findByEmail(email);
		return user;
	}

}
