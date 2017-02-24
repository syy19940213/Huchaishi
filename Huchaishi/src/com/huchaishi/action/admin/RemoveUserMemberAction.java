package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.huchaishi.hibernate.userapply.UserApply;
import com.huchaishi.hibernate.userapply.UserApplyFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class RemoveUserMemberAction {
	
	private int userId;
	
	
	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public  String execute() {
		//更新用户信息
		UserFactory userDao = new UserFactory();
		User user  = userDao.findUserById(userId);
		user.setUserLevel(0);
		userDao.updataUser(user);
		
	
		return Action.SUCCESS;
	}

}
