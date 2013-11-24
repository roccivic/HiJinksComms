package com.hijinks.comms.service;

import java.util.List;

import com.hijinks.comms.models.Invitation;

public interface InvitationService {
	List<Invitation> getInvites(int userId);
	void sendInvite(int userId, int communityId, int invitee);
	void acceptInvite(int invitationId, int userId);
	void deleteInvite(int invitationId, int userId);
	Invitation getInvitationById(int invitationId, int userId);
}
