package com.huchaishi.action.web.task;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.huchaishi.hibernate.task.Task;
import com.huchaishi.hibernate.task.TaskFactory;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class UpdataTaskAction extends ActionSupport {
	
	private Integer idtask;
	
	private File goodsfile;				  //商品主图
	private String goodsfileFileName;     //
	private String goodsfileContentType;  // 
	
	private File requirePictur;				  //需求图片
	private String requirePicturContentType;  //
	private String requirePicturFileName;     //
	
	private String searchword;
	private String taskClass;		  //pc or phone
	private String taskrank;		  //信誉要求
	
	private Double shopprice;		  //商品价格
	
	
	
	public Double getShopprice() {
		return shopprice;
	}
	public void setShopprice(Double shopprice) {
		this.shopprice = shopprice;
	}
	public Integer getIdtask() {
		return idtask;
	}
	public void setIdtask(Integer idtask) {
		this.idtask = idtask;
	}
	public File getGoodsfile() {
		return goodsfile;
	}
	public void setGoodsfile(File goodsfile) {
		this.goodsfile = goodsfile;
	}
	public String getGoodsfileFileName() {
		return goodsfileFileName;
	}
	public void setGoodsfileFileName(String goodsfileFileName) {
		this.goodsfileFileName = goodsfileFileName;
	}
	public String getGoodsfileContentType() {
		return goodsfileContentType;
	}
	public void setGoodsfileContentType(String goodsfileContentType) {
		this.goodsfileContentType = goodsfileContentType;
	}
	public File getRequirePictur() {
		return requirePictur;
	}
	public void setRequirePictur(File requirePictur) {
		this.requirePictur = requirePictur;
	}
	public String getRequirePicturContentType() {
		return requirePicturContentType;
	}
	public void setRequirePicturContentType(String requirePicturContentType) {
		this.requirePicturContentType = requirePicturContentType;
	}
	public String getRequirePicturFileName() {
		return requirePicturFileName;
	}
	public void setRequirePicturFileName(String requirePicturFileName) {
		this.requirePicturFileName = requirePicturFileName;
	}
	public String getSearchword() {
		return searchword;
	}
	public void setSearchword(String searchword) {
		this.searchword = searchword;
	}
	public String getTaskClass() {
		return taskClass;
	}
	public void setTaskClass(String taskClass) {
		this.taskClass = taskClass;
	}
	public String getTaskrank() {
		return taskrank;
	}
	public void setTaskrank(String taskrank) {
		this.taskrank = taskrank;
	}
	
	public String execute(){
		
		TaskFactory taskDao = new TaskFactory();
		Task task = taskDao.findTaskById(idtask);

		if(goodsfile!=null){
			uploadFile(task);
		}
		if(requirePictur!=null){
			uploadFile(task);
		}
		
		task.setTaskSearchword(searchword);
		task.setTaskPhoneOrPc(Integer.valueOf(taskClass));
		task.setTaskCredit(Integer.valueOf(taskrank));
		task.setTaskGoodsPrice(shopprice);
	
		
		taskDao.updateTask(task);
		
		
		return Action.SUCCESS;
	}
	
	// upload file to system
		private void uploadFile(Task task)  {
			
			
			try{
				String filePath = "./upload";
				Calendar cal=Calendar.getInstance();//使用日历类
				filePath = filePath + File.separator + cal.get(Calendar.YEAR) + File.separator + (cal.get(Calendar.MONTH)+1) + File.separator + cal.get(Calendar.DAY_OF_MONTH);
				String realpath = ServletActionContext.getServletContext().getRealPath(filePath);
			    if (goodsfile != null ) {
		            File savefile = new File(new File(realpath), goodsfileFileName);
		            if (!savefile.getParentFile().exists())
		                savefile.getParentFile().mkdirs();
		            FileUtils.copyFile(goodsfile, savefile);
		            task.setTaskGoodsPictur((filePath+File.separator+goodsfileFileName));
		        }   
			    if(requirePictur!=null ){
			    	 File savefile1 = new File(new File(realpath), requirePicturFileName);
			            if (!savefile1.getParentFile().exists())
			                savefile1.getParentFile().mkdirs();
			            FileUtils.copyFile(requirePictur, savefile1);
			            task.setTaskRequirePictur((filePath+File.separator+requirePicturFileName));
			            System.out.println("上传文件成功!");
			    }
			
			}catch (Exception e) {
				// TODO: handle exception
				System.out.println("上传文件失败!"+e);
			}
			
			
		}

	

}
