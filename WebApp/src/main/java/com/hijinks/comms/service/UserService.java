package com.hijinks.comms.service;

import java.util.List;

import com.hijinks.comms.models.User;

public interface UserService {
	List<User> getUsersNotInCommunity(int communityId);
	User LogIn(String email, String password);
	List<User> getMembersOfCommunity(int communityId);
	List<User> searchForMembers(String fname, String lname, String email);
	User getUserById(int userId);
	boolean isOwner(int userId, int CommunityId);
	boolean isPartOfCommunity(int userId, int CommunityId);
}
