package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.UserTeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService {

	private UserTeacherRepository TeacherRepo;
	private SchoolUserRepository userRepo;
	
	public TeacherServiceImpl(UserTeacherRepository TeacherRepo, SchoolUserRepository userRepo) {
		super();
		this.TeacherRepo = TeacherRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<Teacherupdate> findAll() {
		List<Teacherupdate> findAllTeachers = TeacherRepo.findAll();
		return findAllTeachers;
	}


	@Override
	public void update(Teacherupdate Teacherupdate) {
		System.out.println(Teacherupdate);
		TeacherRepo.save(Teacherupdate);
		SchoolUser updateUser = userRepo.findByUserid(Teacherupdate.getTeacherId());
		System.out.println(updateUser);
		updateUser.setFirstname(Teacherupdate.getFirstName());
		updateUser.setLastname(Teacherupdate.getLastName());
		updateUser.setPhonenumber(Teacherupdate.getPhonenumber());
		updateUser.setDesignation(Teacherupdate.getDesignation());
		System.out.println(updateUser);
		userRepo.save(updateUser);
		System.out.println(userRepo.findByUserid(updateUser.getUserid()));
	}

}
