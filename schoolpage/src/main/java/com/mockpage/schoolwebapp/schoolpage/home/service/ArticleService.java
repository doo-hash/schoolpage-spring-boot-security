package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;

@Service
public interface ArticleService {	
 
	 public Optional<SchoolArticles> getById(Long Id);
	 
	 public Iterable<SchoolArticles> findAll();

	 public void saveAll();
}
