package com.inmemory.db.rest.webservice.userdetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmemory.db.rest.webservice.userdetails.beans.UserBean;
import com.inmemory.db.rest.webservice.userdetails.dao.UserDetailsRepository;

@Service
public class UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	public UserBean createUserResource(UserBean user) {
		UserBean userSavedBean = userDetailsRepository.save(user);
		return userSavedBean;
		
		
	}

}
