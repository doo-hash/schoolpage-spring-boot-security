package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;

public interface ISchoolUserService extends UserDetailsService {
	
	public SchoolUser saveSchoolUser(SchoolUser user);
	
	public boolean existsByUserId(String userId);
	public boolean existsByFirstName(String firstName);
	public boolean existsByLastName(String lastName);
	public boolean existsByEmail(String email);

	public SchoolUser findUserByUserId(String userId);
	public SchoolUser findUserByFirstName(String firstName);
	public SchoolUser findUserByLastName(String lastName);
	public SchoolUser findUserByEmail(String email);
	public SchoolUser findUserByPhoneNumber(String phoneNumber);
	
	public SchoolUser updateUser(SchoolUser user);
	public void deleteUser(String userId);
	
	public List<SchoolUser> findAllUsersByDesignation(String designation);
	public List<SchoolUser> findAllUsers();
}

