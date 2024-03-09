package com.hotel_reservation;

public class Feedback {
	
	private int id;
	private String name;
	private String feedback;

	public Feedback(int id, String name, String feedback) {
		this.id = id;
		this.name = name;
		this.feedback = feedback;
		
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getFeedback() {
		return feedback;
	}
	

}
