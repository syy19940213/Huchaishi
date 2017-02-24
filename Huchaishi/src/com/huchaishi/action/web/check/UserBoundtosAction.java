package com.huchaishi.action.web.check;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.huchaishi.hibernate.userbound.UserBound;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserBoundtosAction extends ActionSupport {

	/**
	 * @return
	 */
	private Integer id;
	private String boundstore;// 店铺名称
	private File storefile;//店铺路径
	private String storefileFileName;     //
	private String storefileContentType;  // 
	
	public String getStorefileFileName() {
		return storefileFileName;
	}
	public void setStorefileFileName(String storefileFileName) {
		this.storefileFileName = storefileFileName;
	}
	public String getStorefileContentType() {
		return storefileContentType;
	}
	public void setStorefileContentType(String storefileContentType) {
		this.storefileContentType = storefileContentType;
	}
	public File getStorefile() {
		return storefile;
	}
	public void setStorefile(File storefile) {
		this.storefile = storefile;
	}
	public String getBoundstore() {
		return boundstore;
	}
	public void setBoundstore(String boundstore) {
		this.boundstore = boundstore;
	}
	public String execute() {
//		id=(Integer) ActionContext.getContext().getSession().get("id");
//		
//		// TODO Auto-generated method stub
//		try {
//			UserBound userbound =new UserBound();
//			String filePath = "./upload";
//			Calendar cal=Calendar.getInstance();//使用日历类
//			filePath = filePath + File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH)+1) + File.separator + cal.get(Calendar.DAY_OF_MONTH);
//			String realpath = ServletActionContext.getServletContext().getRealPath(filePath);
//			if (storefile != null  ) {
//				File savefile = new File(new File(realpath), storefileFileName);
//				 if (!savefile.getParentFile().exists())
//		                savefile.getParentFile().mkdirs();
//				 	FileUtils.copyFile(storefile, savefile);
//				 	userbound.setStoreFile((filePath+File.separator+storefileFileName));
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("上传失败");
//			
//		}
//		user 
//		System.out.println(id);
//		System.out.println(boundstore);
		
		return SUCCESS;
	}
}