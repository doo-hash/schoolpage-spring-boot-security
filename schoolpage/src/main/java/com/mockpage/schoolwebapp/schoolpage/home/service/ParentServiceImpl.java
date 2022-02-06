package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.UserParentRepository;

@Service
public class ParentServiceImpl implements IParentService {

	private UserParentRepository parentRepo;
	private SchoolUserRepository userRepo;
	
	public ParentServiceImpl(UserParentRepository parentRepo, SchoolUserRepository userRepo) {
		super();
		this.parentRepo = parentRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<Parentupdate> findAll() {
		List<Parentupdate> findAllParents = parentRepo.findAll();
		return findAllParents;
	}


	@Override
	public void update(Parentupdate parentupdate) {
		SchoolUser user = userRepo.findByUserid(parentupdate.getParentId());
		Parentupdate parent = parentRepo.findByParentId(parentupdate.getParentId());
		if(parent == null) {
			parentRepo.save(parentupdate);
		}
		else {
			parent.setFirstName(parentupdate.getFirstName());
			parent.setLastName(parentupdate.getLastName());
			parent.setEmail(parentupdate.getEmail());
			parent.setParentId(parentupdate.getParentId());
			parent.setPhonenumber(parentupdate.getPhonenumber());
			parent.setStudentName(parentupdate.getStudentName());
			parentRepo.save(parent);
		}
		user.setEmail(parentupdate.getEmail());
		user.setPhonenumber(parentupdate.getPhonenumber());
		userRepo.save(user);
	}


	@Override
	public Parentupdate findByParentId(String parentid) {
		Parentupdate parent = parentRepo.findByParentId(parentid);
		return parent;
	}


	@Override
	public Parentupdate findByEmail(String email) {
		Parentupdate parent = parentRepo.findByEmail(email);
		return parent;
	}

}
