package com.huchaishi.hibernate.boundstore;

/**
 * BoundStore entity. @author MyEclipse Persistence Tools
 */
public class BoundStore extends AbstractBoundStore implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public BoundStore() {
	}

	/** full constructor */
	public BoundStore(Integer userId, String boundStorename,
			String boundStorepicture, Integer boundStatus, String userName) {
		super(userId, boundStorename, boundStorepicture, boundStatus, userName);
	}

}
