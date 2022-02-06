package com.mockpage.schoolwebapp.schoolpage.home.service;

import java.util.List;

import com.mockpage.schoolwebapp.schoolpage.home.model.Parentupdate;

public interface IParentService {

	
	public List<Parentupdate> findAll();

	public void update(Parentupdate parentupdate);

	public Parentupdate findByParentId(String parentid);

	public Parentupdate findByEmail(String email);
}
