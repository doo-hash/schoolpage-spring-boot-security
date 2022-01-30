package com.mockpage.schoolwebapp.schoolpage.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;

@Repository
public interface UserParentRepository extends JpaRepository<Parentupdate,Long> {

	boolean existsByParentId(String parentId);

	boolean existsByFirstName(String firstName);

	boolean existsByLastName(String lastName);

	boolean existsByEmail(String email);

	Parentupdate findByParentId(String parentId);

	Parentupdate findByEmail(String email);

	Parentupdate findByLastName(String lastName);

	Parentupdate findByFirstName(String firstName);

	Parentupdate findByStudentName(String studentName);
	
	Parentupdate findByPhonenumber(String phonenumber);

}
