package com.huchaishi.hibernate.goldrecord;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;



public class GoldRecordFactory {
	
	public void addGoldRecord(GoldRecord gold){
			
			Transaction tx = null; 
			GoldRecordDAO dao  = new GoldRecordDAO();
			try{
				tx = dao.getSession().beginTransaction();
				dao.save(gold);
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
	
	public List<GoldRecord> getGoldListByUserId(Integer userId) {
		List<GoldRecord> goldList = new ArrayList<GoldRecord>();
		Transaction tx = null; 
		GoldRecordDAO dao  = new GoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			goldList=dao.findByUserId(userId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return goldList;
	}

	public List<GoldRecord> getGoldListByStatus(String status) {
		List<GoldRecord> goldList = new ArrayList<GoldRecord>();
		Transaction tx = null; 
		GoldRecordDAO dao  = new GoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			goldList=dao.findByStatus(status);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return goldList;
	}

	public GoldRecord getGoldListById(Integer goldRecodeId) {
		GoldRecord gold = null;
		Transaction tx = null; 
		GoldRecordDAO dao  = new GoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			gold = dao.findById(goldRecodeId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return gold;
	}

	public List<GoldRecord> findAll() {
		List<GoldRecord> goldList = new ArrayList<GoldRecord>();
		Transaction tx = null; 
		GoldRecordDAO dao  = new GoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			goldList=dao.findAll();
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return goldList;
	}

	public void update(GoldRecord gold) {
		Transaction tx = null; 
		GoldRecordDAO dao  = new GoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(gold);
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

	public List<GoldRecord> findByStatus(String status) {
		List<GoldRecord> goldList = new ArrayList<GoldRecord>();
		Transaction tx = null; 
		GoldRecordDAO dao  = new GoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			goldList=dao.findByStatus(status);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return goldList;
	}

}
