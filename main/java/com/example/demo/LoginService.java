package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository lr;
	
	public void addLogin(Login l) {
		lr.save(l);
	}
	
	public List<Login> getLogins() {
		List<Login> llist = new ArrayList<>();
		lr.findAll().forEach(llist::add);
		return llist;
	}

}
