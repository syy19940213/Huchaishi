package com.huchaishi.hibernate.adminuser;

/**
 * AbstractAdminUser entity provides the base persistence definition of the
 * AdminUser entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdminUser implements java.io.Serializable {

	// Fields

	private Integer id;
	private String adminUser;
	private String adminPassword;

	// Constructors

	/** default constructor */
	public AbstractAdminUser() {
	}

	/** full constructor */
	public AbstractAdminUser(String adminUser, String adminPassword) {
		this.adminUser = adminUser;
		this.adminPassword = adminPassword;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAdminUser() {
		return this.adminUser;
	}

	public void setAdminUser(String adminUser) {
		this.adminUser = adminUser;
	}

	public String getAdminPassword() {
		return this.adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

}