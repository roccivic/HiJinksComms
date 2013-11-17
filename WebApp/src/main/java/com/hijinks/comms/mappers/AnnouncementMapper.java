package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hijinks.comms.models.Announcement;
import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.User;

public class AnnouncementMapper implements RowMapper<Announcement>{
	   public Announcement mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		   User user = new User();
		   user.setId(rs.getInt("userId"));
		   user.setFname(rs.getString("userFname"));
		   user.setLname(rs.getString("userLname"));
		   user.setEmail(rs.getString("userEmail"));
		   user.setType(rs.getString("userType"));
		   Announcement announcement = new Announcement();
		   announcement.setId(rs.getInt("announcementId"));
		   announcement.setTitle(rs.getString("title"));
		   announcement.setText(rs.getString("text"));
		   announcement.setCommunity(community);
		   announcement.setDate(rs.getTimestamp("date"));
		   announcement.setCreatedBy(user);
	      return announcement;
	   }
}
