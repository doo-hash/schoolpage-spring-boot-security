package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;

public interface IAdminService {

	
	public List<Adminupdate> findAll();
	
	public Adminupdate findByAdminId(String adminid);
	
	public Adminupdate findByEmail(String email);

	public void update(Adminupdate adminupdate);
}
