package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class NotPassGoldRecodeAction extends ActionSupport{
	private Integer goldRecodeId;

	public Integer getGoldRecodeId() {
		return goldRecodeId;
	}

	public void setGoldRecodeId(Integer goldRecodeId) {
		this.goldRecodeId = goldRecodeId;
	}
	
	public String execute(){
		GoldRecordFactory goldDAO =new GoldRecordFactory();
		GoldRecord gold=goldDAO.getGoldListById(goldRecodeId);
		
		if(gold.getStatus().equals("等待审核")){
			gold.setStatus("不通过审核");
			goldDAO.update(gold);
		}
		List<GoldRecord> goldList =goldDAO.findAll();
		ActionContext.getContext().put("goldList", goldList);
		return Action.SUCCESS;
	}

}
