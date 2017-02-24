package com.huchaishi.hibernate.taskgoldrecord;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import com.mysql.fabric.xmlrpc.base.Array;

public class TaskGoldRecordFactory {
	
	public void addTaskGoldRecord(TaskgoldRecord goldTaskRecord){
		Transaction tx = null; 
		TaskgoldRecordDAO dao = new TaskgoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.save(goldTaskRecord);
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

	public List<TaskgoldRecord> getTaskGoldListByUserName(String userName) {
		List<TaskgoldRecord> list =new ArrayList<TaskgoldRecord>();
		
		Transaction tx = null; 
		TaskgoldRecordDAO dao = new TaskgoldRecordDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list=dao.findByUserName(userName);
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

}
