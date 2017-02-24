package com.huchaishi.hibernate.ipaddr;

import java.util.Date;

/**
 * Ipaddr entity. @author MyEclipse Persistence Tools
 */
public class Ipaddr extends AbstractIpaddr implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Ipaddr() {
	}

	/** full constructor */
	public Ipaddr(String ip, Integer tasknum, Date time) {
		super(ip, tasknum, time);
	}

	

}
