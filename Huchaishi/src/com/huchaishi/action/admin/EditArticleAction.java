package com.huchaishi.action.admin;

import java.sql.Timestamp;
import java.util.List;

import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class EditArticleAction {
	
	private String content;
	private int aticleId;
	
	
	
	
	public int getAticleId() {
		return aticleId;
	}




	public void setAticleId(int aticleId) {
		this.aticleId = aticleId;
	}




	public String getContent() {
		return content;
	}




	public void setContent(String content) {
		this.content = content;
	}




	public String execute() {
		AticleFactory aticleDao = new AticleFactory();
		Aticle aticle = aticleDao.findById(aticleId);
		aticle.setAticleCenter(content);
		Timestamp time = new Timestamp(System.currentTimeMillis()); 
		aticle.setAticleSenttime(time);
		aticle.setStatus(1);
		
		
		AticleFactory dao = new AticleFactory();
		dao.updata(aticle);
		
		List<Aticle> aticleList   =dao.findAll();
		ActionContext.getContext().put("aticleList", aticleList);
		
		return Action.SUCCESS;
		
		
		
	}

}
