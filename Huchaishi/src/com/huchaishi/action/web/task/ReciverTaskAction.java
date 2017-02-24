package com.huchaishi.action.web.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.dialect.IngresDialect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.odps.CodecCheck.A;
import com.huchaishi.common.DateUtils;
import com.huchaishi.hibernate.accountlimit.AccountLimit;
import com.huchaishi.hibernate.accountlimit.AccountLimitFactory;
import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.ipaddr.Ipaddr;
import com.huchaishi.hibernate.ipaddr.IpaddrFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ReciverTaskAction extends ActionSupport{
	private int taskId;
	private String taskUserAccount;
	private int accountId;
	
	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskUserAccount() {
		return taskUserAccount;
	}

	public void setTaskUserAccount(String taskUserAccount) {
		this.taskUserAccount = taskUserAccount;
	}
	
	private String result;
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

	public String execute() {
		String flag = "true";
		String messag = "";
		
		BoundAccountFactory accountDao = new BoundAccountFactory();
		BoundAccount account = accountDao.findBoundAccoutById(accountId);
		taskUserAccount = account.getBoundAccount();
		
			TaskFactory taskDao = new TaskFactory();
			Task task1 = taskDao.findTaskById(taskId);
			if(task1.getTaskType()==3 || task1.getTaskType()==4){
				UserFactory userDao = new UserFactory();
				List<User> userList = userDao.findUserByUserName(String.valueOf(ActionContext.getContext().getSession().get("username")));
				if(userList.size()!=0){
					User user =userList.get(0);
					Double taskgold = user.getTaskGold();
					TaskBaseFactory taskBaskFactory = new TaskBaseFactory();
					Double getTaskConsume = taskBaskFactory.finTaskBaseById(task1.getTaskType()).getTaskGetConsume();
					if(getTaskConsume > taskgold){
						messag = "任务币不足!";
						flag = "false";
					}
				}
			}
			
			
		
		
			AccountLimitFactory limitDao = new AccountLimitFactory();
			List<AccountLimit> limitList = limitDao.findList();//查找接任务账号列表
			if(limitList.size()==0){
				AccountLimit limitaccount = new AccountLimit();
				
				Task task = taskDao.findTaskById(taskId);
				limitaccount.setGetUser(taskUserAccount);
				limitaccount.setSendUser(task.getTaskShopName());//9月5日 将获取发送人的账号，变成获取发送人的店铺名
				limitaccount.setGettime((System.currentTimeMillis()));
				limitDao.addLimit(limitaccount);
				if(!reciverTask()){
					flag = "false";
				}
			}else{
				AccountLimit limitaccount = new AccountLimit();
				
				Task task = taskDao.findTaskById(taskId);
				for(AccountLimit limit:limitList){
					//接任务名字相同
					if(limit.getGetUser().equals(taskUserAccount)){
						if(isThisTime(limit.getGettime(),"yyyy-MM")){
							if(limit.getSendUser().equals(task.getTaskShopName())){
								
								messag = "该账号本月已经接受过该用户的任务！请选择其他用户的任务！";
								flag = "false";
							}
						}
					}
				}
				
				limitaccount.setGetUser(taskUserAccount);
				limitaccount.setSendUser(task.getTaskShopName());
				limitaccount.setGettime((System.currentTimeMillis()));
				limitDao.addLimit(limitaccount);
				if(!reciverTask()){
					flag = "false";
				}
			}
		
		Map<String,String> data = new HashMap<String,String>();
		data.put("flag", flag);
		data.put("message", messag);
		result = JSON.toJSONString(data);
		
		return Action.SUCCESS;
	}
	
	private  boolean isThisTime(long time,String pattern) {  
        Date date = new Date(time);  
         SimpleDateFormat sdf = new SimpleDateFormat(pattern);  
         String param = sdf.format(date);//参数时间  
         String now = sdf.format(new Date());//当前时间  
         if(param.equals(now)){  
           return true;  
         }  
         return false;  
    }  
	

	private boolean reciverTask() {
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(taskId);
		int tasktype = task.getTaskType();
		
		if(tasktype==1 || tasktype ==2){
			int falg = task.getTaskIsmprice();//是否需要审核 1：是： 0 ：否
			if(falg==0){
				task.setTaskStauts(2);//设置为任务进行中
			}else{
				task.setTaskStauts(3);//设置为任务待审核
			}
		}else{
			TaskBaseFactory taskBaskFactory = new TaskBaseFactory();
			Double getTaskConsume = taskBaskFactory.finTaskBaseById(tasktype).getTaskGetConsume();
			UserFactory userDao = new UserFactory();
			List<User> userList = userDao.findUserByUserName(String.valueOf(ActionContext.getContext().getSession().get("username")));
			User user = userList.get(0);
			user.setTaskGold(user.getTaskGold()-getTaskConsume);
			userDao.updataUser(user);
			
		}
	
		long time = System.currentTimeMillis()/1000;
		task.setTaskGetTime(time);
		task.setTaskGetUser(String.valueOf(ActionContext.getContext().getSession().get("username")));
		task.setTaskUserAccount(taskUserAccount);
		
		taskDao.updateTask(task);
		
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		
		List<Task> taskList=taskDao.findTaskByGetUserName(userName);
		ActionContext request = ActionContext.getContext();
		request.put("tasklist", taskList);
		return true;
		
	}
}
