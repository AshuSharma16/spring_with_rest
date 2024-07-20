package com.inmemory.db.rest.webservice.userdetails.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inmemory.db.rest.webservice.userdetails.beans.Post;
import com.inmemory.db.rest.webservice.userdetails.beans.UserBean;
import com.inmemory.db.rest.webservice.userdetails.service.PostService;
import com.inmemory.db.rest.webservice.userdetails.service.UserDetailsService;

@RestController
public class UserDetailsController {

	@Autowired
	private UserDetailsService userService;
	
	@Autowired
	private PostService postService;

	@PostMapping(path = "/v2/saveuser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserBean> saveUser(@RequestBody UserBean user) {
		UserBean saveUser = userService.createUserResource(user);
		System.out.println("createUserResource : " + saveUser);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(saveUser.getUserId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping(path = "/v2/getuser/{id}")
	public UserBean fetchuserById(@PathVariable String id) {
		return userService.getUserById(id);

	}
	
	@GetMapping(path = "/v2/getuser/{id}/post")
	public List<Post> fetchPostBasedOnUserById(@PathVariable String id) {
		return userService.getUserPost(id);

	}
	
	@PostMapping(path = "/v2/user/{id}/post", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> createPostForUser(@PathVariable String id , @RequestBody Post post) {
		
		Post createdPost = postService.createPostForUserBasdonUserId(id, post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(createdPost.getPostId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
}
