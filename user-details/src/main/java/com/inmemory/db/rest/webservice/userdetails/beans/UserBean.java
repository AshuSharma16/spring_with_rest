package com.inmemory.db.rest.webservice.userdetails.beans;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity()
@Table(name = "USER_DETAILS")
public class UserBean {

	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "birth_date")
	private String birthDate;

	@Column(name ="post")
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Post> post;
	
	
	public UserBean(int userId, String userName, String birthDate, List<Post> post) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthDate = birthDate;
		this.post = post;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public UserBean(int userId, String userName, String birthDate) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.birthDate = birthDate;
	}

	public UserBean() {
		super();
	}

	@Override
	public String toString() {
		return "UserBean [userId=" + userId + ", userName=" + userName + ", birthDate=" + birthDate + "]";
	}

}
