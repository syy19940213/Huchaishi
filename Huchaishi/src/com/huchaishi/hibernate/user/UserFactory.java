package com.huchaishi.hibernate.user;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UserFactory {
	
	public List loginUser(User user){
		List userList = new ArrayList();
		Transaction tx = null; 
		UserDAO dao  = new UserDAO();
		try{
			tx = dao.getSession().beginTransaction();
			userList = dao.findByExample(user);
			tx.commit();
		} catch (HibernateException e) {
		    e.printStackTrace();
		    if(tx!=null)
		    	tx.rollback();
		} finally {
		    if(dao.getSession()!=null) 
		    	dao.getSession().close();
		}
		
	
		return userList;
	}


	public void addUser(User user) {

		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();			
			dao.save(user);			
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
	}

	public List findUserByUserName(User user) {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			tx = dao.getSession().beginTransaction();
			allList = dao.findByExample(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
		return allList;
	}

	public void updataUser(User user){
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();
			
			dao.merge(user);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
	}


	public boolean existsName(String userName) {
		
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();
			
			allList = dao.findByUserName(userName);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}

		//    allList Ϊ0   ˵   û            false
		if (allList != null) {
			if (allList.size() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}


	public List<User> findUserByUserName(String userName) {
		List<User> allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			tx = dao.getSession().beginTransaction();
			allList = dao.findByUserName(userName);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
		return allList;
		
	}


	public List<User> findAll() {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			tx = dao.getSession().beginTransaction();
			allList = dao.findAll();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
		return allList;
	}


	public User findUserById(Integer userId) {
		User user =null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			tx = dao.getSession().beginTransaction();
			user = dao.findById(userId);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
		return user;
	}


	public boolean existsUserQq(String userQq) {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();
			
			allList = dao.findByUserQq(userQq);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}

		//    allList Ϊ0   ˵   û            false
		if (allList != null) {
			if (allList.size() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}


	public boolean existsCardId(String cardId) {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();
			
			allList = dao.findByCardId(cardId);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}

		//    allList Ϊ0   ˵   û            false
		if (allList != null) {
			if (allList.size() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}


	public boolean existsRealName(String realName) {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();
			
			allList = dao.findByRealName(realName);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}

		//    allList Ϊ0   ˵   û            false
		if (allList != null) {
			if (allList.size() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}


	public boolean existsEmail(String email) {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			
			tx = dao.getSession().beginTransaction();
			
			allList = dao.findByEmail(email);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}

		//    allList Ϊ0   ˵   û            false
		if (allList != null) {
			if (allList.size() == 0) {
				return false;
			} else {
				return true;
			}
		} else {
			return true;
		}
	}


	public List<User> findUserByUserPhoneNume(String mobile) {
		List allList = null;
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			tx = dao.getSession().beginTransaction();
			allList = dao.findByPhoneNum(mobile);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
		return allList;
	}


	public void delUser(int userId) {
		Transaction tx = null;
		UserDAO dao = new UserDAO();
		try {
			tx = dao.getSession().beginTransaction();
			dao.delete(dao.findById(userId));
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null)
				tx.rollback();
		} finally {
			if (dao.getSession() != null)
				dao.getSession().close();
		}
	}


}
