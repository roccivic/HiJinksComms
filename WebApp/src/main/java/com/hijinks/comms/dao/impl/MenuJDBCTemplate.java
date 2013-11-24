package com.hijinks.comms.dao.impl;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hijinks.comms.dao.MenuDAO;
import com.hijinks.comms.models.Menu;

public class MenuJDBCTemplate implements MenuDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public Menu getMenu(int userId) {
		Menu menu = new Menu();
		menu.newestCommunities = Math.max(
			jdbcTemplateObject.queryForInt(
				"SELECT COUNT(*) "
				+ "FROM `Community`"
			),
			10
		);
		menu.communitiesYouOwn = jdbcTemplateObject.queryForInt(
			"SELECT COUNT(*) "
			+ "FROM `Community` "
			+ "WHERE `owner` = ?",
			userId
		);
		menu.communitiesYouArePartOf = jdbcTemplateObject.queryForInt(
			"SELECT COUNT(*) "
			+ "FROM `CommunityUsers` "
			+ "WHERE `user` = ?",
			userId
		);
		menu.requests = jdbcTemplateObject.queryForInt(
			"SELECT COUNT(*) "
			+ "FROM `Request` "
			+ "INNER JOIN `Community` "
			+ "ON `Community`.`id` = `Request`.`communityId` "
			+ "WHERE `owner` = ?",
			userId
		);
		menu.invitations = jdbcTemplateObject.queryForInt(
			"SELECT COUNT(*) "
			+ "FROM `Invitation` "
			+ "WHERE `invitee` = ?",
			userId
		);
		menu.users = jdbcTemplateObject.queryForInt(
			"SELECT COUNT(*) "
			+ "FROM `Users`"
		);
		return menu;
	}

}
