package com.huchaishi.action.web.check;

import java.util.List;

import com.huchaishi.hibernate.goldrecord.GoldRecord;
import com.huchaishi.hibernate.goldrecord.GoldRecordFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AmountAction extends ActionSupport {

	/**
	 * @return
	 */
	private String zhifubao;
	private Integer amountsum;
	
	public Integer getAmountsum() {
		return amountsum;
	}
	public void setAmountsum(Integer amountsum) {
		this.amountsum = amountsum;
	}
	public String getZhifubao() {
		return zhifubao;
	}
	public void setZhifubao(String zhifubao) {
		this.zhifubao = zhifubao;
	}

	public String execute() {
		

		String Name = String.valueOf(ActionContext.getContext().getSession().get("username"));
		UserFactory dao = new UserFactory();
		List<User> userList = dao.findUserByUserName(Name);

		if(userList.size()!=0){
			User user = userList.get(0);
			
			GoldRecord gold = new GoldRecord();
			gold.setUserId(user.getId());
			gold.setUserName(user.getUserName());
			gold.setGoldNum(Double.valueOf(amountsum));
			gold.setGoldFlag(3);
			gold.setRemark("金币提现");
			gold.setPayAccount(zhifubao);
			gold.setStatus("等待审核");
			GoldRecordFactory goldDao = new GoldRecordFactory();
			goldDao.addGoldRecord(gold);
			ActionContext request = ActionContext.getContext();
			request.put("success", "提现申请已提交");
		}
		return SUCCESS;
	}
}