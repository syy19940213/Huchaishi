package com.huchaishi.action.admin;

import java.util.List;


import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DelArticleAction extends ActionSupport{
	
	private Integer aticleId;
	
	
	public Integer getAticleId() {
		return aticleId;
	}


	public void setAticleId(Integer aticleId) {
		this.aticleId = aticleId;
	}


	public String execute(){
		AticleFactory dao  = new AticleFactory();
		dao.delArtcile(aticleId);
		
		List<Aticle> aticleList   =dao.findAll();
		ActionContext.getContext().put("aticleList", aticleList);
		return Action.SUCCESS;
		
	}

}
