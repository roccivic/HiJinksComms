package com.hijinks.comms.service;

import java.util.List;
import com.hijinks.comms.models.Invitation;

public interface InvitationService {
	List<Invitation> getInvites(int userId);
	void sendInvite(int userId, int communityId, int invitee);
	void acceptInvite(int userId, int communityId);
	void deleteInvite(int userId, int communityId);
}
