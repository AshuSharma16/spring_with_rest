package com.inmemory.db.rest.webservice.userdetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inmemory.db.rest.webservice.userdetails.beans.UserBean;
import com.inmemory.db.rest.webservice.userdetails.service.UserDetailsService;

@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@PostMapping(path="/v2/saveuser" , consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserBean saveUser(@RequestBody UserBean user) {
	UserBean createUserResource = userDetailsService.createUserResource(user);
	return createUserResource;
	}
}
