package com.huchaishi.action.web.task;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;

public class FindTaskByIdAction {
	
	private int taskId;
	
	private String result;


	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	
	public String execute(){
		
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(taskId);
		
		String sendTaskUser = task.getTaskSendUser();
		UserFactory userDao = new UserFactory();
		User user = userDao.findUserByUserName(sendTaskUser).get(0);
		
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("task", task);
		data.put("user", user);
		String json = JSON.toJSONString(data);
		result = json;
		
		
		return Action.SUCCESS;
	}

}
