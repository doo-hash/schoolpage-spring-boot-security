package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import com.mockpage.schoolwebapp.schoolpage.home.model.GuestUserupdate;

public interface IGuestUserService {

	
	public List<GuestUserupdate> findAll();

	public void update(GuestUserupdate GuestUserupdate);
}
