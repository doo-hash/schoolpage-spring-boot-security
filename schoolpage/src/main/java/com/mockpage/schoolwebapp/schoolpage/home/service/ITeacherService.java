package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import com.mockpage.schoolwebapp.schoolpage.home.model.Teacherupdate;

public interface ITeacherService {

	
	public List<Teacherupdate> findAll();

	public void update(Teacherupdate Teacherupdate);

	public Teacherupdate findByEmail(String email);

	public Teacherupdate findByTeacherId(String teacherid);
}
