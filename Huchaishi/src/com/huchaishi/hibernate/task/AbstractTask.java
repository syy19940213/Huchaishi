package com.huchaishi.hibernate.task;

import java.util.Comparator;

/**
 * AbstractTask entity provides the base persistence definition of the Task
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTask implements java.io.Serializable {

	// Fields

	private Integer taskId;
	private Integer taskType;
	private String taskShopName;
	private String taskGoodsPictur;
	private String taskRequirePictur;
	private Integer taskPriceStatus;
	private Double taskGoodsPrice;
	private Integer taskPhoneOrPc;
	private Integer taskCredit;
	private Integer taskNum;
	private Integer taskSendtime;
	private Double taskReward;
	private Long taskSendTimestamp;
	private Integer taskIsmprice;
	private String taskSendUser;
	private String taskGetUser;
	private Integer taskStauts;
	private String taskUserAccount;
	private Double taskCostome;
	private String taskSearchword;
	private Long taskGetTime;
	private String sendTime;
	private String getTime;
	private Integer taskShowSend;
	private Integer taskShowGet;
	private Integer payWay;
	private Integer taskIstop;
	private String taskTopStarttime;
	private String taskTopEndtime;

	// Constructors

	/** default constructor */
	public AbstractTask() {
	}

	/** full constructor */
	public AbstractTask(Integer taskType, String taskShopName,
			String taskGoodsPictur, String taskRequirePictur,
			Integer taskPriceStatus, Double taskGoodsPrice,
			Integer taskPhoneOrPc, Integer taskCredit, Integer taskNum,
			Integer taskSendtime, Double taskReward, Long taskSendTimestamp,
			Integer taskIsmprice, String taskSendUser, String taskGetUser,
			Integer taskStauts, String taskUserAccount, Double taskCostome,
			String taskSearchword, Long taskGetTime, String sendTime,
			String getTime, Integer taskShowSend, Integer taskShowGet,
			Integer payWay, Integer taskIstop, String taskTopStarttime,
			String taskTopEndtime) {
		this.taskType = taskType;
		this.taskShopName = taskShopName;
		this.taskGoodsPictur = taskGoodsPictur;
		this.taskRequirePictur = taskRequirePictur;
		this.taskPriceStatus = taskPriceStatus;
		this.taskGoodsPrice = taskGoodsPrice;
		this.taskPhoneOrPc = taskPhoneOrPc;
		this.taskCredit = taskCredit;
		this.taskNum = taskNum;
		this.taskSendtime = taskSendtime;
		this.taskReward = taskReward;
		this.taskSendTimestamp = taskSendTimestamp;
		this.taskIsmprice = taskIsmprice;
		this.taskSendUser = taskSendUser;
		this.taskGetUser = taskGetUser;
		this.taskStauts = taskStauts;
		this.taskUserAccount = taskUserAccount;
		this.taskCostome = taskCostome;
		this.taskSearchword = taskSearchword;
		this.taskGetTime = taskGetTime;
		this.sendTime = sendTime;
		this.getTime = getTime;
		this.taskShowSend = taskShowSend;
		this.taskShowGet = taskShowGet;
		this.payWay = payWay;
		this.taskIstop = taskIstop;
		this.taskTopStarttime = taskTopStarttime;
		this.taskTopEndtime = taskTopEndtime;
	}

	// Property accessors

	public Integer getTaskId() {
		return this.taskId;
	}

	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}

	public Integer getTaskType() {
		return this.taskType;
	}

	public void setTaskType(Integer taskType) {
		this.taskType = taskType;
	}

	public String getTaskShopName() {
		return this.taskShopName;
	}

	public void setTaskShopName(String taskShopName) {
		this.taskShopName = taskShopName;
	}

	public String getTaskGoodsPictur() {
		return this.taskGoodsPictur;
	}

	public void setTaskGoodsPictur(String taskGoodsPictur) {
		this.taskGoodsPictur = taskGoodsPictur;
	}

	public String getTaskRequirePictur() {
		return this.taskRequirePictur;
	}

	public void setTaskRequirePictur(String taskRequirePictur) {
		this.taskRequirePictur = taskRequirePictur;
	}

	public Integer getTaskPriceStatus() {
		return this.taskPriceStatus;
	}

	public void setTaskPriceStatus(Integer taskPriceStatus) {
		this.taskPriceStatus = taskPriceStatus;
	}

	public Double getTaskGoodsPrice() {
		return this.taskGoodsPrice;
	}

	public void setTaskGoodsPrice(Double taskGoodsPrice) {
		this.taskGoodsPrice = taskGoodsPrice;
	}

	public Integer getTaskPhoneOrPc() {
		return this.taskPhoneOrPc;
	}

	public void setTaskPhoneOrPc(Integer taskPhoneOrPc) {
		this.taskPhoneOrPc = taskPhoneOrPc;
	}

	public Integer getTaskCredit() {
		return this.taskCredit;
	}

	public void setTaskCredit(Integer taskCredit) {
		this.taskCredit = taskCredit;
	}

	public Integer getTaskNum() {
		return this.taskNum;
	}

	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}

	public Integer getTaskSendtime() {
		return this.taskSendtime;
	}

	public void setTaskSendtime(Integer taskSendtime) {
		this.taskSendtime = taskSendtime;
	}

	public Double getTaskReward() {
		return this.taskReward;
	}

	public void setTaskReward(Double taskReward) {
		this.taskReward = taskReward;
	}

	public Long getTaskSendTimestamp() {
		return this.taskSendTimestamp;
	}

	public void setTaskSendTimestamp(Long taskSendTimestamp) {
		this.taskSendTimestamp = taskSendTimestamp;
	}

	public Integer getTaskIsmprice() {
		return this.taskIsmprice;
	}

	public void setTaskIsmprice(Integer taskIsmprice) {
		this.taskIsmprice = taskIsmprice;
	}

	public String getTaskSendUser() {
		return this.taskSendUser;
	}

	public void setTaskSendUser(String taskSendUser) {
		this.taskSendUser = taskSendUser;
	}

	public String getTaskGetUser() {
		return this.taskGetUser;
	}

	public void setTaskGetUser(String taskGetUser) {
		this.taskGetUser = taskGetUser;
	}

	public Integer getTaskStauts() {
		return this.taskStauts;
	}

	public void setTaskStauts(Integer taskStauts) {
		this.taskStauts = taskStauts;
	}

	public String getTaskUserAccount() {
		return this.taskUserAccount;
	}

	public void setTaskUserAccount(String taskUserAccount) {
		this.taskUserAccount = taskUserAccount;
	}

	public Double getTaskCostome() {
		return this.taskCostome;
	}

	public void setTaskCostome(Double taskCostome) {
		this.taskCostome = taskCostome;
	}

	public String getTaskSearchword() {
		return this.taskSearchword;
	}

	public void setTaskSearchword(String taskSearchword) {
		this.taskSearchword = taskSearchword;
	}

	public Long getTaskGetTime() {
		return this.taskGetTime;
	}

	public void setTaskGetTime(Long taskGetTime) {
		this.taskGetTime = taskGetTime;
	}

	public String getSendTime() {
		return this.sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public String getGetTime() {
		return this.getTime;
	}

	public void setGetTime(String getTime) {
		this.getTime = getTime;
	}

	public Integer getTaskShowSend() {
		return this.taskShowSend;
	}

	public void setTaskShowSend(Integer taskShowSend) {
		this.taskShowSend = taskShowSend;
	}

	public Integer getTaskShowGet() {
		return this.taskShowGet;
	}

	public void setTaskShowGet(Integer taskShowGet) {
		this.taskShowGet = taskShowGet;
	}

	public Integer getPayWay() {
		return this.payWay;
	}

	public void setPayWay(Integer payWay) {
		this.payWay = payWay;
	}

	public Integer getTaskIstop() {
		return this.taskIstop;
	}

	public void setTaskIstop(Integer taskIstop) {
		this.taskIstop = taskIstop;
	}

	public String getTaskTopStarttime() {
		return this.taskTopStarttime;
	}

	public void setTaskTopStarttime(String taskTopStarttime) {
		this.taskTopStarttime = taskTopStarttime;
	}

	public String getTaskTopEndtime() {
		return this.taskTopEndtime;
	}

	public void setTaskTopEndtime(String taskTopEndtime) {
		this.taskTopEndtime = taskTopEndtime;
	}

	

}