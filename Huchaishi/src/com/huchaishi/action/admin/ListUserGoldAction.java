package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListUserGoldAction extends ActionSupport{
	
	public String execute(){
		UserFactory userdao  = new UserFactory();
		List<User> userList = userdao.findAll();
		ActionContext.getContext().put("userList", userList);
		return Action.SUCCESS;
	}

}
