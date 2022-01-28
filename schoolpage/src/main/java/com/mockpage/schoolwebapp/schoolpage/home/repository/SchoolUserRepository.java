package com.mockpage.schoolwebapp.schoolpage.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolUser;

@Repository
public interface SchoolUserRepository extends JpaRepository<SchoolUser,Long> {

	boolean existsByUserId(String userId);

	boolean existsByFirstName(String firstName);

	boolean existsByLastName(String lastName);

	boolean existsByEmail(String email);

	SchoolUser findByUserId(String userId);

	SchoolUser findByEmail(String email);

	SchoolUser findByLastName(String lastName);

	SchoolUser findByFirstName(String firstName);

	List<SchoolUser> findAllByDesignation(String designation);

	SchoolUser findByPhoneNumber(String phoneNumber);

}
