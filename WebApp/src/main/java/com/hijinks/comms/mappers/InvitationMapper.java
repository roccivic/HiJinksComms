package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hijinks.comms.models.Invitation;

public class InvitationMapper implements RowMapper<Invitation>{
	   public Invitation mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Invitation invitation = new Invitation();
		   invitation.setId(rs.getInt("id"));
		   invitation.setCommunity(rs.getInt("communityId"));
		   invitation.setInvitedBy(rs.getInt("invitedBy"));
		   invitation.setInvitee(rs.getInt("invitee"));
		   invitation.setDate(rs.getTimestamp("date"));
	      return invitation;
	   }
}
