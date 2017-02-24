package com.huchaishi.hibernate.boundstore;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;



public class BoundStoreFactory {
	
	public void addBoundStore(BoundStore boundStore){
		
		Transaction tx = null; 
		BoundStoreDAO dao  = new BoundStoreDAO();
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

	public List<BoundStore> findBoundStoreByUserId(int userId) {
		List<BoundStore> boundStoreList =new ArrayList<BoundStore>();
		Transaction tx = null; 
		BoundStoreDAO dao  = new BoundStoreDAO();
		try{
			tx = dao.getSession().beginTransaction();
			boundStoreList=dao.findByUserId(userId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return boundStoreList;
	}

	public void delBoundStore(BoundStore store) {
		Transaction tx = null; 
		BoundStoreDAO dao  = new BoundStoreDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.delete(store);
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
	
	public BoundStore findBoundStoreById(Integer storeId) {
		BoundStore storeList =null;
		Transaction tx = null; 
		BoundStoreDAO dao  = new BoundStoreDAO();
		try{
			tx = dao.getSession().beginTransaction();
			storeList = dao.findById(storeId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return storeList;
	}
	
	public void updateBoundStore(BoundStore store) {
		Transaction tx = null; 
		BoundStoreDAO dao  = new BoundStoreDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(store);
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
	
	public List<BoundStore> findBoundAccoutByStaus(Integer status) {
		List<BoundStore> accountList = new ArrayList<BoundStore>();
		Transaction tx = null; 
		BoundStoreDAO dao  = new BoundStoreDAO();
		try{
			tx = dao.getSession().beginTransaction();
			accountList = dao.findByBoundStatus(status);
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
}
