package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hijinks.comms.models.Community;

public class CommunityMapper implements RowMapper<Community>{
	   public Community mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Community community = new Community();
		   community.setId(rs.getInt("id"));
		   community.setName(rs.getString("name"));
		   community.setOwner(rs.getInt("owner"));
		   community.setKeywords(rs.getString("keywords"));
		   community.setDescription(rs.getString("description"));
		   community.setKeywordsEnabled(rs.getBoolean("keywordsEnabled"));
		   community.setVisibilityLevel(rs.getString("visibilityLevel"));
		   community.setAccessLevel(rs.getString("accessLevel"));
		   community.setCreated(rs.getTimestamp("created"));
	      return community;
	   }
}
