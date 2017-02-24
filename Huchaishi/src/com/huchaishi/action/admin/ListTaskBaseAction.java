package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListTaskBaseAction extends ActionSupport{

	public String execute() {
		TaskBaseFactory baskDao = new TaskBaseFactory();
		List<TaskBase> baseList = baskDao.findAll();
		ActionContext.getContext().put("baseList", baseList);
		return Action.SUCCESS;
	}
}
