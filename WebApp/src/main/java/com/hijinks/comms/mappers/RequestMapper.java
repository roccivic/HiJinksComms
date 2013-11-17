package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.Request;
import com.hijinks.comms.models.User;

public class RequestMapper implements RowMapper<Request>{
	   public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
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
		   Request request = new Request();
		   request.setId(rs.getInt("requestId"));
		   request.setCommunity(community);
		   request.setUser(user);
		   request.setDate(rs.getTimestamp("date"));
		   return request;
	   }
}
