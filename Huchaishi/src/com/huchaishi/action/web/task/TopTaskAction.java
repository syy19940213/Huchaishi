package com.huchaishi.action.web.task;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskDAO;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class TopTaskAction {
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
		task.setTaskIstop(1);
		long starttime = System.currentTimeMillis()/1000;
		long endtime = starttime + 60*60*24;
		task.setTaskTopStarttime(String.valueOf(starttime));
		task.setTaskTopEndtime(String.valueOf(endtime));
		taskDao.updateTask(task);
		
	
		
		ActionContext.getContext().put("message", "置顶成功！");
		
		return Action.SUCCESS;
	}

}
