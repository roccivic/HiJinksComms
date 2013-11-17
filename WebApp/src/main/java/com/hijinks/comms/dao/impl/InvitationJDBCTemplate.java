package com.hijinks.comms.dao.impl;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.dao.InvitationDAO;
import com.hijinks.comms.mappers.InvitationMapper;
import com.hijinks.comms.models.Invitation;
import org.springframework.jdbc.core.JdbcTemplate;

public class InvitationJDBCTemplate implements InvitationDAO{

	private JdbcTemplate jdbcTemplateObject;

	@Override
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Invitation> getInvites(int userId) {
		String query = "SELECT `Invitation`.`id` as invitationId , `date`,"
				+ "`Community`.`id` AS communityId, `Community`.`name`, `Community`.`keywords`, `Community`.`description`, `Community`.`keywordsEnabled`, `Community`.`visibilityLevel`, `Community`.`accessLevel`, `Community`.`created`,"
				+ "`communityOwner`.`id` AS communityOwnerId, `communityOwner`.`fname` AS communityOwnerFname, `communityOwner`.`lname` AS communityOwnerLname, `communityOwner`.`email` AS communityOwnerEmail, `invitedBy`.`type` AS communityOwnerType,"
				+ "`invitedBy`.`id` AS invitedById, `invitedBy`.`fname` AS invitedByFname, `invitedBy`.`lname` AS invitedByLname, `invitedBy`.`email` AS invitedByEmail, `invitedBy`.`type` AS invitedByType,"
				+ "`invitee`.`id` AS inviteeId, `invitee`.`fname` AS inviteeFname, `invitee`.`lname` AS inviteeLname, `invitee`.`email` inviteeEmail, `invitee`.`type` AS inviteeType" 
				+ "FROM `Invitation`"
				+ "INNER JOIN Community ON"
				+ "`Invitation`.`communityId` = `Community`.`id`"
				+ "INNER JOIN `Users` AS `communityOwner` ON"
				+ "`Community`.`owner` = `communityOwner`.`id`"
				+ "INNER JOIN `Users`AS `invitedBy` ON"
				+ "`Invitation`.`invitedBy` = `invitedBy`.`id`"
				+ "INNER JOIN `Users` AS `invitee` ON"
				+ "`Invitation`.`invitee` = `invitee`.`id`"
				+ "WHERE `Invitation`.`invitee` = ?";
		List<Invitation> invitations = jdbcTemplateObject.query(query, new Object[]{userId}, new InvitationMapper());
		return invitations;
	}

	@Override
	public void sendInvite(int userId, int communityId, int invitee) {
		String query = "INSERT INTO `Invitation`(`communityId`, `invitedBy`, `invitee`) VALUES (?, ?, ?)";
		jdbcTemplateObject.update(query, communityId, userId, invitee);
	}

	@Override
	public void deleteInvite(int user, int community) {
		String query = "DELETE FROM `Invitation` WHERE `invitee` = ? AND `communityId` = ?";
		jdbcTemplateObject.update(query, user, community);
	}
}


