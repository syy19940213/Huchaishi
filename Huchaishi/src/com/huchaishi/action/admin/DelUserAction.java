package com.huchaishi.action.admin;

import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;

public class DelUserAction {
	
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String execute(){
		UserFactory userDao = new UserFactory();
		userDao.delUser(userId);
		return Action.SUCCESS;
	}
	

}
