package com.hijinks.comms.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import com.hijinks.comms.dao.RequestDAO;
import com.hijinks.comms.mappers.RequestMapper;
import com.hijinks.comms.models.Request;

public class RequestJDBCTemplate implements RequestDAO {
	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource ds) {
		this.jdbcTemplateObject = new JdbcTemplate(ds);
	}

	@Override
	public List<Request> getRequests(int userId) {
		String query = "SELECT `Request`.`id` as `requestId` , "
				+ "`date`,"
				+ "`Community`.`id` AS `communityId`,"
				+ "`Community`.`name`,"
				+ "`Community`.`keywords`,"
				+ "`Community`.`description`,"
				+ "`Community`.`keywordsEnabled`,"
				+ "`Community`.`visibilityLevel`,"
				+ "`Community`.`accessLevel`,"
				+ "`Community`.`created`,"
				+ "`communityOwner`.`id` AS `communityOwnerId`,"
				+ "`communityOwner`.`fname` AS `communityOwnerFname`,"
				+ "`communityOwner`.`lname` AS `communityOwnerLname`,"
				+ "`communityOwner`.`email` AS `communityOwnerEmail`,"
				+ "`communityOwner`.`type` AS `communityOwnerType`,"
				+ "`user`.`id` AS `userId`,"
				+ "`user`.`fname` AS `userFname`,"
				+ "`user`.`lname` AS `userLname`,"
				+ "`user`.`email` AS `userEmail`,"
				+ "`user`.`type` AS `userType`"
				+ "FROM `Request` "
				+ "INNER JOIN `Community` ON "
				+ "`Request`.`communityId` = `Community`.`id` "
				+ "INNER JOIN `Users` AS `communityOwner` ON "
				+ "`Community`.`owner` = `communityOwner`.`id` "
				+ "INNER JOIN `Users`AS `user` ON "
				+ "`Request`.`user` = `user`.`id` "
				+ "WHERE `Community`.`owner` = ?";
		List<Request> requests = jdbcTemplateObject.query(
			query,
			new Object[]{userId},
			new RequestMapper()
		);
		return requests;
	}

	@Override
	public void sendRequest(int userId, int communityId) {
		String query = "INSERT INTO `Request` "
				+ "(`communityId`, `user`) "
				+ "VALUES (?, ?)";
		jdbcTemplateObject.update(query, communityId, userId);
	}
	
	@Override
	public void declineRequest(int requestId, int ownerId) {
		String query = "DELETE FROM `Request` "
				+ "WHERE `id` = ?";
		jdbcTemplateObject.update(query, requestId);
	}

	@Override
	public Request getRequestById(int requestId, int ownerId) {
		String query = "SELECT `Request`.`id` as `requestId` , "
				+ "`date`,"
				+ "`Community`.`id` AS `communityId`,"
				+ "`Community`.`name`,"
				+ "`Community`.`keywords`,"
				+ "`Community`.`description`,"
				+ "`Community`.`keywordsEnabled`,"
				+ "`Community`.`visibilityLevel`,"
				+ "`Community`.`accessLevel`,"
				+ "`Community`.`created`,"
				+ "`communityOwner`.`id` AS `communityOwnerId`,"
				+ "`communityOwner`.`fname` AS `communityOwnerFname`,"
				+ "`communityOwner`.`lname` AS `communityOwnerLname`,"
				+ "`communityOwner`.`email` AS `communityOwnerEmail`,"
				+ "`communityOwner`.`type` AS `communityOwnerType`,"
				+ "`user`.`id` AS `userId`,"
				+ "`user`.`fname` AS `userFname`,"
				+ "`user`.`lname` AS `userLname`,"
				+ "`user`.`email` AS `userEmail`,"
				+ "`user`.`type` AS `userType`"
				+ "FROM `Request` "
				+ "INNER JOIN `Community` ON "
				+ "`Request`.`communityId` = `Community`.`id` "
				+ "INNER JOIN `Users` AS `communityOwner` ON "
				+ "`Community`.`owner` = `communityOwner`.`id` "
				+ "INNER JOIN `Users`AS `user` ON "
				+ "`Request`.`user` = `user`.`id` "
				+ "WHERE `Request`.`id` = ? "
				+ "AND `Community`.`owner` = ?";
		List<Request> requests = jdbcTemplateObject.query(
			query,
			new Object[]{requestId, ownerId},
			new RequestMapper()
		);
		if (requests.size() == 0) {
			return null;
		} else {
			return requests.get(0);
		}
	}
}
