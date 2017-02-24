package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.common.ComMethods;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class FindNeedPassTaskAction {
	
	
	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		List<Task> taskList = taskDao.findTaskByStatus(4);
		for(Task task:taskList){
			long time = task.getTaskGetTime();
			String timeGet = ComMethods.parse2DateStr(String.valueOf(time));
			task.setGetTime(timeGet);
			long sendTime = task.getTaskSendTimestamp();
			String timeSend = ComMethods.parse2DateStr(String.valueOf(sendTime));
			task.setSendTime(timeSend);
		}
		ActionContext.getContext().put("taskList", taskList);
		
		List<Task> helpList1 = taskDao.findTaskByType(3);
		List<Task> helpList2 = taskDao.findTaskByType(4);
		
		helpList1.addAll(helpList2);
		for(Task task:helpList1){
			if(task.getTaskGetTime()!=null){
				long time = task.getTaskGetTime();
				String timeGet = ComMethods.parse2DateStr(String.valueOf(time));
				task.setGetTime(timeGet);
			}

			long sendTime = task.getTaskSendTimestamp();
			String timeSend = ComMethods.parse2DateStr(String.valueOf(sendTime));
			task.setSendTime(timeSend);
		}
		
		ActionContext.getContext().put("helpList", helpList1);
		return Action.SUCCESS;
	}

}
