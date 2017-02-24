package com.huchaishi.hibernate.boundstore;

/**
 * AbstractBoundStore entity provides the base persistence definition of the
 * BoundStore entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractBoundStore implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String boundStorename;
	private String boundStorepicture;
	private Integer boundStatus;
	private String userName;

	// Constructors

	/** default constructor */
	public AbstractBoundStore() {
	}

	/** full constructor */
	public AbstractBoundStore(Integer userId, String boundStorename,
			String boundStorepicture, Integer boundStatus, String userName) {
		this.userId = userId;
		this.boundStorename = boundStorename;
		this.boundStorepicture = boundStorepicture;
		this.boundStatus = boundStatus;
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

	public String getBoundStorename() {
		return this.boundStorename;
	}

	public void setBoundStorename(String boundStorename) {
		this.boundStorename = boundStorename;
	}

	public String getBoundStorepicture() {
		return this.boundStorepicture;
	}

	public void setBoundStorepicture(String boundStorepicture) {
		this.boundStorepicture = boundStorepicture;
	}

	public Integer getBoundStatus() {
		return this.boundStatus;
	}

	public void setBoundStatus(Integer boundStatus) {
		this.boundStatus = boundStatus;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}