package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NotPassAccountAction extends ActionSupport{
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
			account.setBoundAccountstatus("3");
			accountDao.updateBoundAccount(account);
			return Action.SUCCESS;
		}else{
			return Action.ERROR;
		}
		
	}
	

}
