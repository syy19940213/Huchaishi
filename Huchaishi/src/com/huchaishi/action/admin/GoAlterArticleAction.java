package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class GoAlterArticleAction {
	private int aticleId;

	public int getAticleId() {
		return aticleId;
	}

	public void setAticleId(int aticleId) {
		this.aticleId = aticleId;
	}
	
	public String execute() {
		
		AticleFactory dao = new AticleFactory();
		Aticle aticleList =  dao.findById(aticleId);
		ActionContext.getContext().put("aticle", aticleList);
		
		
	
		
		return Action.SUCCESS;
		
		
		
	}
	
}
