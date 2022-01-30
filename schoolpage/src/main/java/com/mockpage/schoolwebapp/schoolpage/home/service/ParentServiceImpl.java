package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.UserParentRepository;

@Service
public class ParentServiceImpl implements IParentService {

	private UserParentRepository ParentRepo;
	private SchoolUserRepository userRepo;
	
	public ParentServiceImpl(UserParentRepository ParentRepo, SchoolUserRepository userRepo) {
		super();
		this.ParentRepo = ParentRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<Parentupdate> findAll() {
		List<Parentupdate> findAllParents = ParentRepo.findAll();
		return findAllParents;
	}


	@Override
	public void update(Parentupdate Parentupdate) {
		System.out.println(Parentupdate);
		ParentRepo.save(Parentupdate);
		SchoolUser updateUser = userRepo.findByUserid(Parentupdate.getParentId());
		System.out.println(updateUser);
		updateUser.setFirstname(Parentupdate.getFirstName());
		updateUser.setLastname(Parentupdate.getLastName());
		updateUser.setPhonenumber(Parentupdate.getPhonenumber());
		System.out.println(updateUser);
		userRepo.save(updateUser);
		System.out.println(userRepo.findByUserid(updateUser.getUserid()));
	}

}
