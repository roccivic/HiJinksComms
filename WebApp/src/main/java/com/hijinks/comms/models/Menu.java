package com.hijinks.comms.models;

public class Menu {
	public int newestCommunities;
	public int communitiesYouOwn;
	public int communitiesYouArePartOf;
	public int requests;
	public int getNewestCommunities() {
		return newestCommunities;
	}
	public void setNewestCommunities(int newestCommunities) {
		this.newestCommunities = newestCommunities;
	}
	public int getCommunitiesYouOwn() {
		return communitiesYouOwn;
	}
	public void setCommunitiesYouOwn(int communitiesYouOwn) {
		this.communitiesYouOwn = communitiesYouOwn;
	}
	public int getCommunitiesYouArePartOf() {
		return communitiesYouArePartOf;
	}
	public void setCommunitiesYouArePartOf(int communitiesYouArePartOf) {
		this.communitiesYouArePartOf = communitiesYouArePartOf;
	}
	public int getRequests() {
		return requests;
	}
	public void setRequests(int requests) {
		this.requests = requests;
	}
	public int getInvitations() {
		return invitations;
	}
	public void setInvitations(int invitations) {
		this.invitations = invitations;
	}
	public int getUsers() {
		return users;
	}
	public void setUsers(int users) {
		this.users = users;
	}
	public int invitations;
	public int users;
}
