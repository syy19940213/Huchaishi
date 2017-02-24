package com.huchaishi.action.web.task;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class CheackIsTopAction {
	
	private Integer taskId;
	private Double taskGold;
	
	
	


	public Double getTaskGold() {
		return taskGold;
	}
	public void setTaskGold(Double taskGold) {
		this.taskGold = taskGold;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}


	private String result;


	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(taskId);
		
		UserFactory userDao = new UserFactory();
		List<User> userList=userDao.findUserByUserName(String.valueOf(ActionContext.getContext().getSession().get("username")));
		User user = userList.get(0);
		
		TaskBaseFactory baseDao = new TaskBaseFactory();
		TaskBase base = baseDao.finTaskBaseById(task.getTaskType());
		String json =null;
		
		if(base.getTaskTopConsume() > user.getTaskGold()){
			json = JSON.toJSONString("任务币不足!请充值!");//将map对象转换成json类型数据
		}else{
			json = JSON.toJSONString("1");
			Double gold = user.getTaskGold() - base.getTaskTopConsume();
			user.setTaskGold(gold);
			userDao.updataUser(user);
		}
		
		result = json;
		
		return Action.SUCCESS;
	}

}
