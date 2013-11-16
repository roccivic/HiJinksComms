package com.hijinks.comms.models;

import java.util.Date;

public class Invitation {
	int id;
	int community;
	int invitedBy;
	int invitee;
	Date date;
	
	public Invitation(int community, int invitedBy, int invitee,
			Date date) {
		this.community = community;
		this.invitedBy = invitedBy;
		this.invitee = invitee;
		this.date = date;
	}
	
	public Invitation(){}
	
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

	public int getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(int invitedBy) {
		this.invitedBy = invitedBy;
	}

	public int getInvitee() {
		return invitee;
	}

	public void setInvitee(int invitee) {
		this.invitee = invitee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
