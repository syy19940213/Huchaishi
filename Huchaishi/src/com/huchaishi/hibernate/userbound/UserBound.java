package com.huchaishi.hibernate.userbound;

/**
 * UserBound entity. @author MyEclipse Persistence Tools
 */
public class UserBound extends AbstractUserBound implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserBound() {
	}

	/** minimal constructor */
	public UserBound(Integer id) {
		super(id);
	}

	/** full constructor */
	public UserBound(Integer id, String boundAcount, String boundStore,
			String aconutGrade, String storeSign, String acountSign,
			String boundObligate, String storeFile) {
		super(id, boundAcount, boundStore, aconutGrade, storeSign, acountSign,
				boundObligate, storeFile);
	}

}
