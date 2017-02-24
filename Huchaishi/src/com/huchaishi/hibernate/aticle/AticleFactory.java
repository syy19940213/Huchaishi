package com.huchaishi.hibernate.aticle;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class AticleFactory {
	
	public void addArticle(Aticle aticle){
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.save(aticle);
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
	
	public List<Aticle> findByStatus(int status) {
		List<Aticle> list = new ArrayList<Aticle>();
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list =dao.findByStatus(status);
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

	public List<Aticle> findAll() {
		List<Aticle> list = new ArrayList<Aticle>();
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			list =dao.findAll();
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

	public void delArtcile(Integer aticleId) {
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.delete(dao.findById(aticleId));
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

	public Aticle findById(Integer articleId) {
		Aticle aticle = null;
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			aticle = dao.findById(articleId);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		return aticle;
	}

	public Aticle findByName(String aticleName) {
		List<Aticle> aticleList = null;
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			aticleList = dao.findByAticleTitle(aticleName);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		Aticle aticle =null;
		if(aticleList.size()!=0){
			aticle = aticleList.get(0);
		}
		return aticle;
	}

	public void updata(Aticle aticle) {
		// TODO Auto-generated method stub
		Transaction tx = null; 
		AticleDAO dao = new AticleDAO();
		try{
			tx = dao.getSession().beginTransaction();
			dao.merge(aticle);
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
