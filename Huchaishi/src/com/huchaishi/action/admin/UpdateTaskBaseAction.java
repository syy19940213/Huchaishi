package com.huchaishi.action.admin;

import java.util.List;


import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateTaskBaseAction  extends ActionSupport{
	private Integer taskNum;
	private String taskName;
	private Double taskCommission;
	private Double taskConsume;
	private Double taskGetConsume;
	private Double taskTopConsume;
	
	
	


	public Double getTaskTopConsume() {
		return taskTopConsume;
	}


	public void setTaskTopConsume(Double taskTopConsume) {
		this.taskTopConsume = taskTopConsume;
	}


	public Double getTaskGetConsume() {
		return taskGetConsume;
	}


	public void setTaskGetConsume(Double taskGetConsume) {
		this.taskGetConsume = taskGetConsume;
	}


	public Integer getTaskNum() {
		return taskNum;
	}


	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}


	public String getTaskName() {
		return taskName;
	}


	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}


	public Double getTaskCommission() {
		return taskCommission;
	}


	public void setTaskCommission(Double taskCommission) {
		this.taskCommission = taskCommission;
	}


	public Double getTaskConsume() {
		return taskConsume;
	}


	public void setTaskConsume(Double taskConsume) {
		this.taskConsume = taskConsume;
	}


	public String execute() {
		TaskBaseFactory baskDao = new TaskBaseFactory();
		TaskBase task = baskDao.finTaskBaseById(taskNum);
	
		task.setTaskCommission(taskCommission);
		task.setTaskConsume(taskConsume);
		task.setTaskGetConsume(taskGetConsume);
		if(taskTopConsume!=null){
			task.setTaskTopConsume(taskTopConsume);
		}
		baskDao.updata(task);
			
		
		List<TaskBase> baseList1 = baskDao.findAll();
		ActionContext.getContext().put("baseList", baseList1);
	
		return Action.SUCCESS;
	}

}
