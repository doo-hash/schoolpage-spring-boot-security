package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.UserTeacherRepository;

@Service
public class TeacherServiceImpl implements ITeacherService {

	private UserTeacherRepository teacherRepo;
	private SchoolUserRepository userRepo;
	
	public TeacherServiceImpl(UserTeacherRepository teacherRepo, SchoolUserRepository userRepo) {
		super();
		this.teacherRepo = teacherRepo;
		this.userRepo = userRepo;
	}


	@Override
	public List<Teacherupdate> findAll() {
		List<Teacherupdate> findAllTeachers = teacherRepo.findAll();
		return findAllTeachers;
	}


	@Override
	public void update(Teacherupdate teacherupdate) {
		
		SchoolUser user = userRepo.findByUserid(teacherupdate.getTeacherId());
		Teacherupdate teacher = teacherRepo.findByTeacherId(teacherupdate.getTeacherId());
		
		
		if(teacher == null) {
			teacherRepo.save(teacherupdate);
		}
		else {	
			teacher.setFirstName(teacherupdate.getFirstName());
			teacher.setLastName(teacherupdate.getLastName());
			teacher.setPhonenumber(teacherupdate.getPhonenumber());
			teacher.setEmail(teacherupdate.getEmail());
			teacher.setTeacherId(teacherupdate.getTeacherId());
			teacher.setEducation(teacherupdate.getEducation());
			teacher.setWork_experience(teacherupdate.getWork_experience());
			teacherRepo.save(teacher);
		}
		user.setEmail(teacherupdate.getEmail());
		user.setPhonenumber(teacherupdate.getPhonenumber());
		user.setDesignation(teacherupdate.getDesignation());
		userRepo.save(user);

		}


	@Override
	public Teacherupdate findByEmail(String email) {
		Teacherupdate teacher = teacherRepo.findByEmail(email);
		return teacher;
	}


	@Override
	public Teacherupdate findByTeacherId(String teacherid) {
		Teacherupdate teacher = teacherRepo.findByTeacherId(teacherid);
		return teacher;
	}

}
