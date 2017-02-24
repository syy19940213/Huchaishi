package com.huchaishi.action.web.task;

import java.util.List;

import com.alibaba.fastjson.support.odps.CodecCheck.A;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetSendTaskList  extends ActionSupport{
	
	public String execute(){
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		TaskFactory taskDao = new TaskFactory();
		List<Task> taskList=taskDao.findTaskBySendUserName(userName);
		ActionContext request = ActionContext.getContext();
		request.put("tasklist", taskList);
		return Action.SUCCESS;
	}

}
