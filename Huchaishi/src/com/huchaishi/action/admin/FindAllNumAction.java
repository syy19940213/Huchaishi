package com.huchaishi.action.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.userapply.UserApply;
import com.huchaishi.hibernate.userapply.UserApplyFactory;
import com.opensymphony.xwork2.Action;

public class FindAllNumAction {
	
	private String result;


	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	public String execute(){
		
		BoundAccountFactory accountDao = new BoundAccountFactory();
		List<BoundAccount> accountList = accountDao.findBoundAccoutByStaus("1");
		
		BoundStoreFactory storeDao = new BoundStoreFactory();
		List<BoundStore> storeList = storeDao.findBoundAccoutByStaus(1);
		
		GoldRecordFactory goldDao  = new GoldRecordFactory();
		List<GoldRecord> goldList  = goldDao.findByStatus("等待审核");
		
		TaskFactory taskDao = new TaskFactory();
		List<Task> taskList = taskDao.findTaskByStatus(4);
		
		UserApplyFactory applyDao = new UserApplyFactory();
		List<UserApply> applyList = applyDao.findAll();
		
		int accountSize = accountList.size();
		int storeSize = storeList.size();
		int goldSize = goldList.size();
		int taskSize = taskList.size();
		int applySize= applyList.size();
		
		
		
		
		
		
		Map<String , Integer> map = new HashMap<String,Integer>();
		map.put("account", accountSize);
		map.put("store", storeSize);
		map.put("gold", goldSize);
		map.put("task", taskSize);
		map.put("apply", applySize);
		String json = JSON.toJSONString(map);//将map对象转换成json类型数据
		result = json;
		return Action.SUCCESS;
	}

}
