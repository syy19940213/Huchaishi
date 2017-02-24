package com.huchaishi.hibernate.accountlimit;

/**
 * AbstractAccountLimit entity provides the base persistence definition of the
 * AccountLimit entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAccountLimit implements java.io.Serializable {

	// Fields

	private Integer id;
	private String getUser;
	private String sendUser;
	private Long gettime;

	// Constructors

	/** default constructor */
	public AbstractAccountLimit() {
	}

	/** full constructor */
	public AbstractAccountLimit(String getUser, String sendUser, Long gettime) {
		this.getUser = getUser;
		this.sendUser = sendUser;
		this.gettime = gettime;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGetUser() {
		return this.getUser;
	}

	public void setGetUser(String getUser) {
		this.getUser = getUser;
	}

	public String getSendUser() {
		return this.sendUser;
	}

	public void setSendUser(String sendUser) {
		this.sendUser = sendUser;
	}

	public Long getGettime() {
		return this.gettime;
	}

	public void setGettime(Long gettime) {
		this.gettime = gettime;
	}

}