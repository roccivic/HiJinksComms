package com.hijinks.comms.models;

import java.util.Date;

public class Announcement {
	int id;
	String title;
	String text;
	Community community;
	Date date;
	User createdBy;
	
	public Announcement(int id, String title, String text, Community community,
			Date date, User createdBy) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.community = community;
		this.date = date;
		this.createdBy = createdBy;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

}
