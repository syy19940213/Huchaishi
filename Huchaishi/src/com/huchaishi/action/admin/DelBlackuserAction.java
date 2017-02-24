package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelBlackuserAction extends ActionSupport{
	
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
		user.setBlackUser(1);
		userDao.updataUser(user);
		List<User> userList = userDao.findAll();
		ActionContext.getContext().put("userList", userList);
		return Action.SUCCESS;
		
	}

}
