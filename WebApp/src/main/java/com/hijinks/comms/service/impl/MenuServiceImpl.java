package com.hijinks.comms.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.hijinks.comms.dao.MenuDAO;
import com.hijinks.comms.models.Menu;
import com.hijinks.comms.service.MenuService;

public class MenuServiceImpl implements MenuService {
	private MenuDAO menuDAO;
	private TransactionTemplate txTemplate;
	Menu menu;
	
	public void setMenuDAO(MenuDAO menuDAO) {
		this.menuDAO = menuDAO;
	}

	public void setTxTemplate(TransactionTemplate txTemplate) {
		this.txTemplate = txTemplate;
	}

	@Override
	public Menu getMenu(final int userId) {
		txTemplate.execute(new TransactionCallback <Void> (){
			public Void doInTransaction(TransactionStatus txStatus){
				try {
					menu = menuDAO.getMenu(userId);
				} catch (RuntimeException e) {
					txStatus.setRollbackOnly();
					throw e;
				}
				return null;
			}
		});
		return menu;
	}
}
