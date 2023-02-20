package com.ashu16.rest.webservice.Basicexample.bean;

import java.time.LocalDate;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class User {
	private int id;

	@Size(min = 2 , max = 7 , message = "Name should have minmum 2 char and max 7 char " )
	private String name;

	@Past(message = "date of birth must be past date")
	private LocalDate birthDate;

	public User(int id, String name, LocalDate birthDate) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", birthDate=" + birthDate + "]";
	}

}
