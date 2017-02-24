package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.common.ComMethods;
import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskDAO;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskGoldRecordFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PassTaskAction extends ActionSupport{
	
	private Integer taskId;

	public Integer getTaskId() {
		return taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	
	public String execute(){
		TaskFactory taskDao = new TaskFactory();
		Task  task = taskDao.findTaskById(taskId);
		if(task.getTaskStauts()!=5){
			task.setTaskStauts(5);
			taskDao.updateTask(task);
			long gettime = task.getTaskGetTime();
			String timeGet = ComMethods.parse2DateStr(String.valueOf(gettime));
			task.setGetTime(timeGet);
			String getUserName = task.getTaskGetUser();
			UserFactory userDao  =new UserFactory();
			List<User> userList = userDao.findUserByUserName(getUserName);
			User user = userList.get(0);
			//更新用户的金币 或者任务币
			if(task.getTaskType()==1  ){
				Double gold = user.getGold();
				gold = gold + task.getTaskReward();
				gold = gold +task.getTaskGoodsPrice();
				user.setGold(gold);
				userDao.updataUser(user);
				
				GoldRecord goldRecord = new GoldRecord();
				goldRecord.setUserId(user.getId());
				goldRecord.setUserName(user.getUserName());
				goldRecord.setGoldFlag(5);
				goldRecord.setGoldNum(task.getTaskReward());
				goldRecord.setRemark("完成任务所得");
				GoldRecordFactory goldrecordDao = new GoldRecordFactory();
				goldrecordDao.addGoldRecord(goldRecord);
				
			}else if(task.getTaskType()==2){
				Double gold = user.getGold();
				gold = gold + task.getTaskReward();
				user.setGold(gold);
				userDao.updataUser(user);
				
				GoldRecord goldRecord = new GoldRecord();
				goldRecord.setUserId(user.getId());
				goldRecord.setUserName(user.getUserName());
				goldRecord.setGoldFlag(5);
				goldRecord.setGoldNum(task.getTaskReward());
				goldRecord.setRemark("完成任务所得");
				GoldRecordFactory goldrecordDao = new GoldRecordFactory();
				goldrecordDao.addGoldRecord(goldRecord);
				
			}else{
				Double taskGold = user.getTaskGold();
				taskGold = taskGold + task.getTaskReward();
				user.setTaskGold(taskGold);
				userDao.updataUser(user);
				
				TaskgoldRecord taskgold = new TaskgoldRecord();
				taskgold.setUserId(user.getId());
				taskgold.setUserName(user.getUserName());
				taskgold.setRemark("完成任务所得");
				taskgold.setTaskGold(task.getTaskReward());
				taskgold.setTaskStatus(3);
				TaskGoldRecordFactory taskgoldDao = new TaskGoldRecordFactory();
				taskgoldDao.addTaskGoldRecord(taskgold);
			}
		}
		
		
		
		List<Task> taskList = taskDao.findTaskByStatus(4);
		ActionContext.getContext().put("taskList", taskList);
		
		return Action.SUCCESS;
	}
	

}
