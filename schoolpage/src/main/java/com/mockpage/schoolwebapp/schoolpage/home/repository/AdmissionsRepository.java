package com.mockpage.schoolwebapp.schoolpage.home.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mockpage.schoolwebapp.schoolpage.home.model.Admissions;

@Repository
public interface AdmissionsRepository extends CrudRepository<Admissions, Long>{
}
