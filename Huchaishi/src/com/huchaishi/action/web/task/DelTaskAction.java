package com.huchaishi.action.web.task;

import java.util.List;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class DelTaskAction extends ActionSupport{
	
	private Integer taskid;

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	
	public String execute(){
		TaskFactory taskDao  = new TaskFactory();
		Task task = taskDao.findTaskById(taskid);
		String sendUserName = task.getTaskSendUser();
		
		UserFactory userDao = new UserFactory();
		List<User> userList = userDao.findUserByUserName(sendUserName);
		if(userList.size()!=0){
			User user = userList.get(0);
			if(task.getTaskType()==1 || task.getTaskType()==2){
				Double gold = user.getGold();
				gold = gold + task.getTaskCostome();
				user.setGold(gold);
				userDao.updataUser(user);
			}else if(task.getTaskType()==3 || task.getTaskType()==4){
//				屏蔽，互助区不删除不返回
//				Double taskGold = user.getTaskGold();
//				taskGold = taskGold + task.getTaskCostome();
//				user.setTaskGold(taskGold);
//				userDao.updataUser(user);
			}
			taskDao.delTask(taskid);
		}
		return Action.SUCCESS;
	}

}
