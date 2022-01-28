package com.mockpage.schoolwebapp.schoolpage.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Courses;
import com.mockpage.schoolwebapp.schoolpage.home.repository.CoursesRepository;

@Service
public class CoursesService {

	@Autowired
	private CoursesRepository coursesRepo;

	public Iterable<Courses> findAll(){
		Iterable<Courses> courses = coursesRepo.findAll();
		return courses;
	}
}
