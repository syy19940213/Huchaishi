package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListGoldRecodeAciton extends ActionSupport{

	
	public String execute(){
		
		GoldRecordFactory goldDAO =new GoldRecordFactory();
		
		List<GoldRecord> goldList =goldDAO.findByStatus("等待审核");
		ActionContext.getContext().put("goldList", goldList);
		return Action.SUCCESS;
		
	}
}
