package com.huchaishi.hibernate.task;

/**
 * Task entity. @author MyEclipse Persistence Tools
 */
public class Task extends AbstractTask {

	// Constructors

	/** default constructor */
	public Task() {
	}

	/** full constructor */
	public Task(Integer taskType, String taskShopName, String taskGoodsPictur,
			String taskRequirePictur, Integer taskPriceStatus,
			Double taskGoodsPrice, Integer taskPhoneOrPc, Integer taskCredit,
			Integer taskNum, Integer taskSendtime, Double taskReward,
			Long taskSendTimestamp, Integer taskIsmprice, String taskSendUser,
			String taskGetUser, Integer taskStauts, String taskUserAccount,
			Double taskCostome, String taskSearchword, Long taskGetTime,
			String sendTime, String getTime, Integer taskShowSend,
			Integer taskShowGet, Integer payWay, Integer taskIstop,
			String taskTopStarttime, String taskTopEndtime) {
		super(taskType, taskShopName, taskGoodsPictur, taskRequirePictur,
				taskPriceStatus, taskGoodsPrice, taskPhoneOrPc, taskCredit,
				taskNum, taskSendtime, taskReward, taskSendTimestamp,
				taskIsmprice, taskSendUser, taskGetUser, taskStauts,
				taskUserAccount, taskCostome, taskSearchword, taskGetTime,
				sendTime, getTime, taskShowSend, taskShowGet, payWay,
				taskIstop, taskTopStarttime, taskTopEndtime);
	}

	
	
	

}
