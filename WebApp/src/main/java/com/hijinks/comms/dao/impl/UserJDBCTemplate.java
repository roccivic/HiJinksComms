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
	public User LogIn(String email, String password) {
		String query = "SELECT `id`, `fname`, `lname`, `email`, `type` "
				+ "FROM `Users` "
				+ "WHERE `email` = ? "
				+ "AND `password` = MD5(CONCAT(?, `salt`))";
		List<User> list = jdbcTemplateObject.query(
				query,
				new Object[]{email, password},
				new UserMapper()
			);
		if (list.size() == 0) {
			return null;
		} else {
			return list.get(0);
		}
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

	@Override
	public User getUserById(int userId) {
		String query = "SELECT `id`, `fname`, `lname`, `email`, `type` "
				+ "FROM `Users` "
				+ "WHERE `id` = ?";
		List<User> users = jdbcTemplateObject.query(
			query,
			new Object[]{userId},
			new UserMapper()
		);
		if (users.size() == 0) {
			return null;
		} else {
			return users.get(0);
		}
	}

}
