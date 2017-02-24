package com.huchaishi.action.web.task;

import java.util.List;

import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class FindArticleAction {
	
	
	public String execute(){
		AticleFactory atcileDao = new AticleFactory();
		List<Aticle> aticleList = atcileDao.findByStatus(1);
		Aticle aticle = aticleList.get(0);
		ActionContext.getContext().put("aticle", aticle);
		
		
		return Action.SUCCESS;
	}

}
