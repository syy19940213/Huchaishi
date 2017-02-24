package com.huchaishi.hibernate.accountlimit;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * AccountLimit entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.accountlimit.AccountLimit
 * @author MyEclipse Persistence Tools
 */
public class AccountLimitDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AccountLimitDAO.class);
	// property constants
	public static final String GET_USER = "getUser";
	public static final String SEND_USER = "sendUser";
	public static final String GETTIME = "gettime";

	public void save(AccountLimit transientInstance) {
		log.debug("saving AccountLimit instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(AccountLimit persistentInstance) {
		log.debug("deleting AccountLimit instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public AccountLimit findById(java.lang.Integer id) {
		log.debug("getting AccountLimit instance with id: " + id);
		try {
			AccountLimit instance = (AccountLimit) getSession().get(
					"com.huchaishi.hibernate.accountlimit.AccountLimit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(AccountLimit instance) {
		log.debug("finding AccountLimit instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.accountlimit.AccountLimit")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding AccountLimit instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from AccountLimit as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByGetUser(Object getUser) {
		return findByProperty(GET_USER, getUser);
	}

	public List findBySendUser(Object sendUser) {
		return findByProperty(SEND_USER, sendUser);
	}

	public List findByGettime(Object gettime) {
		return findByProperty(GETTIME, gettime);
	}

	public List findAll() {
		log.debug("finding all AccountLimit instances");
		try {
			String queryString = "from AccountLimit";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public AccountLimit merge(AccountLimit detachedInstance) {
		log.debug("merging AccountLimit instance");
		try {
			AccountLimit result = (AccountLimit) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(AccountLimit instance) {
		log.debug("attaching dirty AccountLimit instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(AccountLimit instance) {
		log.debug("attaching clean AccountLimit instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}