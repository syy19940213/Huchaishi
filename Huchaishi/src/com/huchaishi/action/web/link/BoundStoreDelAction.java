package com.huchaishi.action.web.link;

import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BoundStoreDelAction extends ActionSupport{
	private Integer boundStoreid;
	private String boundStorename;
	public Integer getBoundStoreid() {
		return boundStoreid;
	}
	public void setBoundStoreid(Integer boundStoreid) {
		this.boundStoreid = boundStoreid;
	}
	public String getBoundStorename() {
		return boundStorename;
	}
	public void setBoundStorename(String boundStorename) {
		this.boundStorename = boundStorename;
	}
	
	
	public String execute() {
		BoundStore store =new BoundStore();
		store.setId(boundStoreid);
		store.setBoundStorename(boundStorename);
		BoundStoreFactory dao  = new BoundStoreFactory();
		dao.delBoundStore(store);
		return Action.SUCCESS;
	}

}
