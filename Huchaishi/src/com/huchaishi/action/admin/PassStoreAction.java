package com.huchaishi.action.admin;

import java.util.List;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PassStoreAction extends ActionSupport {
	private Integer storeId;

	public Integer getStoreId() {
		return storeId;
	}

	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}

	public String execute() {

		BoundStoreFactory storeDao = new BoundStoreFactory();
		BoundStore store = storeDao.findBoundStoreById(storeId);
		if (store != null) {
			store.setBoundStatus(2);
			storeDao.updateBoundStore(store);
			BoundStoreFactory storedao = new BoundStoreFactory();
			Integer status =1;
			List<BoundStore> storelist = storedao.findBoundAccoutByStaus(status);		
			ActionContext.getContext().put("storelist", storelist);
			
			return Action.SUCCESS;
			
		} else {
			return Action.ERROR;
		}

	}

}
