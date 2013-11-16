package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hijinks.comms.models.Request;

public class RequestMapper implements RowMapper<Request>{
	   public Request mapRow(ResultSet rs, int rowNum) throws SQLException {
		   Request request = new Request();
		   request.setId(rs.getInt("id"));
		   request.setCommunity(rs.getInt("community"));
		   request.setUser(rs.getInt("user"));
		   request.setDate(rs.getTimestamp("date"));
		   return request;
	   }
}
