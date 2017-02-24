package com.huchaishi.action.web.link;

import java.util.List;


import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListrcenterAction extends ActionSupport {

	/**
	 * @return
	 */
	private Integer ID;
	private Object Name;
	private Object Gold;
	private Object Taskgold;
	private Object Email;
	private Object RealName;
	private Object PhoneNum;
	private Object UserQq;
	private int userLevel;
	public String execute() {
		// TODO Auto-generated method stub
		
		if(ActionContext.getContext().getSession().get("username")==null){
			System.out.println("111");
			return ERROR;
		}
		Name=ActionContext.getContext().getSession().get("username");
		try {
			User user = new User();	
			user.setUserName(String.valueOf(Name));
			UserFactory dao = new UserFactory();
			List<User> allList = dao.findUserByUserName(user);
			if(allList.size()!=0)
				Gold = allList.get(0).getGold();
				ID=allList.get(0).getId();
				Taskgold =allList.get(0).getTaskGold();
				Email=allList.get(0).getEmail();
				RealName =allList.get(0).getRealName();
				PhoneNum =allList.get(0).getPhoneNum();
				UserQq=allList.get(0).getUserQq();
				userLevel =allList.get(0).getUserLevel();
			ActionContext.getContext().getSession().put("gold", Gold);
			ActionContext.getContext().getSession().put("taskgold", Taskgold);
			ActionContext.getContext().getSession().put("id", ID);
			ActionContext.getContext().getSession().put("userLevel", userLevel);
		} catch (Exception e) {
			// TODO: handle exception
			return ERROR;
		}
		return SUCCESS;
	}
}