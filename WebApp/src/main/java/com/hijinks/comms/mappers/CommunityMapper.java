package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.User;

public class CommunityMapper implements RowMapper<Community>{
	   public Community mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User owner = new User();
		   owner.setId(rs.getInt("userId"));
		   owner.setFname(rs.getString("fName"));
		   owner.setLname(rs.getString("lName"));
		   owner.setEmail(rs.getString("email"));
		   owner.setType(rs.getString("type"));
		   Community community = new Community();
		   community.setId(rs.getInt("communityId"));
		   community.setName(rs.getString("name"));
		   community.setOwner(owner);
		   community.setKeywords(rs.getString("keywords"));
		   community.setDescription(rs.getString("description"));
		   community.setKeywordsEnabled(rs.getBoolean("keywordsEnabled"));
		   community.setVisibilityLevel(rs.getString("visibilityLevel"));
		   community.setAccessLevel(rs.getString("accessLevel"));
		   community.setCreated(rs.getTimestamp("created"));
	      return community;
	   }
}
