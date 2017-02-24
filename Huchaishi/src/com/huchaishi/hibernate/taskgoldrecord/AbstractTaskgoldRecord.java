package com.huchaishi.hibernate.taskgoldrecord;

/**
 * AbstractTaskgoldRecord entity provides the base persistence definition of the
 * TaskgoldRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTaskgoldRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userName;
	private Double taskGold;
	private String remark;
	private Integer taskStatus;

	// Constructors

	/** default constructor */
	public AbstractTaskgoldRecord() {
	}

	/** full constructor */
	public AbstractTaskgoldRecord(Integer userId, String userName,
			Double taskGold, String remark, Integer taskStatus) {
		this.userId = userId;
		this.userName = userName;
		this.taskGold = taskGold;
		this.remark = remark;
		this.taskStatus = taskStatus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getTaskGold() {
		return this.taskGold;
	}

	public void setTaskGold(Double taskGold) {
		this.taskGold = taskGold;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getTaskStatus() {
		return this.taskStatus;
	}

	public void setTaskStatus(Integer taskStatus) {
		this.taskStatus = taskStatus;
	}

}