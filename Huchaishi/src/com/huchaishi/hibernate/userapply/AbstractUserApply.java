package com.huchaishi.hibernate.userapply;

/**
 * AbstractUserApply entity provides the base persistence definition of the
 * UserApply entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserApply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userDo;
	private Integer userLevel;
	private String userName;
	private Integer status;
	private String userQq;

	// Constructors

	/** default constructor */
	public AbstractUserApply() {
	}

	/** full constructor */
	public AbstractUserApply(Integer userId, String userDo, Integer userLevel,
			String userName, Integer status, String userQq) {
		this.userId = userId;
		this.userDo = userDo;
		this.userLevel = userLevel;
		this.userName = userName;
		this.status = status;
		this.userQq = userQq;
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

	public String getUserDo() {
		return this.userDo;
	}

	public void setUserDo(String userDo) {
		this.userDo = userDo;
	}

	public Integer getUserLevel() {
		return this.userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUserQq() {
		return this.userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

}