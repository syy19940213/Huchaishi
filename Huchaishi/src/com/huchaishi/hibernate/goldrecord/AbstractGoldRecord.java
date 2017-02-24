package com.huchaishi.hibernate.goldrecord;

/**
 * AbstractGoldRecord entity provides the base persistence definition of the
 * GoldRecord entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGoldRecord implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userName;
	private Double goldNum;
	private String remark;
	private Integer goldFlag;
	private String payAccount;
	private String status;

	// Constructors

	/** default constructor */
	public AbstractGoldRecord() {
	}

	/** full constructor */
	public AbstractGoldRecord(Integer userId, String userName, Double goldNum,
			String remark, Integer goldFlag, String payAccount, String status) {
		this.userId = userId;
		this.userName = userName;
		this.goldNum = goldNum;
		this.remark = remark;
		this.goldFlag = goldFlag;
		this.payAccount = payAccount;
		this.status = status;
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

	public Double getGoldNum() {
		return this.goldNum;
	}

	public void setGoldNum(Double goldNum) {
		this.goldNum = goldNum;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getGoldFlag() {
		return this.goldFlag;
	}

	public void setGoldFlag(Integer goldFlag) {
		this.goldFlag = goldFlag;
	}

	public String getPayAccount() {
		return this.payAccount;
	}

	public void setPayAccount(String payAccount) {
		this.payAccount = payAccount;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}