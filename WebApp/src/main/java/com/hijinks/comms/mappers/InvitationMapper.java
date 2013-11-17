package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.Invitation;
import com.hijinks.comms.models.User;

public class InvitationMapper implements RowMapper<Invitation>{
	   public Invitation mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Community community = new Community();
		   //TO DO
		   User invitedBy = new User();
		   //TO DO
		   User invitee = new User();
		   //TO DO
		   Invitation invitation = new Invitation();
		   invitation.setId(rs.getInt("id"));
		   invitation.setCommunity(community);
		   invitation.setInvitedBy(invitedBy);
		   invitation.setInvitee(invitee);
		   invitation.setDate(rs.getTimestamp("date"));
	      return invitation;
	   }
}
