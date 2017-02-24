package com.huchaishi.hibernate.systemsomething;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;



public class SystemSomethingFactory {
	
public SystemSomething findAll(){
	 	SystemSomething list = null;
		Transaction tx = null; 
		SystemSomethingDAO dao  = new SystemSomethingDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list=dao.findById(1);
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

public void update(SystemSomething some) {
	
	Transaction tx = null; 
	SystemSomethingDAO dao  = new SystemSomethingDAO();
	try{
		tx = dao.getSession().beginTransaction();
		dao.merge(some);
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
