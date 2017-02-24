package com.huchaishi.hibernate.task;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;



public class TaskFactory {
	
	public void addTask(Task task){
		
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.save(task);
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
	

	public List<Task> findTaskList(Task task) {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findTaskList(task);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}
	
	
	public List<Task> findTop(Task task) {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findTop(task);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}
	
	public List<Task> findall() {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findAll();
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}

	public Task findTaskById(int id) {
		Task task = new Task();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			task = dao.findById(id);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return task;
	}

	public void updateTask(Task task) {
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			task = dao.merge(task);
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

	public List<Task> findTaskBySendUserName(String userName) {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findByTaskSendUser(userName);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}

	public List<Task> findTaskByGetUserName(String userName) {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findTaskByUserName(userName);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}

	public void delTask(Integer taskid) {
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.delete(dao.findById(taskid));
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

	public List<Task> findTaskByStatus(int status) {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findByTaskStauts(status);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}


	public List<Task> findTaskByType(int taskType) {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findByTaskType(taskType);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}


	public List<Task> findTaskByIsTop() {
		List<Task> listtask  = new ArrayList<Task>();
		Transaction tx = null; 
		TaskDAO dao  = new TaskDAO();
		try{
			tx = dao.getSession().beginTransaction();
			listtask = dao.findByTaskIstop(1);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return listtask;
	}

}
