package com.huchaishi.hibernate.userapply;

/**
 * UserApply entity. @author MyEclipse Persistence Tools
 */
public class UserApply extends AbstractUserApply implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public UserApply() {
	}

	/** full constructor */
	public UserApply(Integer userId, String userDo, Integer userLevel,
			String userName, Integer status, String userQq) {
		super(userId, userDo, userLevel, userName, status, userQq);
	}

}
