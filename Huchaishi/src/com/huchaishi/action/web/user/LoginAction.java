package com.huchaishi.action.web.user;



import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class LoginAction extends ActionSupport{
	
	private String userName;
	private String userPassword;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public String execute(){
		if(ActionContext.getContext().getSession().get("username")==null){
			User user = new User();
			user.setUserName(userName);
			user.setUserPassword(userPassword);
			
			UserFactory dao = new UserFactory();
			List<User> userList = dao.loginUser(user);
			if(userList.size()==0){
				return Action.ERROR;
			}else{
				User user1 = userList.get(0);
				if(user1.getBlackUser()==1){
					Double gold =user1.getGold();
					Double taskgold = user1.getTaskGold();
					ActionContext.getContext().getSession().put("taskgold", taskgold);				
					ActionContext.getContext().getSession().put("gold", gold);				
					ActionContext.getContext().getSession().put("username", userName);	
					ActionContext.getContext().getSession().put("id", user1.getId());	
					ActionContext.getContext().getSession().put("userlevel", user1.getUserLevel());
					return Action.SUCCESS;
				}else{
					return Action.ERROR;
				}
				
			}
		}		
		return Action.SUCCESS;	
	}

}
