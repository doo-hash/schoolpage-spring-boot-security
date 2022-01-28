package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Roles;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;
import com.mockpage.schoolwebapp.schoolpage.home.repository.SchoolUserRepository;

@Service
public class SchoolUserServiceImpl implements ISchoolUserService {

	@Autowired
	private SchoolUserRepository userRepo;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@Override
	public SchoolUser saveSchoolUser(SchoolUser newuser) {
		System.out.println(newuser.toString());
		String psd = passwordEncoder.encode(newuser.getPassword());
		SchoolUser user = new SchoolUser(newuser.getFirstName(),newuser.getLastName(),
				newuser.getEmail(),newuser.getPhoneNumber(),
				newuser.getUserId(),newuser.getDesignation(),
				psd,newuser.getRoles(),
				newuser.isChecked());
		System.out.println(user);
		userRepo.save(user);
		System.out.println(userRepo.getById(user.getId()));
		return user;
	}

	@Override
	public boolean existsByUserId(String userId) {
		boolean isUserId = userRepo.existsByUserId(userId);
		return isUserId;
	}

	@Override
	public boolean existsByFirstName(String firstName) {
		boolean isFirstName = userRepo.existsByFirstName(firstName);
		return isFirstName;
	}

	@Override
	public boolean existsByLastName(String lastName) {
		boolean isLastName = userRepo.existsByLastName(lastName);
		return isLastName;
	}

	@Override
	public boolean existsByEmail(String email) {
		boolean isEmail = userRepo.existsByEmail(email);
		return isEmail;
	}

	@Override
	public SchoolUser findUserByUserId(String userId) {
		SchoolUser user = userRepo.findByUserId(userId);
		return user;
	}

	@Override
	public SchoolUser findUserByFirstName(String firstName) {
		SchoolUser user = userRepo.findByFirstName(firstName);
		return user;
	}

	@Override
	public SchoolUser findUserByLastName(String lastName) {
		SchoolUser user = userRepo.findByLastName(lastName);
		return user;
	}

	@Override
	public SchoolUser findUserByEmail(String email) {
		SchoolUser user = userRepo.findByEmail(email);
		return user;
	}

	@Override
	public SchoolUser findUserByPhoneNumber(String phoneNumber) {
		SchoolUser user = userRepo.findByPhoneNumber(phoneNumber);
		return user;
	}
	
	@Override
	public SchoolUser updateUser(SchoolUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(String userId) {
		SchoolUser user = userRepo.findByUserId(userId);
		userRepo.delete(user);
	}

	@Override
	public List<SchoolUser> findAllUsersByDesignation(String designation) {
		List<SchoolUser> allusers = userRepo.findAllByDesignation(designation);
		return allusers;
	}

	@Override
	public List<SchoolUser> findAllUsers() {
		List<SchoolUser> allusers = userRepo.findAll();
		return allusers;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SchoolUser user = userRepo.findByUserId(username);
		if(user == null) {
			throw new UsernameNotFoundException("Invalid Username or password");
		}
		return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Roles> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRolename())).collect(Collectors.toList());
	}
}
