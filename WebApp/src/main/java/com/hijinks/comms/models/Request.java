package com.hijinks.comms.models;

import java.util.Date;

public class Request {
	Community community;
	User user;
	Date date;
	
	public Request(Community community, User user, Date date) {
		this.community = community;
		this.user = user;
		this.date = date;
	}
	
	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}

