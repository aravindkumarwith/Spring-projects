package com.example.airport.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document

public class airlines {

	@org.springframework.data.annotation.Id
	
	private int flight_no;
	private String from;
	private String to;
	private String Date;
	private String depart;
	private String arrival;
	private String avai_econnomyseats;
	private String avai_businessseats;
	private String image;
	
	public int getFlight_no() {
		return flight_no;
	}
	public void setFlight_no(int flight_no) {
		this.flight_no = flight_no;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDepart() {
		return depart;
	}
	public void setDepart(String depart) {
		this.depart = depart;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getAvai_econnomyseats() {
		return avai_econnomyseats;
	}
	public void setAvai_econnomyseats(String avai_econnomyseats) {
		this.avai_econnomyseats = avai_econnomyseats;
	}
	public String getAvai_businessseats() {
		return avai_businessseats;
	}
	public void setAvai_businessseats(String avai_businessseats) {
		this.avai_businessseats = avai_businessseats;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	

	
	

	
	


	
}
