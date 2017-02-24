package com.huchaishi.action.admin;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DelHelpTaskAction  extends ActionSupport{
	
	private Integer taskId;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(taskId);
		task.setTaskStauts(6);
		taskDao.updateTask(task);
		
		
		return Action.SUCCESS;
	}
}
