package com.huchaishi.action.web.link;

import java.util.List;

import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BoundStroeListAction extends ActionSupport {

	/**
	 * @return
	 */
	public String execute() {
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		UserFactory userDao = new UserFactory();
		List<User> userList=userDao.findUserByUserName(userName);
		if(userList.size()!=0){
			int userId = userList.get(0).getId();
			BoundStoreFactory dao = new BoundStoreFactory();
			List<BoundStore> boundStoreList=dao.findBoundStoreByUserId(userId);
			ActionContext request = ActionContext.getContext();
			request.put("boundList", boundStoreList);
			System.out.println("boundList:"+boundStoreList);
		}
		System.out.println("userList:"+userList);
		return Action.SUCCESS;
	}
}