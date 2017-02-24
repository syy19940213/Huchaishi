package com.huchaishi.action.web.link;

import java.io.File;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.huchaishi.hibernate.boundstore.BoundStore;
import com.huchaishi.hibernate.boundstore.BoundStoreFactory;
import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.user.User;
import com.huchaishi.hibernate.user.UserFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BoundStoreAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 1L;  
	private String boundstorename;//店铺名称
	private File boundstorefile;				  //商品主图
	private String boundstorefileFileName;     //
	private String boundstorefileContentType;  // 
	
	

	public String getBoundstorename() {
		return boundstorename;
	}
	public void setBoundstorename(String boundstorename) {
		this.boundstorename = boundstorename;
	}
	public File getBoundstorefile() {
		return boundstorefile;
	}
	public void setBoundstorefile(File boundstorefile) {
		this.boundstorefile = boundstorefile;
	}
	public String getBoundstorefileFileName() {
		return boundstorefileFileName;
	}
	public void setBoundstorefileFileName(String boundstorefileFileName) {
		this.boundstorefileFileName = boundstorefileFileName;
	}
	public String getBoundstorefileContentType() {
		return boundstorefileContentType;
	}
	public void setBoundstorefileContentType(String boundstorefileContentType) {
		this.boundstorefileContentType = boundstorefileContentType;
	}


	/**
	 * 绑定店铺
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
			if(boundStoreList.size() < 3){
				BoundStore store = new BoundStore();
				store.setUserId(userId);
				store.setBoundStorename(boundstorename);
				store.setBoundStatus(1);
				store.setUserName(userName);
				uploadFile(store);
				return Action.SUCCESS;
			}else{
				ActionContext request = ActionContext.getContext();
				request.put("error", "绑定店铺不得超过3个！");
				return Action.ERROR;
			}
			
		}else{
			ActionContext request = ActionContext.getContext();
			request.put("error", "没有找到相关用户！");
			return Action.ERROR;
		}
		
	}
	
	
	// upload file to system
		private void uploadFile(BoundStore store)  {
			
			
			try{
				String filePath = "./upload";
				Calendar cal=Calendar.getInstance();//使用日历类
				filePath = filePath + File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH)+1) + File.separator + cal.get(Calendar.DAY_OF_MONTH);
				String realpath = ServletActionContext.getServletContext().getRealPath(filePath);
			    if (boundstorefile != null ) {
		            File savefile = new File(new File(realpath), boundstorefileFileName);
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(boundstorefile, savefile);
		            store.setBoundStorepicture((filePath+File.separator+boundstorefileFileName));
		            BoundStoreFactory dao = new BoundStoreFactory();
					dao.addBoundStore(store);
		            System.out.println("上传文件成功!");
		        }   
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("上传文件失败!"+e);
			}
		}
}