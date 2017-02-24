package com.huchaishi.hibernate.accountlimit;

/**
 * AccountLimit entity. @author MyEclipse Persistence Tools
 */
public class AccountLimit extends AbstractAccountLimit implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public AccountLimit() {
	}

	/** full constructor */
	public AccountLimit(String getUser, String sendUser, Long gettime) {
		super(getUser, sendUser, gettime);
	}

}
