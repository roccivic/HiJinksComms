package com.hijinks.comms.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Community {
	int id;
	String name;
	User owner;
	String keywords;
	String description;
	boolean keywordsEnabled;
	String visibilityLevel;
	String accessLevel;
	Timestamp created;

	public Community(int id, String name, User owner, String keywords,
			String description, boolean keywordsEnabled,
			String visibilityLevel, String accessLevel,Timestamp created) {
		this.id = id;
		this.name = name;
		this.owner = owner;
		this.keywords = keywords;
		this.description = description;
		this.keywordsEnabled = keywordsEnabled;
		this.visibilityLevel = visibilityLevel;
		this.accessLevel = accessLevel;
		this.created = created;
	}
	
	public Community() {}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getKeywords() {
		return keywords;
	}
	
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public boolean isKeywordsEnabled() {
		return keywordsEnabled;
	}
	public void setKeywordsEnabled(boolean keywordsEnabled) {
		this.keywordsEnabled = keywordsEnabled;
	}
	
	public String getVisibilityLevel() {
		return visibilityLevel;
	}
	
	public void setVisibilityLevel(String visibilityLevel) {
		this.visibilityLevel = visibilityLevel;
	}
	
	public String getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(String accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public Timestamp getCreated() {
		return created;
	}

	public String getCreatedFormatted() {
		return new SimpleDateFormat("dd MMM yyyy").format(created);
	}
	
	public String getCreatedLongFormatted() {
		return new SimpleDateFormat("HH:mm dd MMM yyyy").format(created);
	}

	public void setCreated(Timestamp timestamp) {
		this.created = timestamp;
	}
	
}
