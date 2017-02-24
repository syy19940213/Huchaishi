package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.adminuser.AdminUser;
import com.huchaishi.hibernate.adminuser.AdminUserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class AdminUserLoginAction {
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute(){
		
		AdminUser user  = new AdminUser();
		user.setAdminUser(username);
		user.setAdminPassword(password);
		
		AdminUserFactory adminDAO = new AdminUserFactory();
		List<AdminUser> userList = adminDAO.findByExample(user);
		
		if(userList.size()!=0){
			AdminUser userFind = userList.get(0);
			if(userFind.getAdminUser().equals(username) && userFind.getAdminPassword().equals(password)){
				return Action.SUCCESS;
			}else{
				ActionContext.getContext().put("message", "用户名密码错误！");
				return Action.ERROR;
			}
			
		}else{
			ActionContext.getContext().put("message", "用户名密码错误！");
			return Action.ERROR;
		}
		
		
	}
	
}
