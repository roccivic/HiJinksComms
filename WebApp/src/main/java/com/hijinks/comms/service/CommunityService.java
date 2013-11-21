package com.hijinks.comms.service;

import java.util.List;

import com.hijinks.comms.models.Community;

public interface CommunityService {
	void createCommunity(String name, int owner, String keywords, String description, boolean keywordsEnabled, String visiblityLevel, String accessLevel);
	List<Community> getCommunitiesOwnedByUser(int userId);
	List<Community> getCommunitiesUserIsPartOf(int userId);
	List<Community> getNewestCommunities();
	List<Community> getAllCommunities();
	void addMemberToCommunity(int userId, int communityId);
	Community getCommunityById(int communityId);
}
