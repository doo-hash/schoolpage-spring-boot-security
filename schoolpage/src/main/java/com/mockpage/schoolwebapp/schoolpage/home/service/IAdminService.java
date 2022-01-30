package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import com.mockpage.schoolwebapp.schoolpage.home.model.Adminupdate;

public interface IAdminService {

	
	public List<Adminupdate> findAll();

	public void update(Adminupdate adminupdate);
}
