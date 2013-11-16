package com.hijinks.comms.dao;

import java.util.List;
import com.hijinks.comms.models.Community;

public interface CommunityDAO {
	boolean createCommunity(String name, int owner, String keywords, String description, boolean keywordsEnabled, String visiblityLevel, String accessLevel);
	List<Community> getCommunitiesOwnedByUser(int userId);
	List<Community> getCommunitiesUserIsPartOf(int userId);
	List<Community> getNewestCommunities();
	List<Community> getAllCommunities();
	boolean addMemberToCommunity(int userId, int communityId);
	boolean joinCommunity(int userId, int communityId);
	
}
