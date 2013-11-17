package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.Invitation;
import com.hijinks.comms.models.User;

public class InvitationMapper implements RowMapper<Invitation>{
	   public Invitation mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User communityOwner = new User();
		   communityOwner.setId(rs.getInt("communityOwnerId"));
		   communityOwner.setFname(rs.getString("communityOwnerFname"));
		   communityOwner.setLname(rs.getString("communityOwnerLname"));
		   communityOwner.setEmail(rs.getString("communityOwnerEmail"));
		   communityOwner.setType(rs.getString("communityOwnerType"));
		   Community community = new Community();
		   community.setId(rs.getInt("communityId"));
		   community.setName(rs.getString("name"));
		   community.setOwner(communityOwner);
		   community.setDescription(rs.getString("description"));
		   community.setKeywords(rs.getString("keywords"));
		   community.setKeywordsEnabled(rs.getBoolean("keywordsEnabled"));
		   community.setAccessLevel(rs.getString("accessLevel"));
		   community.setVisibilityLevel(rs.getString("visibilityLevel"));
		   community.setCreated(rs.getTimestamp("created"));
		   User invitedBy = new User();
		   invitedBy.setId(rs.getInt("invitedById"));
		   invitedBy.setFname(rs.getString("invitedByFname"));
		   invitedBy.setLname(rs.getString("invitedByLname"));
		   invitedBy.setEmail(rs.getString("invitedByEmail"));
		   invitedBy.setType(rs.getString("invitedByType"));
		   User invitee = new User();
		   invitedBy.setId(rs.getInt("inviteeId"));
		   invitedBy.setFname(rs.getString("inviteeFname"));
		   invitedBy.setLname(rs.getString("inviteeLname"));
		   invitedBy.setEmail(rs.getString("inviteeEmail"));
		   invitedBy.setType(rs.getString("inviteeType"));
		   Invitation invitation = new Invitation();
		   invitation.setId(rs.getInt("id"));
		   invitation.setCommunity(community);
		   invitation.setInvitedBy(invitedBy);
		   invitation.setInvitee(invitee);
		   invitation.setDate(rs.getTimestamp("date"));
	      return invitation;
	   }
}
