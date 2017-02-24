package com.huchaishi.hibernate.userapply;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.huchaishi.hibernate.user.User;



public class UserApplyFactory {
	
	public void addApply(UserApply apply){
		Transaction tx = null; 
		UserApplyDAO dao  = new UserApplyDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.save(apply);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		
	}
	
	//查找未处理的申请
	public List<UserApply> findAll(){
		List<UserApply> applyList = new ArrayList<UserApply>();
		Transaction tx = null; 
		UserApplyDAO dao  = new UserApplyDAO();
		try{
			tx = dao.getSession().beginTransaction();
			applyList = dao.findByStatus(0);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return applyList;
	}
	
	
	public UserApply findById(int id){
		UserApply apply =null;
		Transaction tx = null; 
		UserApplyDAO dao  = new UserApplyDAO();
		try{
			tx = dao.getSession().beginTransaction();
			apply = dao.findById(id);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return apply;
	}
	
	
	public void updateApply(UserApply id){

		Transaction tx = null; 
		UserApplyDAO dao  = new UserApplyDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(id);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
	}

}
