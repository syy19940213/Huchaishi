package com.huchaishi.action.admin;

import java.util.List;


import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class EidtTaskBaseAction  extends ActionSupport{
	private Integer taskId;
	
	
	public Integer getTaskId() {
		return taskId;
	}


	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}


	public String execute() {
		TaskBaseFactory baskDao = new TaskBaseFactory();
		TaskBase taskbase = baskDao.finTaskBaseById(taskId);
		ActionContext.getContext().put("taskbase", taskbase);
		return Action.SUCCESS;
	}

}
