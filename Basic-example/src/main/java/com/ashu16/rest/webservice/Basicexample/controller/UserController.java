package com.ashu16.rest.webservice.Basicexample.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
	
	@GetMapping("/getusers")
	public List<User> getAllUsers(){
		return userDao.getAllUsers();
	}
	
	@GetMapping(path = "/getuser/{id}")
	public EntityModel<User> getallUserById(@PathVariable String id){
		 User user = userDao.getUser(Integer.parseInt(id));
		EntityModel<User> entityModel = EntityModel.of(user);
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).getAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
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
