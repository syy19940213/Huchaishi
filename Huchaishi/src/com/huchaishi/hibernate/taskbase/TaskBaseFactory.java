package com.huchaishi.hibernate.taskbase;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;
public class TaskBaseFactory {
	
	public List findAll(){
		List taskBaseList = new ArrayList();
		Transaction tx = null; 
		TaskBaseDAO dao  = new TaskBaseDAO();
		try{
			tx = dao.getSession().beginTransaction();
			taskBaseList = dao.findAll();
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return taskBaseList;
	}

	public TaskBase finTaskBaseById(Integer taskId) {
		TaskBase taskbase = null;
		Transaction tx = null; 
		TaskBaseDAO dao  = new TaskBaseDAO();
		try{
			tx = dao.getSession().beginTransaction();
			taskbase = dao.findById(taskId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return taskbase;
	}

	public List<TaskBase> findTaskBaseByName(String taskName) {
		List taskBaseList = new ArrayList();
		Transaction tx = null; 
		TaskBaseDAO dao  = new TaskBaseDAO();
		try{
			tx = dao.getSession().beginTransaction();
			taskBaseList = dao.findByTaskName(taskName);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return taskBaseList;
	}

	public void updata(TaskBase task) {
		Transaction tx = null; 
		TaskBaseDAO dao  = new TaskBaseDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(task);
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

	public List<TaskBase> findTaskBaseByTaskNum(Integer taskType) {
		// TODO Auto-generated method stub
		List taskBaseList = new ArrayList();
		Transaction tx = null; 
		TaskBaseDAO dao  = new TaskBaseDAO();
		try{
			tx = dao.getSession().beginTransaction();
			taskBaseList = dao.findByTaskNum(taskType);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return taskBaseList;
	}

	
}
