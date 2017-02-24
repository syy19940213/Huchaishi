package com.huchaishi.hibernate.userbound;

/**
 * AbstractUserBound entity provides the base persistence definition of the
 * UserBound entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractUserBound implements java.io.Serializable {

	// Fields

	private Integer id;
	private String boundAcount;
	private String boundStore;
	private String aconutGrade;
	private String storeSign;
	private String acountSign;
	private String boundObligate;
	private String storeFile;

	// Constructors

	/** default constructor */
	public AbstractUserBound() {
	}

	/** minimal constructor */
	public AbstractUserBound(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractUserBound(Integer id, String boundAcount, String boundStore,
			String aconutGrade, String storeSign, String acountSign,
			String boundObligate, String storeFile) {
		this.id = id;
		this.boundAcount = boundAcount;
		this.boundStore = boundStore;
		this.aconutGrade = aconutGrade;
		this.storeSign = storeSign;
		this.acountSign = acountSign;
		this.boundObligate = boundObligate;
		this.storeFile = storeFile;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBoundAcount() {
		return this.boundAcount;
	}

	public void setBoundAcount(String boundAcount) {
		this.boundAcount = boundAcount;
	}

	public String getBoundStore() {
		return this.boundStore;
	}

	public void setBoundStore(String boundStore) {
		this.boundStore = boundStore;
	}

	public String getAconutGrade() {
		return this.aconutGrade;
	}

	public void setAconutGrade(String aconutGrade) {
		this.aconutGrade = aconutGrade;
	}

	public String getStoreSign() {
		return this.storeSign;
	}

	public void setStoreSign(String storeSign) {
		this.storeSign = storeSign;
	}

	public String getAcountSign() {
		return this.acountSign;
	}

	public void setAcountSign(String acountSign) {
		this.acountSign = acountSign;
	}

	public String getBoundObligate() {
		return this.boundObligate;
	}

	public void setBoundObligate(String boundObligate) {
		this.boundObligate = boundObligate;
	}

	public String getStoreFile() {
		return this.storeFile;
	}

	public void setStoreFile(String storeFile) {
		this.storeFile = storeFile;
	}

}