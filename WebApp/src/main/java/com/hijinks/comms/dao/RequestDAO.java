package com.hijinks.comms.dao;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.models.Request;

public interface RequestDAO {
	public void setDataSource(DataSource ds);
	boolean sendRequest(int userId, int communityId);
	List<Request> getRequests(int userId);
	boolean acceptRequest(int requestId);
	boolean declineRequest(int requestId);
}
