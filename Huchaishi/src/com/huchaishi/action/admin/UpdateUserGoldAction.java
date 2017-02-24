package com.huchaishi.action.admin;

import java.util.List;


import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateUserGoldAction extends ActionSupport{
	
	private Double gold;
	private String userName;
	private String userQq ; 
	private String realName;
	private String phoneNum;
	private Double taskGold;
	
	

	
	public Double getTaskGold() {
		return taskGold;
	}
	public void setTaskGold(Double taskGold) {
		this.taskGold = taskGold;
	}
	public String getUserQq() {
		return userQq;
	}
	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Double getGold() {
		return gold;
	}
	public void setGold(Double gold) {
		this.gold = gold;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	public String execute(){
		UserFactory userDao = new UserFactory();
		List<User> userList = userDao.findUserByUserName(userName);
		if(userList.size()!=0){
			User user = userList.get(0);
			if(phoneNum!=null){
				if(user.getPhoneNum()==null || !user.getPhoneNum().equals(phoneNum)){
					List<User> phonelist = userDao.findUserByUserPhoneNume(phoneNum);
					if(phonelist.size()==0){
						user.setPhoneNum(phoneNum);
					}else {
						ActionContext.getContext().put("message", "该电话号码在已存在");
					}
				}
			}
			if(userQq!=null){
				if(user.getUserQq()==null || !user.getUserQq().equals(userQq)){
					if(!userDao.existsUserQq(userQq)){
						user.setUserQq(userQq);
					}else{
						ActionContext.getContext().put("message", "该QQ号码在已存在");
					}
				}
			}
			if(realName!=null){
				if(user.getRealName()==null || !user.getRealName().equals(realName)){
					if(!userDao.existsRealName(realName)){
						user.setRealName(realName);
					}else{
						ActionContext.getContext().put("message", "该姓名号码在已存在");
					}
				}
			}
			
			
			
			user.setGold(gold);
			user.setTaskGold(taskGold);
			userDao.updataUser(user);
			
			
			
		}
		return Action.SUCCESS;
	}

}
