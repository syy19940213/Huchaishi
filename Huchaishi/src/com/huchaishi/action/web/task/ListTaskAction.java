package com.huchaishi.action.web.task;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 任务查找  ajax调用
 * @author syy
 *
 */
public class ListTaskAction extends ActionSupport{
	
	private String tasktype ; 
	private String pcorphone;
	private String taskcredit;
	private String taskgold;
	
	
	

	public String getTasktype() {
		return tasktype;
	}
	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	public String getPcorphone() {
		return pcorphone;
	}
	public void setPcorphone(String pcorphone) {
		this.pcorphone = pcorphone;
	}
	public String getTaskcredit() {
		return taskcredit;
	}
	public void setTaskcredit(String taskcredit) {
		this.taskcredit = taskcredit;
	}
	public String getTaskgold() {
		return taskgold;
	}
	public void setTaskgold(String taskgold) {
		this.taskgold = taskgold;
	}
	
	
	
	private String result;


	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}


	public String execute(){
		
		//先执行top查询操作
		UpdataTopTask top = new UpdataTopTask();
		top.updataTop();
		
		
		if(tasktype==null){
			this.tasktype = "1";
		}
		Task task = new Task();
		task.setTaskType(Integer.valueOf(tasktype));
		if(!pcorphone.equals("null")){
			task.setTaskPhoneOrPc(Integer.valueOf(pcorphone));
		}
		if(!taskcredit.equals("null")){
			task.setTaskCredit(Integer.valueOf(taskcredit));
		}
		if(!taskgold.equals("null")){
			task.setTaskPriceStatus(Integer.valueOf(taskgold));
		}
		task.setTaskStauts(1);
		
		TaskFactory dao = new TaskFactory();
		List<Task> tasklist = dao.findTaskList(task);
		
		Queue<Task> queue = new LinkedList<Task>();
		
		List<Integer> taskNumList = new ArrayList<Integer>();
		
		if(Integer.valueOf(tasktype) == 3 || Integer.valueOf(tasktype) == 4){

			List<Task> topList = dao.findTop(task);
			System.out.println(topList.size());
			for(Task t:topList){
				queue.add(t);
				taskNumList.add(Integer.valueOf(t.getTaskId()));
			}
		}
		

		
		for(Task t:tasklist){
			if(!taskNumList.contains(Integer.valueOf(t.getTaskId()))){
				queue.add(t);
			}			
		}
		
		
		

		String json = JSON.toJSONString(queue);//将map对象转换成json类型数据
		result = json;
		return Action.SUCCESS;
	}
}
