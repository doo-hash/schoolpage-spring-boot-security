package com.mockpage.schoolwebapp.schoolpage.home.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;


@Entity
public class SchoolArticles {

	@Id
	@SequenceGenerator(name="articleseqgen", sequenceName="articleseq", initialValue=1, allocationSize=20)
	@GeneratedValue(generator = "articleseqgen")
	private long id;
	private String title;
	private String author;
	private String department;
	private String profession;
	private String content_title;
	@Lob
	private String description;
	
	private String published_date;

	protected SchoolArticles() {}
	
	public SchoolArticles(String title, String author, String department, String profession, String content_title,
			String description, String published_date) {
		super();
		this.title = title;
		this.author = author;
		this.department = department;
		this.profession = profession;
		this.content_title = content_title;
		this.description = description;
		this.published_date = published_date;
	}

	public String getTitle() {
		return title;
	}
	@Override
	public String toString() {
		return "SchoolArticles [id=" + id + ", title=" + title + ", author=" + author + ", department=" + department
				+ ", profession=" + profession + ", content_title=" + content_title + ", description=" + description
				+ ", published_date=" + published_date + "]";
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getContent_title() {
		return content_title;
	}
	public void setContent_title(String content_title) {
		this.content_title = content_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublished_date() {
		return published_date;
	}
	public void setPublished_date(String published_date) {
		this.published_date = published_date;
	}
	public long getId() {
		return id;
	}
}
