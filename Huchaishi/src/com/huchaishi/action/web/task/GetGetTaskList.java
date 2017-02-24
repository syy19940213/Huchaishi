package com.huchaishi.action.web.task;

import java.util.List;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class GetGetTaskList {
	
	public String execute(){
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		TaskFactory taskDao = new TaskFactory();
		List<Task> taskList=taskDao.findTaskByGetUserName(userName);
		ActionContext request = ActionContext.getContext();
		request.put("tasklist", taskList);
		return Action.SUCCESS;
	}

}
