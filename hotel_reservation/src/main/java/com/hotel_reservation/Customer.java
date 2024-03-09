package com.hotel_reservation;

public class Customer {
	
	private int id;
	private String firstname;
	private String lastname;	
	private String NIC;
	private String email;
	private String phone;
	private String username;
	private String password;
	
	public Customer(int id, String firstname, String lastname, String nIC, String email, String phone, String username,
			String password) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		NIC = nIC;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}



	public String getFirstname() {
		return firstname;
	}

	

	public String getLastname() {
		return lastname;
	}

	
	public String getNIC() {
		return NIC;
	}

	

	public String getEmail() {
		return email;
	}

	

	public String getPhone() {
		return phone;
	}

	

	public String getUsername() {
		return username;
	}


	public String getPassword() {
		return password;
	}

	

}
