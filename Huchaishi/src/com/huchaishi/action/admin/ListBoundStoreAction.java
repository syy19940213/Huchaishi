package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreDAO;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListBoundStoreAction extends ActionSupport {

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		
		BoundStoreFactory storedao = new BoundStoreFactory();
		Integer status =1;
		List<BoundStore> storelist = storedao.findBoundAccoutByStaus(status);		
		ActionContext.getContext().put("storelist", storelist);
		
		
//		BoundAccountFactory accountDAO = new BoundAccountFactory();
//		String status="1";
//		List<BoundAccount> accountList = accountDAO.findBoundAccoutByStaus(status);
//		ActionContext.getContext().put("accountList", accountList);
		return SUCCESS;
		
	}
}