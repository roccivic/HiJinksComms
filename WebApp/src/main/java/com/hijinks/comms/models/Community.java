package com.hijinks.comms.models;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Length.List;

public class Community {
	int id;
	@List({
	    @Length(min = 1, message = "The name must be at least 1 character long"),
	    @Length(max = 30, message = "The name must be less than 31 characters long")
	})
	String name;
	User owner;
	@Length(max = 101, message = "The keywords field must be less than 101 characters long")
	String keywords;
	@List({
	    @Length(min = 1, message = "The description must be at least 1 character long"),
	    @Length(max = 101, message = "The description must be less than 101 characters long")
	})
	String description;
	@NotNull(message="Please, specify if you want to enable or disable keywords")
	boolean keywordsEnabled;
	@NotNull(message="Please, specify visibility level")
	String visibilityLevel;
	@NotNull(message="Please, specify access level")
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
		this.keywords = keywords.replace(",", " ");
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
