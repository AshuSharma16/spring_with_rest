package com.inmemory.db.rest.webservice.userdetails.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

/*@Entity
@Table(name="POST")*/
public class Post {
	
	
	private int postId;
	
	private String description;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Post(int postId, String description) {
		super();
		this.postId = postId;
		this.description = description;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", description=" + description + "]";
	}

	public Post() {
		super();
	}
	
	

}
