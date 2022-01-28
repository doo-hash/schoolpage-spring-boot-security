package com.mockpage.schoolwebapp.schoolpage.home.repository;

import org.springframework.data.repository.CrudRepository;

import com.mockpage.schoolwebapp.schoolpage.home.model.Feedback;

public interface FeedbackRepository extends CrudRepository<Feedback, Long>{}
