package com.hijinks.comms.service.impl;

import java.util.List;
import com.hijinks.comms.dao.UserDAO;
import com.hijinks.comms.models.User;
import com.hijinks.comms.service.UserService;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO;
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Override
	public List<User> getUsersNotInCommunity(int communityId) {
		return userDAO.getUsersNotInCommunity(communityId);
	}

	@Override
	public User LogIn(String email, String password) {
		return userDAO.LogIn(email, password);
	}

	@Override
	public List<User> getMembersOfCommunity(int communityId) {
		return userDAO.getMembersOfCommunity(communityId);
	}

	@Override
	public List<User> searchForMembers(String fname, String lname, String email) {
		return userDAO.searchForMembers(fname, lname, email);
	}

	@Override
	public User getUserById(int userId) {
		return userDAO.getUserById(userId);
	}
	
	@Override
	public boolean isOwner(int userId, int communityId) {
		return userDAO.isOwner(userId, communityId);
	}
	
	@Override
	public boolean isPartOfCommunity(int userId, int communityId) {
		return userDAO.isPartOfCommunity(userId, communityId);
	}

}
