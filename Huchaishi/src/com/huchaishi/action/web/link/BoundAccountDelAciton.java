package com.huchaishi.action.web.link;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.opensymphony.xwork2.Action;

public class BoundAccountDelAciton {

	private int accoutid;
	private int accountuserid;
	public int getAccoutid() {
		return accoutid;
	}
	public void setAccoutid(int accoutid) {
		this.accoutid = accoutid;
	}
	
	public int getAccountuserid() {
		return accountuserid;
	}
	public void setAccountuserid(int accountuserid) {
		this.accountuserid = accountuserid;
	}
	
	
	public String execute() {
		BoundAccount account = new BoundAccount();
		account.setId(accoutid);
		account.setUserId(accountuserid);
		BoundAccountFactory dao =new BoundAccountFactory();
		dao.delAccount(account);
		return Action.SUCCESS;
		
	}
}
