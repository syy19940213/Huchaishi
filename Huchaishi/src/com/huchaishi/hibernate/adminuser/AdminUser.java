package com.huchaishi.hibernate.adminuser;

/**
 * AdminUser entity. @author MyEclipse Persistence Tools
 */
public class AdminUser extends AbstractAdminUser implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AdminUser() {
	}

	/** full constructor */
	public AdminUser(String adminUser, String adminPassword) {
		super(adminUser, adminPassword);
	}

}
