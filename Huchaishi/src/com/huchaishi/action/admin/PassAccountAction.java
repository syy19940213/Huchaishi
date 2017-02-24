package com.huchaishi.action.admin;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class PassAccountAction extends ActionSupport{
	private Integer accountId;

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	
	
	public String execute() {
		
		BoundAccountFactory accountDao = new BoundAccountFactory();
		BoundAccount account = accountDao.findBoundAccoutById(accountId);
		if(account!=null){
			account.setBoundAccountstatus("2");
			accountDao.updateBoundAccount(account);
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}
	
}
