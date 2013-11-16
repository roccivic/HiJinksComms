package com.hijinks.comms.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import com.hijinks.comms.models.User;

public class UserMapper implements RowMapper<User>{
	   public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		   User user = new User();
		   user.setId(rs.getInt("id"));
		   user.setFname(rs.getString("fname"));
		   user.setLname(rs.getString("lname"));
		   user.setEmail(rs.getString("email"));
		   user.setType(rs.getString("type")); 
		   return user;
	   }
}
