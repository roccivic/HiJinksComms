package com.hijinks.comms.models;

import java.util.Date;

public class Request {
	int id;
	int community;
	int user;
	Date date;
	
	public Request(int community, int user, Date date) {
		this.community = community;
		this.user = user;
		this.date = date;
	}
	
	public Request() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getCommunity() {
		return community;
	}

	public void setCommunity(int community) {
		this.community = community;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

