package com.huchaishi.action.web.task;

import java.util.List;


import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskGoldRecordFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class TaskReviewdAction extends ActionSupport{
	
	private Integer taskid;
	private Integer taskstatus;
	public Integer getTaskid() {
		return taskid;
	}
	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}
	public Integer getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(Integer taskstatus) {
		this.taskstatus = taskstatus;
	}
	
	public String execute(){
		//如果为2，则表示需通过审核
		if(taskstatus==2){
			TaskFactory taskDao = new TaskFactory();
			Task task = taskDao.findTaskById(taskid);
			task.setTaskStauts(2);
			taskDao.updateTask(task);
		}
		//任务完成后审核
		if(taskstatus==5){
			TaskFactory taskDao = new TaskFactory();
			Task task = taskDao.findTaskById(taskid);
			if(task.getTaskStauts()!=5){
				task.setTaskStauts(5);
				taskDao.updateTask(task);
				String getUserName = task.getTaskGetUser();
				UserFactory userDao  =new UserFactory();
				List<User> userList = userDao.findUserByUserName(getUserName);
				User user = userList.get(0);
				//更新用户的金币 或者任务币
				if(task.getTaskType()==1){
					Double gold = user.getGold();
					gold = gold + task.getTaskReward() ;
					
					//如果为平台押款，则加上本金
					if(task.getPayWay()==0){
						Double price = Double.valueOf(task.getTaskGoodsPrice());
						gold=  gold + price;
					}
					
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
					
				}else if( task.getTaskType()==2){
					Double gold = user.getGold();
					gold = gold + task.getTaskReward() ;
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
			
		}
		return Action.SUCCESS;
	}
	
	

}
