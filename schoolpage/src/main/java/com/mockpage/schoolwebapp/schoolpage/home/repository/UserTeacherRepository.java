package com.mockpage.schoolwebapp.schoolpage.home.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;

@Repository
public interface UserTeacherRepository extends JpaRepository<Teacherupdate,Long> {

	boolean existsByTeacherId(String teacherid);

	boolean existsByFirstName(String firstName);

	boolean existsByLastName(String lastName);

	boolean existsByEmail(String email);

	Teacherupdate findByTeacherId(String teacherId);

	Teacherupdate findByEmail(String email);

	Teacherupdate findByLastName(String lastName);

	Teacherupdate findByFirstName(String firstName);

	List<Teacherupdate> findAllByDesignation(String designation);

	Teacherupdate findByPhonenumber(String phonenumber);

}
