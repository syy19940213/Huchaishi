package com.huchaishi.hibernate.boundaccount;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * BoundAccount entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.boundaccount.BoundAccount
 * @author MyEclipse Persistence Tools
 */
public class BoundAccountDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(BoundAccountDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String BOUND_ACCOUNT = "boundAccount";
	public static final String BOUND_ACCOUNTCREDIT = "boundAccountcredit";
	public static final String BOUND_ACCOUNTSTATUS = "boundAccountstatus";
	public static final String BOUND_ACCOUNTPICTURE = "boundAccountpicture";
	public static final String USER_NAME = "userName";

	public void save(BoundAccount transientInstance) {
		log.debug("saving BoundAccount instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BoundAccount persistentInstance) {
		log.debug("deleting BoundAccount instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BoundAccount findById(java.lang.Integer id) {
		log.debug("getting BoundAccount instance with id: " + id);
		try {
			BoundAccount instance = (BoundAccount) getSession().get(
					"com.huchaishi.hibernate.boundaccount.BoundAccount", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BoundAccount instance) {
		log.debug("finding BoundAccount instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.boundaccount.BoundAccount")
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
		log.debug("finding BoundAccount instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from BoundAccount as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByBoundAccount(Object boundAccount) {
		return findByProperty(BOUND_ACCOUNT, boundAccount);
	}

	public List findByBoundAccountcredit(Object boundAccountcredit) {
		return findByProperty(BOUND_ACCOUNTCREDIT, boundAccountcredit);
	}

	public List findByBoundAccountstatus(Object boundAccountstatus) {
		return findByProperty(BOUND_ACCOUNTSTATUS, boundAccountstatus);
	}

	public List findByBoundAccountpicture(Object boundAccountpicture) {
		return findByProperty(BOUND_ACCOUNTPICTURE, boundAccountpicture);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findAll() {
		log.debug("finding all BoundAccount instances");
		try {
			String queryString = "from BoundAccount";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BoundAccount merge(BoundAccount detachedInstance) {
		log.debug("merging BoundAccount instance");
		try {
			BoundAccount result = (BoundAccount) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BoundAccount instance) {
		log.debug("attaching dirty BoundAccount instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BoundAccount instance) {
		log.debug("attaching clean BoundAccount instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}