package com.huchaishi.action.web.link;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.huchaishi.hibernate.boundaccount.BoundAccount;
import com.huchaishi.hibernate.boundaccount.BoundAccountFactory;
import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BoundAcountAction extends ActionSupport {

	
	private String accountName;
	private int accountCredit;
	private File accountstorefile;				  //账号图片
	private String accountstorefileFileName;     //
	private String accountstorefileContentType;  // 
	
	


	public File getAccountstorefile() {
		return accountstorefile;
	}


	public void setAccountstorefile(File accountstorefile) {
		this.accountstorefile = accountstorefile;
	}


	public String getAccountstorefileFileName() {
		return accountstorefileFileName;
	}


	public void setAccountstorefileFileName(String accountstorefileFileName) {
		this.accountstorefileFileName = accountstorefileFileName;
	}


	public String getAccountstorefileContentType() {
		return accountstorefileContentType;
	}


	public void setAccountstorefileContentType(String accountstorefileContentType) {
		this.accountstorefileContentType = accountstorefileContentType;
	}


	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}


	public int getAccountCredit() {
		return accountCredit;
	}


	public void setAccountCredit(int accountCredit) {
		this.accountCredit = accountCredit;
	}


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
			List<BoundAccount> accountList =dao.findBoundAccoutByUserId(userId);
			
			if(accountList.size()<5){
				BoundAccount account = new BoundAccount();
				account.setBoundAccount(accountName);
				
				account.setBoundAccountcredit(String.valueOf(accountCredit));
				account.setUserName(userName);
				account.setUserId(userId);
				account.setBoundAccountstatus("1");
				uploadFile(account);
				
				dao.addBoundAccount(account);
				return Action.SUCCESS;
			}else{
				ActionContext request = ActionContext.getContext();
				request.put("error", "绑定账号不得超过5个！");
				return Action.ERROR;
			}
			
		}
		
		
		
		
		
		return SUCCESS;
	}
	

	// upload file to system
		private void uploadFile(BoundAccount account)  {
			
			
			try{
				String filePath = "./upload";
				Calendar cal=Calendar.getInstance();//使用日历类
				filePath = filePath + File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH)+1) + File.separator + cal.get(Calendar.DAY_OF_MONTH);
				String realpath = ServletActionContext.getServletContext().getRealPath(filePath);
			    if (accountstorefile != null ) {
		            File savefile = new File(new File(realpath), accountstorefileFileName);
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(accountstorefile, savefile);
		            account.setBoundAccountpicture((filePath+File.separator+accountstorefileFileName));
		            System.out.println("上传文件成功!");
		        }   
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("上传文件失败!"+e);
			}
		}
	
}