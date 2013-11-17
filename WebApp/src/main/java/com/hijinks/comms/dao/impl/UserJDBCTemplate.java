package com.hijinks.comms.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hijinks.comms.dao.UserDAO;
import com.hijinks.comms.mappers.UserMapper;
import com.hijinks.comms.models.User;

public class UserJDBCTemplate implements UserDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public List<User> getUsersNotInCommunity(int communityId) {
		String query = "SELECT `Users`.`id`, `fname`, `lname`, `email`, `type` "
				+ "FROM `Users` "
				+ "WHERE `id` NOT IN( "
				+ "  SELECT `user` "
				+ "  FROM `CommunityUsers` "
				+ "  WHERE `CommunityUsers`.`community` = ?"
				+ ")";
		return jdbcTemplateObject.query(
			query,
			new Object[]{communityId},
			new UserMapper()
		);
	}

	@Override
	public boolean LogIn(String email, String password) {
		String query = "SELECT COUNT(*) "
				+ "FROM `Users` "
				+ "WHERE `email` = ? "
				+ "AND `password` = MD5(CONCAT(?, `salt`))";
		return jdbcTemplateObject.queryForInt(
			query,
			new Object[]{email, password}
		) == 1;
	}

	@Override
	public List<User> getMembersOfCommunity(int communityId) {
		String query = "SELECT `Users`.`id`, `fname`, `lname`, `email`, `type` "
				+ "FROM `CommunityUsers` "
				+ "INNER JOIN `Users` "
				+ "ON `Users`.`id` = `CommunityUsers`.`user` "
				+ "WHERE `CommunityUsers`.`community` = ?";
		return jdbcTemplateObject.query(
			query,
			new Object[]{communityId},
			new UserMapper()
		);
	}

	@Override
	public List<User> searchForMembers(String fname, String lname, String email) {
		String query = "SELECT `id`, `fname`, `lname`, `email`, `type` "
				+ "FROM `Users` "
				+ "WHERE fname LIKE ? "
				+ "AND lname LIKE ? "
				+ "AND email LIKE ?";
		return jdbcTemplateObject.query(
			query,
			new Object[]{
				"%" + fname + "%",
				"%" + lname + "%",
				"%" + email + "%"
			},
			new UserMapper()
		);
	}

}
