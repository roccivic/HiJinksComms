package com.hijinks.comms.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.dao.CommunityDAO;
import com.hijinks.comms.mappers.CommunityMapper;
import com.hijinks.comms.models.Community;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommunityJDBCTemplate implements CommunityDAO{

	private JdbcTemplate jdbcTemplateObject;
	
	@Override
	public void setDataSource(DataSource dataSource) {
      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	  
	@Override
	public void createCommunity(String name, int owner, String keywords,
			String description, boolean keywordsEnabled, String visiblityLevel,
			String accessLevel) {
		String query = "INSERT INTO `Community`"
				+ "(`name`, `owner`, `description`, `keywords`, `keywordsEnabled`, `visibilityLevel`, `accessLevel`) "
				+ "VALUES (? , ?, ?, ?, ?, ?, ?)";
		jdbcTemplateObject.update(query, name, owner, keywords, description, keywordsEnabled, visiblityLevel, accessLevel);
	}

	@Override
	public List<Community> getCommunitiesOwnedByUser(int userId) {
		String query = "SELECT `id`, `name`, `owner`, `description`, `keywords`, `keywordsEnabled`,"
				+ " `visibilityLevel`, `accessLevel`, `created` FROM `Community` WHERE owner = ?";
		List<Community> communities = jdbcTemplateObject.query(query, new Object[]{userId}, new CommunityMapper());
		return communities;
	}

	@Override
	public List<Community> getCommunitiesUserIsPartOf(int userId) {
		String query = "SELECT `id`, `name`, `owner`, `description`, `keywords`, `keywordsEnabled`, `visibilityLevel`,"
				+ " `accessLevel`, `created` FROM `Community`"
				+ " INNER JOIN CommunityUsers ON Community.id = CommunityUsers.community WHERE CommunityUsers.user = ?";
		List<Community> communities = jdbcTemplateObject.query(query, new Object[]{userId}, new CommunityMapper());
		return communities;
	}

	@Override
	public List<Community> getNewestCommunities() {
		String query = "SELECT `id`, `name`, `owner`, `description`, `keywords`, `keywordsEnabled`, "
				+ "`visibilityLevel`, `accessLevel`, `created` FROM `Community` "
				+ "ORDER BY `created` DESC LIMIT 10;";
		List<Community> communities = jdbcTemplateObject.query(query, new CommunityMapper());
		return communities;
	}

	@Override
	public List<Community> getAllCommunities() {
		String query = "SELECT `id`, `name`, `owner`, `description`, `keywords`, `keywordsEnabled`,"
				+ " `visibilityLevel`, `accessLevel`, `created` FROM `Community` ORDER BY `created` DESC";
		List<Community> communities = jdbcTemplateObject.query(query, new CommunityMapper());
		return communities;
	}

	@Override
	public void addMemberToCommunity(int userId, int communityId) {
		String query = "INSERT INTO `CommunityUsers`(`community`, `user`) VALUES (?, ?)";
		jdbcTemplateObject.update(query, userId, communityId);
	}

}
