package com.huchaishi.hibernate.systemsomething;

/**
 * AbstractSystemSomething entity provides the base persistence definition of
 * the SystemSomething entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSystemSomething implements java.io.Serializable {

	// Fields

	private Integer id;
	private String url;
	private Integer aticleid;
	private String aticleName;

	// Constructors

	/** default constructor */
	public AbstractSystemSomething() {
	}

	/** minimal constructor */
	public AbstractSystemSomething(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractSystemSomething(Integer id, String url, Integer aticleid,
			String aticleName) {
		this.id = id;
		this.url = url;
		this.aticleid = aticleid;
		this.aticleName = aticleName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getAticleid() {
		return this.aticleid;
	}

	public void setAticleid(Integer aticleid) {
		this.aticleid = aticleid;
	}

	public String getAticleName() {
		return this.aticleName;
	}

	public void setAticleName(String aticleName) {
		this.aticleName = aticleName;
	}

}