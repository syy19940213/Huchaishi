package com.huchaishi.hibernate.goldrecord;

/**
 * GoldRecord entity. @author MyEclipse Persistence Tools
 */
public class GoldRecord extends AbstractGoldRecord implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public GoldRecord() {
	}

	/** full constructor */
	public GoldRecord(Integer userId, String userName, Double goldNum,
			String remark, Integer goldFlag, String payAccount, String status) {
		super(userId, userName, goldNum, remark, goldFlag, payAccount, status);
	}

}
