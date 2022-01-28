package com.mockpage.schoolwebapp.schoolpage.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Admissions;
import com.mockpage.schoolwebapp.schoolpage.home.repository.AdmissionsRepository;

@Service
public class AdmissionsService {

	@Autowired
	private AdmissionsRepository admissionsRepo;

	public Iterable<Admissions> findAll(){
		Iterable<Admissions> admissions = admissionsRepo.findAll();
		return admissions;
	}
}
