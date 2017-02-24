package com.huchaishi.action.web.task;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoUpdataTask extends ActionSupport{
	private int taskId;
	
	
	public int getTaskId() {
		return taskId;
	}


	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}


	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(taskId);
		ActionContext.getContext().put("task", task);
		return Action.SUCCESS;
	}
}
