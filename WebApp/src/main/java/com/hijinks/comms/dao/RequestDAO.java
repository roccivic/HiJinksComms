package com.hijinks.comms.dao;

import java.util.List;
import com.hijinks.comms.models.Request;

public interface RequestDAO {
	boolean sendRequest(int userId, int communityId);
	List<Request> getRequests(int userId);
	boolean acceptRequest(int requestId);
	boolean declineRequest(int requestId);
}
