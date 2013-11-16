package com.hijinks.comms.models;

public class User {
	int id;
	String fname;
	String lname;
	String email;
	String type;
	
	public User(int id, String fname, String lname, String email, String type) {
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.type = type;
	}
	
	public User() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
