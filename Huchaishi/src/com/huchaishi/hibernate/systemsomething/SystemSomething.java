package com.huchaishi.hibernate.systemsomething;

/**
 * SystemSomething entity. @author MyEclipse Persistence Tools
 */
public class SystemSomething extends AbstractSystemSomething implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public SystemSomething() {
	}

	/** minimal constructor */
	public SystemSomething(Integer id) {
		super(id);
	}

	/** full constructor */
	public SystemSomething(Integer id, String url, Integer aticleid,
			String aticleName) {
		super(id, url, aticleid, aticleName);
	}

}
