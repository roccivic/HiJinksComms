package com.hijinks.comms.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hijinks.comms.models.User;

public interface UserDAO {
	public void setDataSource(DataSource ds);
	List<User> getUsersNotInCommunity(int communityId);
	User LogIn(String email, String password);
	List<User> getMembersOfCommunity(int communityId);
	List<User> searchForMembers(String fname, String lname, String email);
	public User getUserById(int userId);
	public boolean isOwner(int userId, int communityId);
	public boolean isPartOfCommunity(int userId, int communityId);
}
