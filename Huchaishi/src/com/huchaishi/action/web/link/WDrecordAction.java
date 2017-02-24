package com.huchaishi.action.web.link;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class WDrecordAction extends ActionSupport {

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