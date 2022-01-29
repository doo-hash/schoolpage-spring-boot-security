package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;

public interface ISchoolUserService extends UserDetailsService {
	
	public SchoolUser saveSchoolUser(SchoolUser user);
	
	public boolean existsByUserId(String userid);
	public boolean existsByFirstName(String firstname);
	public boolean existsByLastName(String lastname);
	public boolean existsByEmail(String email);

	public SchoolUser findUserByUserId(String userid);
	public SchoolUser findUserByFirstName(String firstname);
	public SchoolUser findUserByLastName(String lastname);
	public SchoolUser findUserByEmail(String email);
	public SchoolUser findUserByPhoneNumber(String phonenumber);
	
	public SchoolUser updateUser(SchoolUser user);
	public void deleteUser(String userid);
	
	public List<SchoolUser> findAllUsersByDesignation(String designation);
	public List<SchoolUser> findAllUsers();
}

