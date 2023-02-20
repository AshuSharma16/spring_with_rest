package com.ashu16.rest.webservice.Basicexample.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ashu16.rest.webservice.Basicexample.bean.User;
import com.ashu16.rest.webservice.Basicexample.exception.UserNotFoundException;

@Service
public class UserDaoImpl implements UserDao {

	@Override
	public List<User> getAllUsers() {
		return prepareUserList();
	}

	private List<User> prepareUserList() {
		User user1 = new User(101, "ashu", LocalDate.of(1985, 02, 16));
		User usr2 = new User(102, "ram", LocalDate.of(2000, 02, 16));
		User user3 = new User(103, "karan", LocalDate.of(1992, 12, 26));
		User user4 = new User(104, "hari", LocalDate.of(1981, 11, 12));
		User user5 = new User(105, "puja", LocalDate.of(1983, 06, 23));
		User user6 = new User(106, "Rohan", LocalDate.now().minusYears(25));
		
		return Arrays.asList(user1, user3, user4, user5, usr2, user6);
		
	}

	@Override
	public User saveUser(User user) {
		User newUser = null;
		if(Objects.nonNull(user)) {
			 newUser = new User(user.getId(), user.getName(), user.getBirthDate());
		}
		return newUser;
	}

	@Override
	public User getUser(int id) {
		User user = null;
		List<User> prepareUserList = prepareUserList();
		Optional<User> findFirst = prepareUserList.stream().filter(ob -> ob.getId()==id).findFirst();
		if(findFirst.isPresent()) {
			user = findFirst.get();
		}else {
			throw new UserNotFoundException("Data not found for given user id :"+ id);
		}
		
		return user;
	}

}
