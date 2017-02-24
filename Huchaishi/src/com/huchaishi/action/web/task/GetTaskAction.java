package com.huchaishi.action.web.task;

import java.util.List;


import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GetTaskAction extends ActionSupport{
	private String taskid;
	
	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String execute(){
		
		Task task = new Task();
		task.setTaskId(Integer.valueOf(taskid));
		TaskFactory dao = new TaskFactory();
		Task taskList = dao.findTaskById(Integer.valueOf(taskid));
		if(taskList!=null){
			ActionContext request = ActionContext.getContext();
			String shopName = taskList.getTaskShopName();
			char[] a = shopName.toCharArray();
			if(a.length>=3){
				for(int i = 1; i < 3;i++){
					a[i]='*';
				}
			}else{
				for(int i = 1; i < a.length;i++){
					a[i]='*';
				}
			}
			
			StringBuffer newname = new StringBuffer();
			for(char b:a){
				newname.append(b);
			}
			
			taskList.setTaskShopName(newname.toString());
			request.put("task", taskList);
			
			UserFactory userDao = new UserFactory();
			String sendUser = taskList.getTaskSendUser();
			List<User> sendUserList = userDao.findUserByUserName(sendUser);
			User sendUserMessage = sendUserList.get(0);
			request.put("user", sendUserMessage);
			
			
			String getUser = taskList.getTaskGetUser();
			List<User> getUserList = userDao.findUserByUserName(getUser);
			User getUserMessage = null;
			if(getUserList.size()!=0){
				getUserMessage = getUserList.get(0);
			}
			request.put("getuser", getUserMessage);
		
			String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
			
			List<User> userList=userDao.findUserByUserName(userName);
			if(userList.size()!=0){
				int userId = userList.get(0).getId();
				BoundAccountFactory dao1 = new BoundAccountFactory();
				List<BoundAccount> accountList =dao1.findBoundAccoutByUserId(userId);
				request.put("xiaohao", accountList);
				
			}
			
		}
		
		return Action.SUCCESS;
		
	}

}
