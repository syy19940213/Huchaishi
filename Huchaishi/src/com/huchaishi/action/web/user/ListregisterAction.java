package com.huchaishi.action.web.user;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListregisterAction extends ActionSupport {

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		if(ActionContext.getContext().getSession().get("username")==null){
			return ERROR;
		}		
		return SUCCESS;
	}
}