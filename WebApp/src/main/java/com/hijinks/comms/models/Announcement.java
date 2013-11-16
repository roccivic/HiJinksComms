package com.hijinks.comms.models;

import java.util.Date;

public class Announcement {
	int id;
	String title;
	String text;
	int community;
	Date date;
	int createdBy;
	
	public Announcement(int id, String title, String text, int community,
			Date date, int createdBy) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.community = community;
		this.date = date;
		this.createdBy = createdBy;
	}
	
	public Announcement() {}
	
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

	public int getCommunity() {
		return community;
	}

	public void setCommunity(int community) {
		this.community = community;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(int createdBy) {
		this.createdBy = createdBy;
	}

}
