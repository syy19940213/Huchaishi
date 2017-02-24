package com.huchaishi.action.web.user;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CheackRecommendUserAction {



	public String execute(){
		String recommendUser = ServletActionContext.getRequest().getParameter("recommendUser");
		ActionContext.getContext().put("recommenduser", recommendUser);
		
		return Action.SUCCESS;
	}
}
