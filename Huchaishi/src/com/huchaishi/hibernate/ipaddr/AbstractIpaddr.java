package com.huchaishi.hibernate.ipaddr;

import java.util.Date;

/**
 * AbstractIpaddr entity provides the base persistence definition of the Ipaddr
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractIpaddr implements java.io.Serializable {

	// Fields

	private Integer id;
	private String ip;
	private Integer tasknum;
	private Date time;

	// Constructors

	/** default constructor */
	public AbstractIpaddr() {
	}

	/** full constructor */
	public AbstractIpaddr(String ip, Integer tasknum, Date time) {
		this.ip = ip;
		this.tasknum = tasknum;
		this.time = time;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getTasknum() {
		return this.tasknum;
	}

	public void setTasknum(Integer tasknum) {
		this.tasknum = tasknum;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}