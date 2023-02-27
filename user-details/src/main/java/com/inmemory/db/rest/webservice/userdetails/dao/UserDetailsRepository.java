package com.inmemory.db.rest.webservice.userdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmemory.db.rest.webservice.userdetails.beans.UserBean;

//@Repository
public interface UserDetailsRepository extends JpaRepository<UserBean, Integer>{

}
