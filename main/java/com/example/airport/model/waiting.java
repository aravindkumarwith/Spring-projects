package com.example.airport.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class waiting {
	@org.springframework.data.annotation.Id
	private int order;
	private int flightno;
	private String email;
	private String username;
	
	
	private String Seat;
	
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
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
	public int getFlightno() {
		return flightno;
	}
	public void setFlightno(int flightno) {
		this.flightno = flightno;
	}
	
	public String getSeat() {
		return Seat;
	}
	public void setSeat(String seat) {
		Seat = seat;
	}

}
