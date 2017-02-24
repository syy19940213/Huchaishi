package com.huchaishi.action.web.task;

import java.util.List;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetUserAccountAction extends ActionSupport{
	
	public String execute(){
		UserFactory userDao = new UserFactory();
		List<User> userList=userDao.findUserByUserName(String.valueOf(ActionContext.getContext().getSession().get("username")));
		User user = userList.get(0);
		
		BoundStoreFactory acctounDao = new BoundStoreFactory();
		List<BoundStore> accountList = acctounDao.findBoundStoreByUserId(user.getId());
		ActionContext.getContext().put("accountList", accountList);
		
		return Action.SUCCESS;
	}

}
