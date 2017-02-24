package com.huchaishi.hibernate.adminuser;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;


public class AdminUserFactory {

	public void updateUser(AdminUser user){
		Transaction tx = null; 
		AdminUserDAO dao = new AdminUserDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(user);
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
	
	public List<AdminUser> findByExample(AdminUser user){
		List<AdminUser> list = new ArrayList<AdminUser>();
		Transaction tx = null; 
		AdminUserDAO dao = new AdminUserDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list = dao.findByExample(user);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return list;
	}

	public AdminUser findByUserName(String userName) {
		List<AdminUser> list = new ArrayList<AdminUser>();
		Transaction tx = null; 
		AdminUserDAO dao = new AdminUserDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list = dao.findByAdminUser(userName);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		if(list.size()!=0){
			return list.get(0);
		}else{
			return null;
		}

	}

}
