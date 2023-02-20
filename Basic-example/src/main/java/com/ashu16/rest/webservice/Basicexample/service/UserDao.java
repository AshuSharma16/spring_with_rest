package com.ashu16.rest.webservice.Basicexample.service;

import java.util.List;

import com.ashu16.rest.webservice.Basicexample.bean.User;

public interface UserDao {

	public List<User> getAllUsers();

	public User saveUser(User user);

	public User getUser(int id);

}
