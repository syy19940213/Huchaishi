package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListBoundAccountAction extends ActionSupport{
	
	public String execute() {
		
		
		
			BoundAccountFactory accountDAO = new BoundAccountFactory();
			String status="1";
			List<BoundAccount> accountList = accountDAO.findBoundAccoutByStaus(status);
			ActionContext.getContext().put("accountList", accountList);
		
		
		return Action.SUCCESS;
	}

}
