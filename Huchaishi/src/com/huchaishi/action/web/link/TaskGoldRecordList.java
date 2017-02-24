package com.huchaishi.action.web.link;

import java.util.List;

import com.huchaishi.hibernate.taskgoldrecord.TaskGoldRecordFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TaskGoldRecordList extends ActionSupport{
	
	public String execute(){
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		
		TaskGoldRecordFactory taskgoldDao = new TaskGoldRecordFactory();
		List<TaskgoldRecord> taskgoldList = taskgoldDao.getTaskGoldListByUserName(userName);
		ActionContext.getContext().put("taskgoldList", taskgoldList);
		
		return Action.SUCCESS;
	}

}
