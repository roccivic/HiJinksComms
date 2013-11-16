package com.hijinks.comms.dao;

import java.util.List;
import com.hijinks.comms.models.Invitation;

public interface InvitationDAO {
	List<Invitation> getInvites(int userId);
	boolean sendInvite(int userId, int communityId);
	boolean acceptInvite(int inviteId);
	boolean declineInvite(int inviteId);
}
