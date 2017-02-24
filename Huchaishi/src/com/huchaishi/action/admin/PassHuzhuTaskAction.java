package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PassHuzhuTaskAction extends ActionSupport{
	
	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		List<Task> taskList = taskDao.findTaskByStatus(4);
		ActionContext.getContext().put("taskList", taskList);
		return Action.SUCCESS;
	}

}
