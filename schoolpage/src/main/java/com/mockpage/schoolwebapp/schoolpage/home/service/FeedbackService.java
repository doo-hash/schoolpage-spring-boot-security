package com.mockpage.schoolwebapp.schoolpage.home.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mockpage.schoolwebapp.schoolpage.home.model.Feedback;
import com.mockpage.schoolwebapp.schoolpage.home.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepo;

	public Iterable<Feedback> findAll(){
		Iterable<Feedback> feedback = feedbackRepo.findAll();
		return feedback;
	}
}
