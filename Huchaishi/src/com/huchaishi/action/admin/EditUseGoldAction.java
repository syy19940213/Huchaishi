package com.huchaishi.action.admin;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EditUseGoldAction extends ActionSupport{
	
	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String execute(){
		UserFactory userDao = new UserFactory();
		User user = userDao.findUserById(userId);
		if(user!=null){
			ActionContext.getContext().put("user", user);
		}
		return Action.SUCCESS;
	}

}
