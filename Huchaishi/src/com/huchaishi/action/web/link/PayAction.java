package com.huchaishi.action.web.link;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class PayAction extends ActionSupport {

	/**
	 * @return
	 */
	
	public  String goldsum;
	
	public String getGoldsum() {
		return goldsum;
	}

	public void setGoldsum(String goldsum) {
		this.goldsum = goldsum;
	}

	public String execute() {
		// TODO Auto-generated method stub
		System.out.println(goldsum);
		ActionContext.getContext().getSession().put("Goldsum", goldsum);
		return SUCCESS;
	}
}