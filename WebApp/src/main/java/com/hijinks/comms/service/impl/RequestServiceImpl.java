package com.hijinks.comms.service.impl;

import java.util.List;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hijinks.comms.dao.CommunityDAO;
import com.hijinks.comms.dao.RequestDAO;
import com.hijinks.comms.models.Request;
import com.hijinks.comms.service.RequestService;

public class RequestServiceImpl implements RequestService {
	private CommunityDAO communityDAO;
	private RequestDAO requestDAO;
	private TransactionTemplate txTemplate;

	public void setCommunityDAO(CommunityDAO communityDAO) {
		this.communityDAO = communityDAO;
	}
	public void setRequestDAO(RequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}
	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}
	
	@Override
	public List<Request> getRequests(int userId) {
		return requestDAO.getRequests(userId);
	}

	@Override
	public void sendRequest(int userId, int communityId) {
		requestDAO.sendRequest(userId, communityId);
	}

	@Override
	public void acceptRequest(final int requestId, final int ownerId) {
		txTemplate.execute(new TransactionCallback <Void> (){
			public Void doInTransaction(TransactionStatus txStatus){
				try {
					Request request = requestDAO.getRequestById(
						requestId,
						ownerId
					);
					communityDAO.addMemberToCommunity(
						request.getUser().getId(),
						request.getCommunity().getId()
					);
					requestDAO.declineRequest(requestId, ownerId);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
	}

	@Override
	public void declineRequest(int requestId, int ownerId) {
		requestDAO.declineRequest(requestId, ownerId);
	}
	@Override
	public Request getRequestById(int requestId, int ownerId) {
		return requestDAO.getRequestById(requestId, ownerId);
	}

}
