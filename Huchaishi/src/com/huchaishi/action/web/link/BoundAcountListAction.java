package com.huchaishi.action.web.link;

import java.util.List;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BoundAcountListAction extends ActionSupport {

	/**
	 * @return
	 */
	public String execute() {
		String userName = String.valueOf(ActionContext.getContext().getSession().get("username"));
		UserFactory userDao = new UserFactory();
		List<User> userList=userDao.findUserByUserName(userName);
		if(userList.size()!=0){
			int userId = userList.get(0).getId();
			BoundAccountFactory dao = new BoundAccountFactory();
			List<BoundAccount> accountList = dao.findBoundAccoutByUserId(userId);
			ActionContext request = ActionContext.getContext();
			request.put("accountList", accountList);
			System.out.println("accountList:"+accountList);
		}
		return SUCCESS;
	}
}