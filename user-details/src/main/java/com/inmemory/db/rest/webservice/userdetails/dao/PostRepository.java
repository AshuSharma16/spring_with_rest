package com.inmemory.db.rest.webservice.userdetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inmemory.db.rest.webservice.userdetails.beans.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {

}
