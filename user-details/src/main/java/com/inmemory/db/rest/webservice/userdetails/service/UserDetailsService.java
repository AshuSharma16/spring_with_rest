package com.inmemory.db.rest.webservice.userdetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inmemory.db.rest.webservice.userdetails.beans.Post;
import com.inmemory.db.rest.webservice.userdetails.beans.UserBean;
import com.inmemory.db.rest.webservice.userdetails.dao.UserDetailsRepository;
import com.inmemory.db.rest.webservice.userdetails.service.utilty.UserNotFoundException;

@Service
public class UserDetailsService {
	
	@Autowired
	private UserDetailsRepository userRepo;

	public UserBean createUserResource(UserBean user) {
		UserBean userSavedBean = userRepo.save(user);
		return userSavedBean;
		
		
	}
	
	public UserBean getUserById(String id) {
		Optional<UserBean> userDetails = userRepo.findById(Integer.parseInt(id));
		if(userDetails.isPresent()) {
			return userDetails.get();
		}else {
			throw new UserNotFoundException("User not found for given id : "+ id);
		}
	}
	
	public List<Post> getUserPost(String id) {
		Optional<UserBean> userDetails = userRepo.findById(Integer.parseInt(id));
		if(userDetails.isPresent()) {
			return userDetails.get().getPost();
		}else {
			throw new UserNotFoundException("User not found for given id : "+ id);
		}
	}

}
