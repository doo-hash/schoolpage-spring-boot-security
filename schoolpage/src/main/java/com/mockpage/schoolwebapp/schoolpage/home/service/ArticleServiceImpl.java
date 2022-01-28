package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mockpage.schoolwebapp.schoolpage.home.model.SchoolArticles;
import com.mockpage.schoolwebapp.schoolpage.home.repository.ArticleRepository;

@Component
public class ArticleServiceImpl implements ArticleService{

	private final ArticleRepository ArticleRepo;
	
	
    @Autowired
    public ArticleServiceImpl(ArticleRepository ArticleRepo) {
        this.ArticleRepo = ArticleRepo;
    }
	@Override
	public Optional<SchoolArticles> getById(Long Id) {
		Optional<SchoolArticles> article = ArticleRepo.findById(Id);
		return article;
	}

	@Override
	public void saveAll() {	
		try {
			ObjectMapper mapper = new ObjectMapper();
			List<SchoolArticles> schoolArticles = Arrays.asList(mapper.readValue(Paths.get("articles.json").toFile(), SchoolArticles[].class));
			if(schoolArticles.isEmpty()) {
				throw new NullPointerException("it is empty");
			}
			ArticleRepo.saveAll(schoolArticles);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public Iterable<SchoolArticles> findAll() {
		Iterable<SchoolArticles> blogArticles = ArticleRepo.findAll();		
		return blogArticles;
	}

}
