package com.huchaishi.action.web.user;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.huchaishi.hibernate.userapply.UserApply;
import com.huchaishi.hibernate.userapply.UserApplyFactory;
import com.opensymphony.xwork2.Action;

public class ApplyUserMemberAction {
	
	private int userId ; 
	private String applyDo ;
	
	private String result;


	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getApplyDo() {
		return applyDo;
	}
	public void setApplyDo(String applyDo) {
		this.applyDo = applyDo;
	} 
	
	public String execute(){
		
		UserFactory userDao = new UserFactory();
		User user = userDao.findUserById(userId);
		
		UserApply userApply = new UserApply();
		userApply.setUserId(user.getId());
		userApply.setUserLevel(user.getUserLevel());
		userApply.setUserDo(applyDo);
		userApply.setUserName(user.getUserName());
		userApply.setStatus(0);
		userApply.setUserQq(user.getUserQq());
		
		UserApplyFactory applyDao = new UserApplyFactory();
		applyDao.addApply(userApply);
		
		String json = JSON.toJSONString("success");//将map对象转换成json类型数据
		result = json;
		
		return Action.SUCCESS;
	}

}
