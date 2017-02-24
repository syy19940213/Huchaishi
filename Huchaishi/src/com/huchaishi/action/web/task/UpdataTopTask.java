package com.huchaishi.action.web.task;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;

public class UpdataTopTask {
	
	

	public void updataTop(){
		
		TaskFactory taskDao  = new TaskFactory();
		List<Task> taskList = taskDao.findTaskByIsTop();
		
		for(Task task:taskList){
			long nowtime = System.currentTimeMillis()/1000;
			long endtime = Long.valueOf(task.getTaskTopEndtime());
			if(nowtime >= endtime){
				task.setTaskIstop(0);
				taskDao.updateTask(task);
				System.out.println("执行一次操作");
			}
		}
		
		System.out.println("执行一次比较");
		
	}

}
