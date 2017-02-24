package com.huchaishi.hibernate.aticle;

import java.sql.Timestamp;

/**
 * AbstractAticle entity provides the base persistence definition of the Aticle
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAticle implements java.io.Serializable {

	// Fields

	private Integer id;
	private String aticleTitle;
	private String aticleCenter;
	private Timestamp aticleSenttime;
	private Integer status;

	// Constructors

	/** default constructor */
	public AbstractAticle() {
	}

	/** full constructor */
	public AbstractAticle(String aticleTitle, String aticleCenter,
			Timestamp aticleSenttime, Integer status) {
		this.aticleTitle = aticleTitle;
		this.aticleCenter = aticleCenter;
		this.aticleSenttime = aticleSenttime;
		this.status = status;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAticleTitle() {
		return this.aticleTitle;
	}

	public void setAticleTitle(String aticleTitle) {
		this.aticleTitle = aticleTitle;
	}

	public String getAticleCenter() {
		return this.aticleCenter;
	}

	public void setAticleCenter(String aticleCenter) {
		this.aticleCenter = aticleCenter;
	}

	public Timestamp getAticleSenttime() {
		return this.aticleSenttime;
	}

	public void setAticleSenttime(Timestamp aticleSenttime) {
		this.aticleSenttime = aticleSenttime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}