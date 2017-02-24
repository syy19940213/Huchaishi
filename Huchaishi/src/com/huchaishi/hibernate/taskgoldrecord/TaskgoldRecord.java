package com.huchaishi.hibernate.taskgoldrecord;

/**
 * TaskgoldRecord entity. @author MyEclipse Persistence Tools
 */
public class TaskgoldRecord extends AbstractTaskgoldRecord implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public TaskgoldRecord() {
	}

	/** full constructor */
	public TaskgoldRecord(Integer userId, String userName, Double taskGold,
			String remark, Integer taskStatus) {
		super(userId, userName, taskGold, remark, taskStatus);
	}

}
