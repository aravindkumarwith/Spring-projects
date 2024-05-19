package com.example.airport.model;

import org.springframework.data.mongodb.core.mapping.Document;



@Document
public class Register {
 
	@org.springframework.data.annotation.Id
	
	private String email;
	private String username;
	
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
