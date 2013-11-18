package com.hijinks.comms.service.impl;

import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hijinks.comms.dao.CommunityDAO;
import com.hijinks.comms.dao.InvitationDAO;
import com.hijinks.comms.models.Invitation;
import com.hijinks.comms.service.InvitationService;

public class InvitationServiceImpl implements InvitationService {
	private CommunityDAO communityDAO;
	private InvitationDAO invitationDAO;
	private TransactionTemplate txTemplate;

	public void setCommunityDAO(CommunityDAO communityDAO) {
		this.communityDAO = communityDAO;
	}
	public void setInvitationDAO(InvitationDAO invitationDAO) {
		this.invitationDAO = invitationDAO;
	}
	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}

	@Override
	public List<Invitation> getInvites(int userId) {
		return invitationDAO.getInvites(userId);
	}

	@Override
	public void sendInvite(int userId, int communityId, int invitee) {
		invitationDAO.sendInvite(userId, communityId, invitee);
	}

	@Override
	public void acceptInvite(final int userId, final int communityId) {
		txTemplate.execute(new TransactionCallback <Void> (){
			public Void doInTransaction(TransactionStatus txStatus){
				try {
					communityDAO.addMemberToCommunity(userId, communityId);
					invitationDAO.deleteInvite(userId, communityId);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
	}

	@Override
	public void deleteInvite(int userId, int communityId) {
		invitationDAO.deleteInvite(userId, communityId);
	}

}
