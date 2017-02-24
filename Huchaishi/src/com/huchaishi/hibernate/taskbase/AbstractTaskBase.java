package com.huchaishi.hibernate.taskbase;

/**
 * AbstractTaskBase entity provides the base persistence definition of the
 * TaskBase entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTaskBase implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer taskNum;
	private String taskName;
	private Double taskCommission;
	private Double taskConsume;
	private Double taskGetConsume;
	private Double taskTopConsume;

	// Constructors

	/** default constructor */
	public AbstractTaskBase() {
	}

	/** full constructor */
	public AbstractTaskBase(Integer taskNum, String taskName,
			Double taskCommission, Double taskConsume, Double taskGetConsume,
			Double taskTopConsume) {
		this.taskNum = taskNum;
		this.taskName = taskName;
		this.taskCommission = taskCommission;
		this.taskConsume = taskConsume;
		this.taskGetConsume = taskGetConsume;
		this.taskTopConsume = taskTopConsume;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTaskNum() {
		return this.taskNum;
	}

	public void setTaskNum(Integer taskNum) {
		this.taskNum = taskNum;
	}

	public String getTaskName() {
		return this.taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public Double getTaskCommission() {
		return this.taskCommission;
	}

	public void setTaskCommission(Double taskCommission) {
		this.taskCommission = taskCommission;
	}

	public Double getTaskConsume() {
		return this.taskConsume;
	}

	public void setTaskConsume(Double taskConsume) {
		this.taskConsume = taskConsume;
	}

	public Double getTaskGetConsume() {
		return this.taskGetConsume;
	}

	public void setTaskGetConsume(Double taskGetConsume) {
		this.taskGetConsume = taskGetConsume;
	}

	public Double getTaskTopConsume() {
		return this.taskTopConsume;
	}

	public void setTaskTopConsume(Double taskTopConsume) {
		this.taskTopConsume = taskTopConsume;
	}

}