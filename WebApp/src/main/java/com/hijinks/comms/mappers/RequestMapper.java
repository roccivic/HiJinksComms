package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.hijinks.comms.models.Community;
import com.hijinks.comms.models.Request;
import com.hijinks.comms.models.User;

public class RequestMapper implements RowMapper<Request>{
	   public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Community community = new Community();
		   //TO DO
		   User user = new User();
		   //TO DO
		   Request request = new Request();
		   request.setId(rs.getInt("id"));
		   request.setCommunity(community);
		   request.setUser(user);
		   request.setDate(rs.getTimestamp("date"));
		   return request;
	   }
}
