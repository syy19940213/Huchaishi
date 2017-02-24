package com.huchaishi.action.admin;

import com.huchaishi.hibernate.adminuser.AdminUser;
import com.huchaishi.hibernate.adminuser.AdminUserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class ChangeAdminPasswordAction {
	
	private String password;
	private String newpassword;
	
	
	
	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getNewpassword() {
		return newpassword;
	}



	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}



	public String execute(){
	
		AdminUserFactory userDAO =new AdminUserFactory();
		
		AdminUser user =  userDAO.findByUserName("admin");
		
		if(user!=null){
			if(user.getAdminPassword().equals(password)){
				user.setAdminPassword(newpassword);
				userDAO.updateUser(user);
				ActionContext.getContext().put("message", "更新密码成功!");
				return Action.SUCCESS;
			}else{
				ActionContext.getContext().put("message", "密码输入错误!");
				return Action.ERROR;
			}
		}else{
			ActionContext.getContext().put("message", "密码输入错误!");
			return Action.ERROR;
		}
		
	
	}

}
