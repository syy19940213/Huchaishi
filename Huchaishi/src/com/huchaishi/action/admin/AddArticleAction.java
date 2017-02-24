package com.huchaishi.action.admin;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.support.odps.CodecCheck.A;
import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class AddArticleAction extends ActionSupport{

	private String aticleName;
	private String content;
	
	
	public String getAticleName() {
		return aticleName;
	}


	public void setAticleName(String aticleName) {
		this.aticleName = aticleName;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public String execute() {
		Aticle aticle = new Aticle();
		aticle.setAticleTitle(aticleName);
		aticle.setAticleCenter(content);
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		aticle.setAticleSenttime(time);
		aticle.setStatus(0);
		
		AticleFactory dao = new AticleFactory();
		dao.addArticle(aticle);
		
		List<Aticle> aticleList   =dao.findAll();
		ActionContext.getContext().put("aticleList", aticleList);
		
		return Action.SUCCESS;
		
		
		
	}
}
