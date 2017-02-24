package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.userapply.UserApply;
import com.huchaishi.hibernate.userapply.UserApplyFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;


public class ListUserMemberApplyAction {
	
	public  String execute() {
		
		UserApplyFactory applyDao = new UserApplyFactory();
		List<UserApply> list = applyDao.findAll();
		ActionContext.getContext().put("applyList", list);
		System.out.println(list);
		return Action.SUCCESS;
	}

}
