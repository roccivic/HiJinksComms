package com.hijinks.comms.service.impl;

import java.util.List;

import com.hijinks.comms.dao.CommunityDAO;
import com.hijinks.comms.models.Community;
import com.hijinks.comms.service.CommunityService;

public class CommunityServiceImpl implements CommunityService {
	private CommunityDAO communityDAO;
	public void setCommunityDAO(CommunityDAO communityDAO) {
		this.communityDAO = communityDAO;
	}

	@Override
	public void createCommunity(String name, int owner, String keywords,
		String description, boolean keywordsEnabled, String visiblityLevel,
		String accessLevel
	) {
		communityDAO.createCommunity(
			name, owner, keywords,
			description, keywordsEnabled, visiblityLevel,
			accessLevel
		);
	}

	@Override
	public List<Community> getCommunitiesOwnedByUser(int userId) {
		return communityDAO.getCommunitiesOwnedByUser(userId);
	}

	@Override
	public List<Community> getCommunitiesUserIsPartOf(int userId) {
		return communityDAO.getCommunitiesUserIsPartOf(userId);
	}

	@Override
	public List<Community> getNewestCommunities() {
		return communityDAO.getNewestCommunities();
	}

	@Override
	public List<Community> getAllCommunities() {
		return communityDAO.getAllCommunities();
	}

	@Override
	public void addMemberToCommunity(int userId, int communityId) {
		communityDAO.addMemberToCommunity(userId, communityId);
	}

	@Override
	public Community getCommunityById(int id) {
		return communityDAO.getCommunityById(id);
	}

}
