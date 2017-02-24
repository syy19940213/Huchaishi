package com.huchaishi.hibernate.ipaddr;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;


public class IpaddrFactory {

	public void addIpaddr(Ipaddr gold){
		
		Transaction tx = null; 
		IpaddrDAO dao  = new IpaddrDAO();
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
	
	
	public List<Ipaddr> findByIP(String  ip){
		List<Ipaddr> list = new ArrayList<Ipaddr>();
		Transaction tx = null; 
		IpaddrDAO dao  = new IpaddrDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list=dao.findByIp(ip);
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


	public void update(Ipaddr ip) {
		Transaction tx = null; 
		IpaddrDAO dao  = new IpaddrDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(ip);
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
