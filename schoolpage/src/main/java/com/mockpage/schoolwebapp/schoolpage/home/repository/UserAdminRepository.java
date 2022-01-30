package com.mockpage.schoolwebapp.schoolpage.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;

@Repository
public interface UserAdminRepository extends JpaRepository<Adminupdate,Long> {

	boolean existsByAdminId(String adminId);

	boolean existsByFirstName(String firstName);

	boolean existsByLastName(String lastName);


	Adminupdate findByAdminId(String adminId);

	Adminupdate findByEmail(String email);

	Adminupdate findByLastName(String lastName);

	Adminupdate findByFirstName(String firstName);

	List<Adminupdate> findAllByDesignation(String designation);

	Adminupdate findByPhonenumber(String phonenumber);

}
