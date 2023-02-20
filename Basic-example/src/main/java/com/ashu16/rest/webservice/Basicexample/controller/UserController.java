package com.ashu16.rest.webservice.Basicexample.controller;

import java.net.URI;
import java.util.List;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ashu16.rest.webservice.Basicexample.bean.User;
import com.ashu16.rest.webservice.Basicexample.service.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;;
	
	@GetMapping(path = "/getusers")
	public List<User> getallUsers(){
		return userDao.getAllUsers();
	}
	
	@GetMapping(path = "/getuser/{id}")
	public User getallUserById(@PathVariable String id){
		return userDao.getUser(Integer.parseInt(id));
	}
	
	@PostMapping(path = "/saveuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user){
		User saveUser = userDao.saveUser(user);
		//return new  ResponseEntity<User>(saveUser, HttpStatus.CREATED);  // IN AIUT
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(saveUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
