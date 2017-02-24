package com.huchaishi.action.admin;

import com.huchaishi.hibernate.systemsomething.SystemSomething;
import com.huchaishi.hibernate.systemsomething.SystemSomethingFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoUpdateToArticle extends ActionSupport{
	
	public String execute(){
		SystemSomethingFactory dao = new SystemSomethingFactory();
		SystemSomething some = dao.findAll();
		ActionContext.getContext().put("some", some);
		
		
		return Action.SUCCESS;
	}

}
