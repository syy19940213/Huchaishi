package com.huchaishi.hibernate.boundaccount;

/**
 * BoundAccount entity. @author MyEclipse Persistence Tools
 */
public class BoundAccount extends AbstractBoundAccount implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public BoundAccount() {
	}

	/** full constructor */
	public BoundAccount(Integer userId, String boundAccount,
			String boundAccountcredit, String boundAccountstatus,
			String boundAccountpicture, String userName) {
		super(userId, boundAccount, boundAccountcredit, boundAccountstatus,
				boundAccountpicture, userName);
	}

}
