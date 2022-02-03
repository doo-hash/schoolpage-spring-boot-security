package com.mockpage.schoolwebapp.schoolpage.home;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mockpage.schoolwebapp.schoolpage.home.repository.AdmissionsRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.CoursesRepository;
import com.mockpage.schoolwebapp.schoolpage.home.repository.RoleRepository;

@SpringBootApplication
public class SchoolpageApplication {
	
	private static final Logger log = LoggerFactory.getLogger(SchoolpageApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SchoolpageApplication.class, args);
	}
	
	@Bean
	  public CommandLineRunner demo(AdmissionsRepository admissionsrepo,CoursesRepository coursesrepo,RoleRepository roleRepo) {
	    return (args) -> {
			
			/*
			 * admissionsrepo.save(new
			 * Admissions("Languages","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Science","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Mathematics","John",LocalDate.parse("2022-01-05"),LocalDate.parse
			 * ("2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Arts","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Chemistry","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Social","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("English","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Physics","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100)); admissionsrepo.save(new
			 * Admissions("Biology","John",LocalDate.parse("2022-01-05"),LocalDate.parse(
			 * "2023-01-03"),200,100,100));
			 * 
			 * 
			 * coursesrepo.save(new Courses("course-1",10,(long) 1,"Languages",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 2,"Science",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 3,"Mathematics",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 4,"Arts",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 5,"Chemistry",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 6,"Social",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 7,"English",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 8,"Physics",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * )); coursesrepo.save(new Courses("course-1",10,(long) 9,"Biology",
			 * "Jackson","Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing. Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS. Loremipsum dolor sit amet consectetur adipisicing elit Vel accusantium impediS."
			 * ));
			 */ 
			/*
			 * roleRepo.save(new Role("ADMIN")); roleRepo.save(new Role("TEACHER"));
			 * roleRepo.save(new Role("PARENT"));roleRepo.save(new Role("USER"));
			 * 
			 */			 
	      
	      log.info("Admissions and Courses are added.");
	    };
	  }

}

