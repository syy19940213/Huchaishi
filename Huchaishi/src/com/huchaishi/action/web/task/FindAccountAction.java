package com.huchaishi.action.web.task;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class FindAccountAction {
	
	private String result;


	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public String execute(){
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		UserFactory userDao = new UserFactory();
		List<User> userList=userDao.findUserByUserName(userName);
		String json =null;
		if(userList.size()!=0){
			int userId = userList.get(0).getId();
			BoundAccountFactory dao1 = new BoundAccountFactory();
			List<BoundAccount> accountList =dao1.findBoundAccoutByUserId(userId);
			json = JSON.toJSONString(accountList);;
		}
		result = json;
		return Action.SUCCESS;
		
		
	}

}
