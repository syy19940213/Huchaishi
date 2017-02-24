package com.huchaishi.hibernate.boundaccount;

/**
 * AbstractBoundAccount entity provides the base persistence definition of the
 * BoundAccount entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBoundAccount implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String boundAccount;
	private String boundAccountcredit;
	private String boundAccountstatus;
	private String boundAccountpicture;
	private String userName;

	// Constructors

	/** default constructor */
	public AbstractBoundAccount() {
	}

	/** full constructor */
	public AbstractBoundAccount(Integer userId, String boundAccount,
			String boundAccountcredit, String boundAccountstatus,
			String boundAccountpicture, String userName) {
		this.userId = userId;
		this.boundAccount = boundAccount;
		this.boundAccountcredit = boundAccountcredit;
		this.boundAccountstatus = boundAccountstatus;
		this.boundAccountpicture = boundAccountpicture;
		this.userName = userName;
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

	public String getBoundAccount() {
		return this.boundAccount;
	}

	public void setBoundAccount(String boundAccount) {
		this.boundAccount = boundAccount;
	}

	public String getBoundAccountcredit() {
		return this.boundAccountcredit;
	}

	public void setBoundAccountcredit(String boundAccountcredit) {
		this.boundAccountcredit = boundAccountcredit;
	}

	public String getBoundAccountstatus() {
		return this.boundAccountstatus;
	}

	public void setBoundAccountstatus(String boundAccountstatus) {
		this.boundAccountstatus = boundAccountstatus;
	}

	public String getBoundAccountpicture() {
		return this.boundAccountpicture;
	}

	public void setBoundAccountpicture(String boundAccountpicture) {
		this.boundAccountpicture = boundAccountpicture;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}