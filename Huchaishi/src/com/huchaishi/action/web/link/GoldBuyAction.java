package com.huchaishi.action.web.link;

import java.util.List;

import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.systemsomething.SystemSomething;
import com.huchaishi.hibernate.systemsomething.SystemSomethingDAO;
import com.huchaishi.hibernate.systemsomething.SystemSomethingFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoldBuyAction extends ActionSupport {

	private String goldsum;
	
	public String getGoldsum() {
		return goldsum;
	}

	public void setGoldsum(String goldsum) {
		this.goldsum = goldsum;
	}

	/**
	 * @return
	 */
	public String execute() {
		String userName =  String.valueOf(ActionContext.getContext().getSession().get("username"));
		UserFactory userdao = new UserFactory();
		List<User> userList = userdao.findUserByUserName(userName);
		if(userList.size()!=0){
			User user = userList.get(0);
			
			GoldRecord gold = new GoldRecord();
			gold.setUserId(user.getId());
			gold.setUserName(user.getUserName());
			gold.setGoldNum(Double.valueOf(goldsum));
			gold.setGoldFlag(1);
			gold.setRemark("金币充值");
			gold.setStatus("等待审核");
			GoldRecordFactory goldDao = new GoldRecordFactory();
			goldDao.addGoldRecord(gold);
			ActionContext request = ActionContext.getContext();
			request.put("success", "充值申请已提交");
			SystemSomethingFactory systemDAO = new SystemSomethingFactory();
			SystemSomething a = systemDAO.findAll();
			if(a!=null){
				request.put("aticleId",a.getAticleid());
		
			}else{
				request.put("success", "没有找到相关文档");
				return Action.ERROR;
			}
			
		}
			
		return SUCCESS;
	}
}