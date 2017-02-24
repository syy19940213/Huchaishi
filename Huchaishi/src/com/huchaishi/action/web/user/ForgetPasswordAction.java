package com.huchaishi.action.web.user;

import java.util.List;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ForgetPasswordAction extends ActionSupport {
	
	private String username;
	private String qq;
	private String password;
	private String realName;
	private String cardid;
	
	
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getCardid() {
		return cardid;
	}
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String execute(){
		
		if(cheak()){
			UserFactory userDao = new UserFactory();
			List<User> userList = userDao.findUserByUserName(username);
			User user = userList.get(0);
			user.setUserPassword(password);
			userDao.updataUser(user);
			ActionContext.getContext().put("message", "找回密码成功！");
		}else{
			ActionContext.getContext().put("message", "找回密码失败！您输入的信息有误！");
		}
		
		return Action.SUCCESS;
		
	}
	private boolean cheak() {
		UserFactory userDao = new UserFactory();
		List<User> userList = userDao.findUserByUserName(username);
		if(userList.size()!=0){
			User user= userList.get(0);
			if(user.getUserQq().equals(qq) && user.getRealName().equals(realName) && user.getCardId().equals(cardid)){
				return true;
			}else{
				return false;
			}
			
		}else{
			return false;
		}
		
	}

}
