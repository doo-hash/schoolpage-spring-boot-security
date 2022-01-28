package com.mockpage.schoolwebapp.schoolpage.home.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;

public interface ArticleRepository extends CrudRepository<SchoolArticles, Long>{

	public  Optional<SchoolArticles> findById(Long Id);
	
}
