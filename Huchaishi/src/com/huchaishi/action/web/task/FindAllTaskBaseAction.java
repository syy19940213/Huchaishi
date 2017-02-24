package com.huchaishi.action.web.task;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.odps.CodecCheck.A;
import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class FindAllTaskBaseAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	private HttpServletRequest request;
	private String result;

	public void setServletRequest(HttpServletRequest arg0) {
		this.request = arg0;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * 处理ajax请求
	 * @return SUCCESS
	 */
	public String execute(){
		
		try {
			
	        TaskBaseFactory dao = new TaskBaseFactory();
			List<TaskBase> list = dao.findAll();
			Map<String,String> map = new HashMap<String,String>();
			for(TaskBase task:list){
				map.put(String.valueOf(task.getTaskNum()), String.valueOf(task.getTaskConsume()));
			}
		
			
			String json = JSON.toJSONString(map);//将map对象转换成json类型数据
			System.out.println(json);
			result = json;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}


	
}