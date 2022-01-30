package com.mockpage.schoolwebapp.schoolpage.home.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.mockpage.schoolwebapp.schoolpage.home.service.ISchoolUserService;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private ISchoolUserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Autowired
	private SimpleAuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/","/home","/home/register","/home/register?success","/js/**","/css/**","/images/**")
		.permitAll()
		.antMatchers("/home/about","/home/admissions",
				"/home/news","/home/guidance","/home/employment",
				"/home/blog","/home/academics/courses","/home/academics/departments",
				"/home/calendar","/home/team","/home/contactus","/home/contactus/save",
				"/home/activities","/home/blog/article/**",
				"/home/news/articles/**",
				"/home/register/save","/home/login/auth_user",
				"https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s")
		.permitAll()
		.antMatchers("/home/admin/**","/home/admin/edit**").hasAuthority("ADMIN")
		.antMatchers("/home/teacher/**")
		.hasAuthority("TEACHER")
		.antMatchers("/home/parent/**")
		.hasAuthority("PARENT")
		.antMatchers("/home/user/**")
		.hasAuthority("USER")
		.anyRequest().authenticated()
		.and().formLogin()
		.loginPage("/home/login")
		.loginProcessingUrl("/home/login/auth_user")
		.failureUrl("/home/login?error")
		.successHandler(successHandler)
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/home/user/logout"))
		.logoutSuccessUrl("/home/login?logout")
		.permitAll();
	}

}
