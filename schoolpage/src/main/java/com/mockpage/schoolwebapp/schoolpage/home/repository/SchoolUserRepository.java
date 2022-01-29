package com.mockpage.schoolwebapp.schoolpage.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;

@Repository
public interface SchoolUserRepository extends JpaRepository<SchoolUser,Long> {

	boolean existsByUserid(String userid);

	boolean existsByFirstname(String firstname);

	boolean existsByLastname(String lastname);

	boolean existsByEmail(String email);

	SchoolUser findByUserid(String userid);

	SchoolUser findByEmail(String email);

	SchoolUser findByLastname(String lastname);

	SchoolUser findByFirstname(String firstname);

	List<SchoolUser> findAllByDesignation(String designation);

	SchoolUser findByPhonenumber(String phonenumber);

}
