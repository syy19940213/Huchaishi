package com.huchaishi.action.web.link;

import java.util.List;

import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetGoldRecordAction  extends ActionSupport{
	
	/**
	 * 获取金币记录
	 */
	public String execute() {
		String name = String.valueOf(ActionContext.getContext().getSession().get("username"));
		UserFactory userdao = new UserFactory();
		List<User> userList = userdao.findUserByUserName(name);
		if(userList.size()!=0){
			
			User user = userList.get(0);
			
			GoldRecordFactory goldDao = new GoldRecordFactory();
			List<GoldRecord> goldList = goldDao.getGoldListByUserId(user.getId());
			
			
			ActionContext request = ActionContext.getContext();
			request.put("goldList", goldList);
		}
		return Action.SUCCESS;
		
		
	}
}
