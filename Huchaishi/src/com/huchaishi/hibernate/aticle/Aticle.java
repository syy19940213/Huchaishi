package com.huchaishi.hibernate.aticle;

import java.sql.Timestamp;

/**
 * Aticle entity. @author MyEclipse Persistence Tools
 */
public class Aticle extends AbstractAticle implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Aticle() {
	}

	/** full constructor */
	public Aticle(String aticleTitle, String aticleCenter,
			Timestamp aticleSenttime, Integer status) {
		super(aticleTitle, aticleCenter, aticleSenttime, status);
	}

}
