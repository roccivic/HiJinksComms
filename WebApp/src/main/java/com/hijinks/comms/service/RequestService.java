package com.hijinks.comms.service;

import java.util.List;
import com.hijinks.comms.models.Request;

public interface RequestService {
	List<Request> getRequests(int userId);
	void sendRequest(int userId, int communityId);
	void acceptRequest(int userId, int communityId);
	void declineRequest(int userId, int communityId);
}
