package com.huchaishi.action.web;

import com.huchaishi.hibernate.systemsomething.SystemSomething;
import com.huchaishi.hibernate.systemsomething.SystemSomethingFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoUrlAction extends ActionSupport{
	
	public String execute(){
		SystemSomethingFactory dao  = new SystemSomethingFactory();
		SystemSomething some = dao.findAll();
		String url = some.getUrl();
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		url = url+"/"+"goregiser?recommendUser="+userName;
		ActionContext.getContext().put("url", url);
		return Action.SUCCESS;
	}

}
