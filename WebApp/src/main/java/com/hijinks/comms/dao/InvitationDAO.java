package com.hijinks.comms.dao;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.models.Invitation;

public interface InvitationDAO {
	public void setDataSource(DataSource ds);
	List<Invitation> getInvites(int userId);
	void sendInvite(int userId, int communityId, int invitee);
	void deleteInvite(int invitationId, int userId);
	Invitation getInvitationById(int invitationId, int userId);
}
