package com.huchaishi.action.web.task;

import java.util.List;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class DelTaskGetRecord {
	private int taskid ;

	public int getTaskid() {
		return taskid;
	}

	public void setTaskid(int taskid) {
		this.taskid = taskid;
	}
	
	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(taskid);
		task.setTaskShowGet(1);
		taskDao.updateTask(task);
		
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		List<Task> taskList=taskDao.findTaskBySendUserName(userName);
		ActionContext request = ActionContext.getContext();
		request.put("tasklist", taskList);
		return Action.SUCCESS;
	}

}
