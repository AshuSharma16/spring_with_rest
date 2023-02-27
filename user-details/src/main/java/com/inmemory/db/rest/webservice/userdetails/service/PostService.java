package com.inmemory.db.rest.webservice.userdetails.service;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmemory.db.rest.webservice.userdetails.beans.Post;
import com.inmemory.db.rest.webservice.userdetails.beans.UserBean;
import com.inmemory.db.rest.webservice.userdetails.dao.PostRepository;
import com.inmemory.db.rest.webservice.userdetails.dao.UserDetailsRepository;
import com.inmemory.db.rest.webservice.userdetails.service.utilty.UserNotFoundException;

@Service
public class PostService {

	@Autowired
	PostRepository repository;
	
	@Autowired
	UserDetailsRepository userRepository;
	
	public Post createPostForUserBasdonUserId(String id, Post post) {
		UserBean userBean = null;
		Post savedPost = null;
		Optional<UserBean> userDetails = userRepository.findById(Integer.parseInt(id));
		if(userDetails.isPresent()) {
			 userBean= userDetails.get();
			 post.setUser(userBean);
			  savedPost= repository.save(post);
		}else {
			throw new UserNotFoundException("user not found"+id);
		}
	
		return savedPost;
	}
}
