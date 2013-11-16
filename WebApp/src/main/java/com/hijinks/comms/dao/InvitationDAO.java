package com.hijinks.comms.dao;

import java.util.List;
import javax.sql.DataSource;
import com.hijinks.comms.models.Invitation;

public interface InvitationDAO {
	public void setDataSource(DataSource ds);
	List<Invitation> getInvites(int userId);
	boolean sendInvite(int userId, int communityId);
	boolean acceptInvite(int inviteId);
	boolean declineInvite(int inviteId);
}
