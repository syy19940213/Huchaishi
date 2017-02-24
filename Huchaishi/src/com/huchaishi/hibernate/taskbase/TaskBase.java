package com.huchaishi.hibernate.taskbase;

/**
 * TaskBase entity. @author MyEclipse Persistence Tools
 */
public class TaskBase extends AbstractTaskBase implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TaskBase() {
	}

	/** full constructor */
	public TaskBase(Integer taskNum, String taskName, Double taskCommission,
			Double taskConsume, Double taskGetConsume, Double taskTopConsume) {
		super(taskNum, taskName, taskCommission, taskConsume, taskGetConsume,
				taskTopConsume);
	}

}
