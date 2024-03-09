package com.hotel_reservation;

public class Booking {
	private int id;
	private String name;
	private String packages;
	private String arrival;
	private String depature;
	
	public Booking(int id, String name, String packages, String arrival, String depature) {
		this.id = id;
		this.name = name;
		this.packages = packages;
		this.arrival = arrival;
		this.depature = depature;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public String getPackages() {
		return packages;
	}

	public String getArrival() {
		return arrival;
	}

	public String getDepature() {
		return depature;
	}
	
	

}
