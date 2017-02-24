package com.huchaishi.action.web.link;

import java.util.List;

import com.alibaba.fastjson.support.odps.CodecCheck.A;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AlterUserAction extends ActionSupport {

	private int userid;
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String execute(){
		UserFactory userDao = new UserFactory();
		User user = userDao.findUserById(userid);
		user.setUserPassword(password);
		userDao.updataUser(user);
		return SUCCESS;
	}
}