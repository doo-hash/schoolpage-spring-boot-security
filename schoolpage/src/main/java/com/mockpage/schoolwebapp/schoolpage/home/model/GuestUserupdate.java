package com.mockpage.schoolwebapp.schoolpage.home.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class  GuestUserupdate{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "^[a-zA-Z\s]{2,40}",message="Must contain only letters.")
	@NotBlank(message = "Firstname cannot be empty")
	@Size(min=2, message = "Firstname must be more than 2 characters.")
	private String firstName;
	
	@Pattern(regexp = "^[a-zA-Z\s]{2,40}",message="Must contain only letters.")
	@NotBlank(message = "Lastname cannot be empty.")
	@Size(min=2,message = "Lastname cannot be less than 2 characters.")
	private String lastName;
	
	@NotBlank(message="Phone number cannot be empty.")
	@Pattern(regexp = "^[0-9-]{12}", message = "Must contain only numbers.")
	@Size(min = 10, message = "Phone number cannot be less than 10 characters.")
	private String phonenumber;
	
	@NotEmpty(message = "Email is Mandatory")
	@Email(message = "Invalid email")
	private String email;
	
	@NotEmpty(message = "user Id cannot be empty")
	private String userId;
		
	@Lob
	@NotBlank(message = "Education details cannot be empty")
	@Size(min=10,message = "Education details cannot be less than 10 characters")
	private String education;
	
	@Lob
	private String description;

	public GuestUserupdate() {
	}

	public GuestUserupdate(
			@Pattern(regexp = "^[a-zA-Z ]{2,40}", message = "Must contain only letters.") @NotBlank(message = "Firstname cannot be empty") @Size(min = 2, message = "Firstname must be more than 2 characters.") String firstName,
			@Pattern(regexp = "^[a-zA-Z ]{2,40}", message = "Must contain only letters.") @NotBlank(message = "Lastname cannot be empty.") @Size(min = 2, message = "Lastname cannot be less than 2 characters.") String lastName,
			@NotBlank(message = "Phone number cannot be empty.") @Pattern(regexp = "^[0-9-]{12}", message = "Must contain only numbers.") @Size(min = 10, message = "Phone number cannot be less than 10 characters.") String phonenumber,
			@NotEmpty(message = "Email is Mandatory") @Email(message = "Invalid email") String email,
			@NotEmpty(message = "user Id cannot be empty") String userId,
			@NotBlank(message = "Education details cannot be empty") @Size(min = 10, message = "Education details cannot be less than 10 characters") String education,
			String description) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.userId = userId;
		this.education = education;
		this.description = description;
	}



	@Override
	public String toString() {
		return "GuestUserupdate [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", phonenumber="
				+ phonenumber + ", email=" + email + ", userId=" + userId + ", education=" + education + ", "
						+ "description=" + description + "]";
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
