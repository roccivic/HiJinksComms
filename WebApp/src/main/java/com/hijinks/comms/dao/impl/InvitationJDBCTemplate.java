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
		String query = "SELECT `id`, `communityId`, `invitedBy`, `invitee`, `date` FROM `Invitation` WHERE `invitee` = ?";
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


