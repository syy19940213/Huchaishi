package com.huchaishi.action.admin;

import com.huchaishi.hibernate.aticle.Aticle;
import com.huchaishi.hibernate.aticle.AticleFactory;
import com.huchaishi.hibernate.systemsomething.SystemSomething;
import com.huchaishi.hibernate.systemsomething.SystemSomethingFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UpdateToArticle extends ActionSupport{
	
	private String aticleName;
	private String urlPath;
	public String getAticleName() {
		return aticleName;
	}
	public void setAticleName(String aticleName) {
		this.aticleName = aticleName;
	}
	public String getUrlPath() {
		return urlPath;
	}
	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
	
	
	public String execute(){
		
		AticleFactory atilceDao = new AticleFactory();
		Aticle aticle  = atilceDao.findByName(aticleName);
		SystemSomethingFactory dao = new SystemSomethingFactory();
		SystemSomething some = dao.findAll();
		if(aticle!=null){
			some.setAticleid(aticle.getId());
			some.setAticleName(aticleName);
			ActionContext.getContext().put("message", "信息更新成功");
		}else{
			ActionContext.getContext().put("message", "您输入的文章标题不存在");
			return Action.SUCCESS;
		}
		some.setUrl(urlPath);
		dao.update(some);
		SystemSomething some1 = dao.findAll();
		ActionContext.getContext().put("some", some1);
		
		return Action.SUCCESS;
	}

}
