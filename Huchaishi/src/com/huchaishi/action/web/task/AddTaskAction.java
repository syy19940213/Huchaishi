package com.huchaishi.action.web.task;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;



import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.alibaba.fastjson.support.odps.CodecCheck.A;
import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.huchaishi.hibernate.taskbase.TaskBase;
import com.huchaishi.hibernate.taskbase.TaskBaseFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskGoldRecordFactory;
import com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class AddTaskAction extends ActionSupport{
 
	private String tasktypeselect;    //任务类型
	private String tname;             //绑定店铺名称
	private File goodsfile;				  //商品主图
	private String goodsfileFileName;     //
	private String goodsfileContentType;  // 
	
	private File requirePictur;				  //需求图片
	private String requirePicturContentType;  //
	private String requirePicturFileName;     //
	private Double shopprice;		  //商品价格
	private String searchword;
	private String taskClass;		  //pc or phone
	private String taskrank;		  //信誉要求
	private String ismprice;		  //是否需要审核
	private String payWay;           //0 平台押款 1 远程付款
	private Integer taskNum;			  //任务数量
	private String sendtime;		  //发布间隔时间
	private Double consume;			  //任务消耗
	private Double baseNum;        //佣金数量
	
	
	
	
	
	

	public String getPayWay() {
		return payWay;
	}
	public void setPayWay(String payWay) {
		this.payWay = payWay;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public Double getBaseNum() {
		return baseNum;
	}
	public void setBaseNum(Double baseNum) {
		this.baseNum = baseNum;
	}
	public Double getConsume() {
		return consume;
	}
	public void setConsume(Double consume) {
		this.consume = consume;
	}
	public File getGoodsfile() {
		return goodsfile;
	}
	public void setGoodsfile(File goodsfile) {
		this.goodsfile = goodsfile;
	}
	public String getGoodsfileFileName() {
		return goodsfileFileName;
	}
	public void setGoodsfileFileName(String goodsfileFileName) {
		this.goodsfileFileName = goodsfileFileName;
	}
	public String getGoodsfileContentType() {
		return goodsfileContentType;
	}
	public void setGoodsfileContentType(String goodsfileContentType) {
		this.goodsfileContentType = goodsfileContentType;
	}
	public File getRequirePictur() {
		return requirePictur;
	}
	public void setRequirePictur(File requirePictur) {
		this.requirePictur = requirePictur;
	}
	public String getRequirePicturContentType() {
		return requirePicturContentType;
	}
	public void setRequirePicturContentType(String requirePicturContentType) {
		this.requirePicturContentType = requirePicturContentType;
	}
	public String getRequirePicturFileName() {
		return requirePicturFileName;
	}
	public void setRequirePicturFileName(String requirePicturFileName) {
		this.requirePicturFileName = requirePicturFileName;
	}
	public String getTasktypeselect() {
		return tasktypeselect;
	}
	public void setTasktypeselect(String tasktypeselect) {
		this.tasktypeselect = tasktypeselect;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Double getShopprice() {
		return shopprice;
	}
	public void setShopprice(Double shopprice) {
		this.shopprice = shopprice;
	}
	public String getTaskClass() {
		return taskClass;
	}
	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}
	public String getTaskrank() {
		return taskrank;
	}
	public void setTaskrank(String taskrank) {
		this.taskrank = taskrank;
	}
	public String getIsmprice() {
		return ismprice;
	}
	public void setIsmprice(String ismprice) {
		this.ismprice = ismprice;
	}
	public Integer getTaskNum() {
		return taskNum;
	}
	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}
	public String getSendtime() {
		return sendtime;
	}
	public void setSendtime(String sendtime) {
		this.sendtime = sendtime;
	}

	
	private final long time = System.currentTimeMillis()/1000;
	
	
	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.ActionSupport#execute()
	 */
	public String execute(){
		for(int i =  0 ; i < taskNum;i++){
			Task task = new Task();
			task.setTaskType(Integer.valueOf(tasktypeselect));
			task.setTaskShopName(tname);
			task.setTaskGoodsPictur(goodsfileFileName);
			task.setTaskRequirePictur(requirePicturFileName);
			task.setTaskGoodsPrice(Double.valueOf(shopprice));
			task.setTaskSearchword(searchword);
			task.setTaskPhoneOrPc(Integer.valueOf(taskClass));
			task.setTaskCredit(Integer.valueOf(taskrank));
			task.setTaskNum(Integer.valueOf(taskNum));
			task.setTaskSendtime(Integer.valueOf(sendtime));
			task.setTaskCostome(consume/taskNum);
			task.setTaskIsmprice(Integer.valueOf(ismprice));
			task.setPayWay(Integer.valueOf(payWay));
			task.setTaskSendUser(String.valueOf(ActionContext.getContext().getSession().get("username")));
			task.setTaskStauts(1);
			task.setTaskShowGet(0);
			task.setTaskShowSend(0);
			task.setTaskIstop(0);
			if(shopprice <= 50){
				task.setTaskPriceStatus(1);
			}else if(shopprice <= 100 ){
				task.setTaskPriceStatus(2);
			}else if(shopprice <= 200 ){
				task.setTaskPriceStatus(3);
			}else if(shopprice <= 300 ){
				task.setTaskPriceStatus(4);
			}else if(shopprice <= 400 ){
				task.setTaskPriceStatus(5);
			}else{
				task.setTaskPriceStatus(6);
			}
			
			String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
			UserFactory userDao = new UserFactory();
			List<User> userList = userDao.findUserByUserName(userName);
			
			if(userList.size()!=0){
				User user = userList.get(0);
				if(tasktypeselect.equals("1") || tasktypeselect.equals("2")){
					Double gold = user.getGold();
					if(gold >= Double.valueOf(consume)){
						if(addTask(task,i)){
							
						}else{
							return Action.ERROR;
						}
						
					}else{
						ActionContext.getContext().put("message", "金币余额不足，请充值后再发布！");
						return Action.ERROR;
					}
				}else if(tasktypeselect.equals("3") || tasktypeselect.equals("4")){
					Double goldTask = user.getTaskGold();
					if(goldTask >= Double.valueOf(consume)){
						if(addTask(task,i)){
						
						}else{
							return Action.ERROR;
						}
						
					}else{
						ActionContext.getContext().put("message", "任务币余额不足，请充值后再发布！");
						return Action.ERROR;
					}
				}
			}else{
				ActionContext.getContext().put("message", "没有找到相关用户！");
				return Action.ERROR;
			}
		}
		
		UserFactory userDao = new UserFactory();
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		List<User> userList =userDao.findUserByUserName(userName);
		if(userList.size()!=0){
			if(tasktypeselect.equals("1") || tasktypeselect.equals("2")){
				User user =userList.get(0);
				Double gold = user.getGold();
				gold = gold - consume;
				user.setGold(gold);
				userDao.updataUser(user);
				//添加金币消费记录
				GoldRecord goldrecord = new GoldRecord();
				goldrecord.setUserId(user.getId());
				goldrecord.setUserName(user.getUserName());
				goldrecord.setGoldNum(consume);
				goldrecord.setRemark("任务发布消耗");
				goldrecord.setGoldFlag(4);
				GoldRecordFactory goldrecordDao = new GoldRecordFactory();
				goldrecordDao.addGoldRecord(goldrecord);
				
			}else if(tasktypeselect.equals("3") || tasktypeselect.equals("4")){
				User user =userList.get(0);
				Double gold = user.getTaskGold();
				gold = gold - consume;
				user.setTaskGold(gold);
				userDao.updataUser(user);
				
				TaskGoldRecordFactory taskgoldDao = new TaskGoldRecordFactory();
				TaskgoldRecord taskgold = new TaskgoldRecord();
				taskgold.setUserId(user.getId());
				taskgold.setUserName(user.getUserName());
				taskgold.setTaskGold(consume);
				taskgold.setRemark("任务发布消耗");
				taskgold.setTaskStatus(2);
				taskgoldDao.addTaskGoldRecord(taskgold);
				
			}
		}
		
		TaskFactory taskDao = new TaskFactory();
		List<Task> taskList=taskDao.findTaskBySendUserName(userName);
		ActionContext request = ActionContext.getContext();
		request.put("tasklist", taskList);
		
		return Action.SUCCESS;
		
		
		
	}
	
	/**
	 * add task to mysql  
	 */
	private boolean addTask(Task task,int i) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try{
			int taskNum = task.getTaskNum();
			
			
				uploadFile(task);
				//间隔时间发布任务，如果发布任务次数不为1
			
				UserFactory userDao = new UserFactory();
				String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
				List<User> userList =userDao.findUserByUserName(userName);
				if(userList.size()!=0){
					
					
					
					if(i==0){
						task.setTaskSendTimestamp(time);
					}else{
						long nowtime = time + 60*task.getTaskSendtime()*i;
						task.setTaskSendTimestamp(nowtime);
					}
					TaskFactory dao = new TaskFactory();
					TaskBaseFactory taskBaseDAO = new TaskBaseFactory();
					List<TaskBase> taskBaseList = taskBaseDAO.findTaskBaseByTaskNum(task.getTaskType());
					TaskBase taskBase=taskBaseList.get(0);
					Double reward=0.0;
					if(tasktypeselect.equals("1")){
						reward = baseNum - (baseNum * taskBase.getTaskCommission());
					}else{
						reward = consume / taskNum;
						reward = reward - (reward * taskBase.getTaskCommission());
					}
					
				
					task.setTaskReward(reward);
					dao.addTask(task);
				}
				
				
				
			
			flag =true;
		}catch (Exception e) {
			// TODO: handle exception 
			flag = false;
			System.out.println("添加任务失败"+e);
		}
		
		return flag;
		
	}
	
	// upload file to system
	private void uploadFile(Task task)  {
		
		
		try{
			String filePath = "./upload";
			Calendar cal=Calendar.getInstance();//使用日历类
			filePath = filePath + File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH)+1) + File.separator + cal.get(Calendar.DAY_OF_MONTH);
			String realpath = ServletActionContext.getServletContext().getRealPath(filePath);
		    if (goodsfile != null && requirePictur!=null ) {
	            File savefile = new File(new File(realpath), goodsfileFileName);
	            if (!savefile.getParentFile().exists())
	                savefile.getParentFile().mkdirs();
	            FileUtils.copyFile(goodsfile, savefile);
	            task.setTaskGoodsPictur((filePath+File.separator+goodsfileFileName));
	            File savefile1 = new File(new File(realpath), requirePicturFileName);
	            if (!savefile1.getParentFile().exists())
	                savefile1.getParentFile().mkdirs();
	            FileUtils.copyFile(requirePictur, savefile1);
	            task.setTaskRequirePictur((filePath+File.separator+requirePicturFileName));
	            System.out.println("上传文件成功!");
	        }   
		
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("上传文件失败!"+e);
		}
		
		
	}
	

}
