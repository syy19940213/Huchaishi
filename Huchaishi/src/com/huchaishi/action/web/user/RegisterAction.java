package com.huchaishi.action.web.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author pxk �û�ע����֤����ת
 */
@Entity
public class RegisterAction extends ActionSupport  {

	/**
	 * @return
	 */
	ArrayList<String> a = new ArrayList<String>();
	private String UserName;
	private String Password;
	private String UserQq;
	private String RealName;
	private String CardId;
	private String Email;
	private String PhoneNum;
	private String RecommendUser;

	public String getUserQq() {
		return UserQq;
	}

	public void setUserQq(String userQq) {
		UserQq = userQq;
	}

	public String getRealName() {
		return RealName;
	}

	public void setRealName(String realName) {
		RealName = realName;
	}

	public String getCardId() {
		return CardId;
	}

	public void setCardId(String cardId) {
		CardId = cardId;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public String getRecommendUser() {
		return RecommendUser;
	}

	public void setRecommendUser(String recommendUser) {
		RecommendUser = recommendUser;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String execute() {
		// TODO Auto-generated method stub
		try {
			UserFactory dao = new UserFactory();
			User user = new User();
			
			if (dao.existsName(UserName)) {  	
				ActionContext.getContext().put("message", "用户名重复！");
				return Action.ERROR;
			}else if(dao.existsUserQq(UserQq)) {
				ActionContext.getContext().put("message", "QQ号重复！");
				return Action.ERROR;
			}else if(dao.existsCardId(CardId)){
				ActionContext.getContext().put("message", "身份证重复");
				return Action.ERROR;
			}else if(dao.existsRealName(RealName)){
				ActionContext.getContext().put("message", "姓名重复");
				return Action.ERROR;
			}else if(dao.existsEmail(Email)){
				ActionContext.getContext().put("message", "email重复");
				return Action.ERROR;
			}
			else {

				user.setUserName(UserName);
				user.setUserPassword(Password);
				user.setUserQq(UserQq);
				user.setRealName(RealName);
				user.setCardId(CardId);
				user.setEmail(Email);
				user.setPhoneNum(PhoneNum);
				user.setRecommendUser(RecommendUser);
				user.setGold(Double.valueOf(0));
				user.setTaskGold(Double.valueOf(0));
				user.setBlackUser(1);
				user.setUserLevel(0);
			
				dao.addUser(user);
				ActionContext.getContext().getSession().put("username", UserName);
				ActionContext.getContext().getSession().put("taskgold", 0);				
				ActionContext.getContext().getSession().put("gold", 0);				
				ActionContext.getContext().getSession().put("userlevel", 0);
				//7.10注释，注册不奖励任务币
				if(RecommendUser!=null){
					UserFactory userDao = new UserFactory();
					List<User> userList = userDao.findUserByUserName(RecommendUser);
					if(userList.size()!=0){
						User user1 = userList.get(0);
						Double taskgold = user1.getTaskGold();
						taskgold = taskgold+1.0;
						user1.setTaskGold(taskgold);
						userDao.updataUser(user1);
					}
				}
				return Action.SUCCESS;
			}
		} catch (Exception e) {
			return Action.ERROR;
		}

	}

}