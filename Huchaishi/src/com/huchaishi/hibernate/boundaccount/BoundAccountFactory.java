package com.huchaishi.hibernate.boundaccount;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;



public class BoundAccountFactory {
	
	
	public void addBoundAccount(BoundAccount boundStore){
		
		Transaction tx = null; 
		BoundAccountDAO dao  = new BoundAccountDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.save(boundStore);
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

	public List<BoundAccount> findBoundAccoutByUserId(int userId) {
		List<BoundAccount> accountList = new ArrayList<BoundAccount>();
		Transaction tx = null; 
		BoundAccountDAO dao  = new BoundAccountDAO();
		try{
			tx = dao.getSession().beginTransaction();
			accountList = dao.findByUserId(userId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return accountList;
	}

	public void delAccount(BoundAccount account) {
		Transaction tx = null; 
		BoundAccountDAO dao  = new BoundAccountDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.delete(account);
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

	public List<BoundAccount> findBoundAccoutByStaus(String status) {
		List<BoundAccount> accountList = new ArrayList<BoundAccount>();
		Transaction tx = null; 
		BoundAccountDAO dao  = new BoundAccountDAO();
		try{
			tx = dao.getSession().beginTransaction();
			accountList = dao.findByBoundAccountstatus(status);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return accountList;
	}

	public BoundAccount findBoundAccoutById(Integer accountId) {
		BoundAccount accountList =null;
		Transaction tx = null; 
		BoundAccountDAO dao  = new BoundAccountDAO();
		try{
			tx = dao.getSession().beginTransaction();
			accountList = dao.findById(accountId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return accountList;
	}

	public void updateBoundAccount(BoundAccount account) {
		Transaction tx = null; 
		BoundAccountDAO dao  = new BoundAccountDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(account);
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
