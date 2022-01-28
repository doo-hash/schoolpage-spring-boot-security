package com.mockpage.schoolwebapp.schoolpage.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Name cannot be empty")
	@Size(min=2, message = "Name must be more than 2 characters")
	private String name;
	@NotBlank(message = "Subject cannot be empty")
	private String subject;
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "Invalid email")
	private String email;
	@NotBlank(message = "feedback cannot be empty")
	private String feedback_message;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public String getFeedback_message() {
		return feedback_message;
	}

	public void setFeedback_message(String feedback_message) {
		this.feedback_message = feedback_message;
	}


	public Feedback() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Feedback [name=" + name + ", subject=" + subject + ", email=" + email + ", feedback_message="
				+ feedback_message + "]";
	}

	public Feedback(
			@NotBlank(message = "Name cannot be empty") @Size(min = 2, message = "Name must be more than 2 characters") String name,
			@NotBlank(message = "Subject cannot be empty") String subject,
			@NotEmpty(message = "Email is Mandatory") @Email(message = "Invalid email") String email,
			@NotBlank(message = "feedback cannot be empty") String feedback_message) {
		super();
		this.name = name;
		this.subject = subject;
		this.email = email;
		this.feedback_message = feedback_message;
	}

	

}
