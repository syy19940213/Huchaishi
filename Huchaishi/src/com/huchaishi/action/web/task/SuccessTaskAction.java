package com.huchaishi.action.web.task;

import java.util.List;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;


public class SuccessTaskAction extends ActionSupport{
	
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
		task.setTaskStauts(4);
		taskDao.updateTask(task);
		return Action.SUCCESS;
		
		
	}

}
