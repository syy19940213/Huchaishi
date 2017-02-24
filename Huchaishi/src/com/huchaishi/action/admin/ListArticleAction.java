package com.huchaishi.action.admin;

import java.sql.Timestamp;
import java.util.List;

import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ListArticleAction extends ActionSupport{
	
	public String execute() {
		
		AticleFactory dao = new AticleFactory();
		List<Aticle> aticleList   =dao.findByStatus(0);
		ActionContext.getContext().put("aticleList", aticleList);
		
		
		List<Aticle> taskNotice   =dao.findByStatus(1);
		ActionContext.getContext().put("taskNotice", taskNotice);
		
		return Action.SUCCESS;
		
		
		
	}
}
