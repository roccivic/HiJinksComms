package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hijinks.comms.models.Announcement;
import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.User;

public class AnnouncementMapper implements RowMapper<Announcement>{
	   public Announcement mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Community community = new Community();
		   //TO DO
		   User user = new User();
		   //TO DO
		   Announcement announcement = new Announcement();
		   announcement.setId(rs.getInt("id"));
		   announcement.setTitle(rs.getString("title"));
		   announcement.setText(rs.getString("text"));
		   announcement.setCommunity(community);
		   announcement.setDate(rs.getTimestamp("date"));
		   announcement.setCreatedBy(user);
	      return announcement;
	   }
}
