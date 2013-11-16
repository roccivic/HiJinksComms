package com.hijinks.comms.models;

import java.util.Date;

public class Invitation {
	Community community;
	User invitedBy;
	User invitee;
	Date date;
	
	public Invitation(Community community, User invitedBy, User invitee,
			Date date) {
		this.community = community;
		this.invitedBy = invitedBy;
		this.invitee = invitee;
		this.date = date;
	}
	
	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

	public User getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(User invitedBy) {
		this.invitedBy = invitedBy;
	}

	public User getInvitee() {
		return invitee;
	}

	public void setInvitee(User invitee) {
		this.invitee = invitee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
