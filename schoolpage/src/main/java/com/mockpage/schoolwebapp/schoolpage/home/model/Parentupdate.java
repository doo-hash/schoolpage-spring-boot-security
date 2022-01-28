package com.mockpage.schoolwebapp.schoolpage.home.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Parentupdate {

	@Id
	private long id;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Firstname cannot be empty")
	@Size(min=2, message = "Firstname must be more than 2 characters")
	private String firstName;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Lastname cannot be empty")
	@Size(min=2,message = "Lastname cannot be less than 2 characters")
	private String lastName;
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters")
	@NotBlank(message = "Student name cannot be empty")
	@Size(min=2,message = "Student name cannot be less than 2 characters")
	private String studentName;
	@Pattern(regexp = "^[a-zA-Z0-9_-]{2,40}",message="Invalid Characters")
	@NotEmpty(message = "Student Id cannot be empty")
	private String studentId;
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
			message="Invalid email address")
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "Invalid email")
	private String email;

	public Parentupdate() {
	}


	@Override
	public String toString() {
		return "Parentupdate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", studentName="
				+ studentName + ", studentId=" + studentId + ", email=" + email + "]";
	}


	public Parentupdate(long id,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Firstname cannot be empty") @Size(min = 2, message = "Firstname must be more than 2 characters") String firstName,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Lastname cannot be empty") @Size(min = 2, message = "Lastname cannot be less than 2 characters") String lastName,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters") @NotBlank(message = "Student name cannot be empty") @Size(min = 2, message = "Student name cannot be less than 2 characters") String studentName,
			@Pattern(regexp = "^[a-zA-Z0-9_-]{2,40}", message = "Invalid Characters") @NotEmpty(message = "Student Id cannot be empty") String studentId,
			@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address") @NotEmpty(message = "Email is Mandatory") @Email(message = "Invalid email") String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.studentName = studentName;
		this.studentId = studentId;
		this.email = email;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
