package com.hijinks.comms.dao;

import java.util.List;

import javax.sql.DataSource;

import com.hijinks.comms.models.Community;

public interface CommunityDAO {
	public void setDataSource(DataSource ds);
	//changing all boolean methods to void. I think that errors are handled in the service layer by the looks of it
	void createCommunity(String name, int owner, String keywords, String description, boolean keywordsEnabled, String visiblityLevel, String accessLevel);
	List<Community> getCommunitiesOwnedByUser(int userId);
	List<Community> getCommunitiesUserIsPartOf(int userId);
	List<Community> getNewestCommunities();
	List<Community> getAllCommunities();
	void addMemberToCommunity(int userId, int communityId);
	public Community getCommunityById(int communityId);
}
