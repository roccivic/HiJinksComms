package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hijinks.comms.models.Announcement;

public class AnnouncementMapper implements RowMapper<Announcement>{
	   public Announcement mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Announcement announcement = new Announcement();
		   announcement.setId(rs.getInt("id"));
		   announcement.setTitle(rs.getString("title"));
		   announcement.setText(rs.getString("text"));
		   announcement.setCommunity(rs.getInt("community"));
		   announcement.setDate(rs.getTimestamp("date"));
		   announcement.setCreatedBy(rs.getInt("createdBy"));
	      return announcement;
	   }
}
