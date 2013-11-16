package com.hijinks.comms.dao;

import java.util.List;
import com.hijinks.comms.models.User;

public interface UserDAO {
	List<User> getUsersNotInCommunity(int communityId);
	boolean LogIn(String username, String password);
	List<User> getMembersOfCommunity(int communityId);
	List<User> searchForMembers(String criteria);
	
	
	
}
