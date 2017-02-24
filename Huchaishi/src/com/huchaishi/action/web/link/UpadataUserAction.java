package com.huchaishi.action.web.link;

import java.util.List;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpadataUserAction extends ActionSupport {

	/**
	 * @return
	 */
	private String Name;
	private String Email;
	private String RealName;
	private String PhoneNum;
	private String UserQq;
	private String userPassword;
	public String execute() {
		// TODO Auto-generated method stub
		
		if(ActionContext.getContext().getSession().get("username")==null){
			return ERROR;
		}
		Name=String.valueOf(ActionContext.getContext().getSession().get("username"));
		try {
			User user = new User();	
			user.setUserName(String.valueOf(Name));
			UserFactory dao = new UserFactory();
			List<User> allList = dao.findUserByUserName(user);
			if(allList.size()!=0){
				User userReture = allList.get(0);
				ActionContext.getContext().put("user", userReture);
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return SUCCESS;
	}
}