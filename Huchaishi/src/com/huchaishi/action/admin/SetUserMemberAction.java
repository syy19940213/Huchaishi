package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.huchaishi.hibernate.userapply.UserApply;
import com.huchaishi.hibernate.userapply.UserApplyFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class SetUserMemberAction {
	
	private int userId ;
	private int userLevel;
	private int applyId;
	
	public int getApplyId() {
		return applyId;
	}
	public void setApplyId(int applyId) {
		this.applyId = applyId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserLevel() {
		return userLevel;
	}
	public void setUserLevel(int userLevel) {
		this.userLevel = userLevel;
	}
	
	public  String execute() {
		//更新用户信息
		UserFactory userDao = new UserFactory();
		User user  = userDao.findUserById(userId);
		user.setUserLevel(userLevel);
		userDao.updataUser(user);
		
		
		// 更新申请列表信息
		UserApplyFactory applyDao = new UserApplyFactory();
		UserApply apply = applyDao.findById(applyId);
		apply.setStatus(1);
		applyDao.updateApply(apply);
		
		
		List<UserApply> list = applyDao.findAll();
		ActionContext.getContext().put("applyList", list);
		System.out.println(list);
		return Action.SUCCESS;
	}

}
