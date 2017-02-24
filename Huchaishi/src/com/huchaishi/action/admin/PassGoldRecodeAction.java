package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PassGoldRecodeAction extends ActionSupport{
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
			
			
			int userId = gold.getUserId();
			int flag = gold.getGoldFlag();
			Double goldAdd = gold.getGoldNum();
			
			
			UserFactory userDao  = new UserFactory();
			User user = userDao.findUserById(userId);
			Double usergold =  user.getGold();
			if(flag==1){
				
				usergold = usergold + goldAdd;
				user.setGold(usergold);
				userDao.updataUser(user);
				gold.setStatus("通过审核");
				goldDAO.update(gold);
				List<GoldRecord> goldList =goldDAO.findAll();
				ActionContext.getContext().put("goldList", goldList);
				return Action.SUCCESS;
			}
		
			if(flag==3){
					if(usergold >= goldAdd ){
						usergold = usergold - goldAdd;
						user.setGold(usergold);
						userDao.updataUser(user);
						gold.setStatus("通过审核");
						goldDAO.update(gold);
						List<GoldRecord> goldList =goldDAO.findAll();
						ActionContext.getContext().put("goldList", goldList);
						return Action.SUCCESS;
					}else{
						gold.setStatus("用户余额不足！");
						goldDAO.update(gold);
						ActionContext.getContext().put("error", "用户余额不足，不能提现！");
						return Action.ERROR;
					}
			}
				
		}
		
		return Action.SUCCESS;
		
		
	}

}
