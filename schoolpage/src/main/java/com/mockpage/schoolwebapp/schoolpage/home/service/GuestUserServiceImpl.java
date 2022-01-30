package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.GuestUserupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.GuestUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;

@Service
public class GuestUserServiceImpl implements IGuestUserService {

	private GuestUserRepository GuestUserRepo;
	private SchoolUserRepository userRepo;
	
	public GuestUserServiceImpl(GuestUserRepository GuestUserRepo, SchoolUserRepository userRepo) {
		super();
		this.GuestUserRepo = GuestUserRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<GuestUserupdate> findAll() {
		List<GuestUserupdate> findAllGuestUsers = GuestUserRepo.findAll();
		return findAllGuestUsers;
	}


	@Override
	public void update(GuestUserupdate guestuserupdate) {
		System.out.println(guestuserupdate);
		GuestUserRepo.save(guestuserupdate);
		SchoolUser updateUser = userRepo.findByUserid(guestuserupdate.getUserId());
		System.out.println(updateUser);
		updateUser.setFirstname(guestuserupdate.getFirstName());
		updateUser.setLastname(guestuserupdate.getLastName());
		updateUser.setPhonenumber(guestuserupdate.getPhonenumber());
		System.out.println(updateUser);
		userRepo.save(updateUser);
		System.out.println(userRepo.findByUserid(updateUser.getUserid()));
	}

}
