package com.mockpage.schoolwebapp.schoolpage.home.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "school_users", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class  SchoolUser{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "first_name",nullable = false)
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters.")
	@NotBlank(message = "Firstname cannot be empty.")
	@Size(min=2, message = "Firstname must be more than 2 characters.")
	private String firstName;
	
	@Column(name = "last_name",nullable = false)
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters.")
	@NotBlank(message = "Lastname cannot be empty.")
	@Size(min=2,message = "Lastname cannot be less than 2 characters.")
	private String lastName;
	
	@Column(name = "user_email",nullable = false)
	@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$",
			message="Invalid email address.")
	@NotEmpty(message = "Email is Mandatory.")
	@Email(message = "Invalid email.")
	private String email;
	
	@Column(name = "user_phonenumber",nullable = false)
	@Pattern(regexp = "^[0-9-]{10,12}",
			message="Invalid Phone address.")
	@NotEmpty(message = "Phone Number is Mandatory.")
	@Size(min = 10,max = 12,message = "Must contain only 10 numbers.")
	private String phoneNumber;

	
	@Column(name = "user_id",nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9_-]{2,40}",message="User Id must not contain special characters.")
	@NotEmpty(message = "User Id cannot be empty.")
	private String userId;
	
	@Column(name = "user_designation",nullable = false)
	@Pattern(regexp = "^[a-zA-Z_\s]{2,40}",message="Must contain only letters.")
	@NotEmpty(message = "Designation cannot be empty.")
	private String designation;
	
	@Column(name = "password",nullable = false)
	@NotBlank(message = "Passowrd cannot be empty.")
	private String password;
	
	@ManyToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "user_roles",
			joinColumns =  @JoinColumn(
					name = "user_uid", referencedColumnName = "id"),
			inverseJoinColumns =  @JoinColumn(
					name = "role_uid", referencedColumnName = "id")
			)
	private Collection<Roles> roles;
	
	@Column(name = "check_terms")
	@AssertTrue(message="Please check this before you proceed")
	private boolean checked;

	public SchoolUser() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<Roles> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Roles> roles) {
		this.roles = roles;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	@Override
	public String toString() {
		return "SchoolUser [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", userId=" + userId + ", designation=" + designation + ", password=" + password
				+ ", roles=" + roles + ", checked=" + checked + "]";
	}

	public SchoolUser(
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters.") @NotBlank(message = "Firstname cannot be empty.") @Size(min = 2, message = "Firstname must be more than 2 characters.") String firstName,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters.") @NotBlank(message = "Lastname cannot be empty.") @Size(min = 2, message = "Lastname cannot be less than 2 characters.") String lastName,
			@Pattern(regexp = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$", message = "Invalid email address.") @NotEmpty(message = "Email is Mandatory.") @Email(message = "Invalid email.") String email,
			@Pattern(regexp = "^[0-9-]{10,12}", message = "Invalid Phone address.") @NotEmpty(message = "Phone Number is Mandatory.") @Size(min = 10, max = 12, message = "Must contain only 10 numbers.") String phoneNumber,
			@Pattern(regexp = "^[a-zA-Z0-9_-]{2,40}", message = "User Id must not contain special characters.") @NotEmpty(message = "User Id cannot be empty.") String userId,
			@Pattern(regexp = "^[a-zA-Z_ ]{2,40}", message = "Must contain only letters.") @NotEmpty(message = "Designation cannot be empty.") String designation,
			@NotBlank(message = "Passowrd cannot be empty.") String password,
			Collection<Roles> roles, @AssertTrue(message = "Please check this before you proceed") boolean checked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.userId = userId;
		this.designation = designation;
		this.password = password;
		this.roles = roles;
		this.checked = checked;
	}


}
