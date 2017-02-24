package com.huchaishi.action.web.link;

import java.util.List;



import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskGoldRecordFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BuyTaskGoldAction extends ActionSupport{
	
	private Double bugtakmoney;
	
	
	public Double getBugtakmoney() {
		return bugtakmoney;
	}


	public void setBugtakmoney(Double bugtakmoney) {
		this.bugtakmoney = bugtakmoney;
	}


	public String execute() {
		Double lastTaskGold = Double.valueOf(String.valueOf(ActionContext.getContext().getSession().get("gold")));
				
		if(lastTaskGold < bugtakmoney || lastTaskGold==0){
			ActionContext.getContext().put("message", "您的余额不足以兑换任务币！");
			return Action.ERROR;
		}else{
			String name = String.valueOf(ActionContext.getContext().getSession().get("username"));
			UserFactory userDao = new UserFactory();
			List<User> userList = userDao.findUserByUserName(name);
			if(userList.size()!=0){
				
				User user = userList.get(0);
				
				Double gold =user.getGold();
				Double taskgold = user.getTaskGold();
				gold = gold-bugtakmoney/2;//计算金币剩余
				taskgold = taskgold + bugtakmoney;//计算任务币个数
				
				user.setTaskGold(taskgold);
				user.setGold(gold);
				
				userDao.updataUser(user);
				
				
				GoldRecord goldrecord = new GoldRecord();
				goldrecord.setUserId(user.getId());
				goldrecord.setUserName(user.getUserName());
				Double goldNum = bugtakmoney;
				goldrecord.setGoldNum(goldNum);
				goldrecord.setRemark("兑换任务币");
				goldrecord.setGoldFlag(2);
				goldrecord.setStatus("兑换成功");
				GoldRecordFactory goldrecordDao = new GoldRecordFactory();
				goldrecordDao.update(goldrecord);
				
				
				TaskGoldRecordFactory taskgoldDAO = new TaskGoldRecordFactory();
				TaskgoldRecord taskgoldRecord = new TaskgoldRecord();
				taskgoldRecord.setUserId(user.getId());
				taskgoldRecord.setUserName(user.getUserName());
				taskgoldRecord.setRemark("任务币购买");
				taskgoldRecord.setTaskGold(bugtakmoney);
				taskgoldRecord.setTaskStatus(1);
				taskgoldDAO.addTaskGoldRecord(taskgoldRecord);
				
				
				
				ActionContext.getContext().getSession().put("gold", gold);
				ActionContext.getContext().put("message", "兑换成功！");
				return Action.SUCCESS;
			}else{
				ActionContext.getContext().put("message", "没有查找到相关信息！");
				return Action.ERROR;
			}
			
		}
		
	}

}
