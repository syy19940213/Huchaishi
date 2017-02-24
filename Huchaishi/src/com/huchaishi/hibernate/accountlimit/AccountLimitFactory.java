package com.huchaishi.hibernate.accountlimit;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;



public class AccountLimitFactory {
	
	public List<AccountLimit> findList(){
		 List<AccountLimit>  list= new  ArrayList<AccountLimit>();
		Transaction tx = null; 
		AccountLimitDAO dao = new AccountLimitDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list=dao.findAll();
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

	public void addLimit(AccountLimit limitaccount) {

			Transaction tx = null; 
			AccountLimitDAO dao = new AccountLimitDAO();
			try{
				tx = dao.getSession().beginTransaction();
				dao.save(limitaccount);
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
