package com.mockpage.schoolwebapp.schoolpage.home.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.GuestUserupdate;

@Repository
public interface GuestUserRepository extends JpaRepository<GuestUserupdate,Long> {

	boolean existsByUserId(String userId);

	boolean existsByFirstName(String firstName);

	boolean existsByLastName(String lastName);

	boolean existsByEmail(String email);

	GuestUserupdate findByUserId(String userId);

	GuestUserupdate findByEmail(String email);

	GuestUserupdate findByLastName(String lastName);

	GuestUserupdate findByFirstName(String firstName);
		
	GuestUserupdate findByPhonenumber(String phonenumber);

}
