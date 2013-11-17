package com.hijinks.comms.dao;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.models.Request;

public interface RequestDAO {
	public void setDataSource(DataSource ds);
	List<Request> getRequests(int userId);
	void sendRequest(int userId, int communityId);
	void declineRequest(int user, int community);
}
