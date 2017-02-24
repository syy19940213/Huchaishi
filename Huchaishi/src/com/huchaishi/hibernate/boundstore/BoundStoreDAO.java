package com.huchaishi.hibernate.boundstore;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * BoundStore entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.boundstore.BoundStore
 * @author MyEclipse Persistence Tools
 */
public class BoundStoreDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(BoundStoreDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String BOUND_STORENAME = "boundStorename";
	public static final String BOUND_STOREPICTURE = "boundStorepicture";
	public static final String BOUND_STATUS = "boundStatus";
	public static final String USER_NAME = "userName";

	public void save(BoundStore transientInstance) {
		log.debug("saving BoundStore instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(BoundStore persistentInstance) {
		log.debug("deleting BoundStore instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public BoundStore findById(java.lang.Integer id) {
		log.debug("getting BoundStore instance with id: " + id);
		try {
			BoundStore instance = (BoundStore) getSession().get(
					"com.huchaishi.hibernate.boundstore.BoundStore", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(BoundStore instance) {
		log.debug("finding BoundStore instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.boundstore.BoundStore")
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
		log.debug("finding BoundStore instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from BoundStore as model where model."
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

	public List findByBoundStorename(Object boundStorename) {
		return findByProperty(BOUND_STORENAME, boundStorename);
	}

	public List findByBoundStorepicture(Object boundStorepicture) {
		return findByProperty(BOUND_STOREPICTURE, boundStorepicture);
	}

	public List findByBoundStatus(Object boundStatus) {
		return findByProperty(BOUND_STATUS, boundStatus);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findAll() {
		log.debug("finding all BoundStore instances");
		try {
			String queryString = "from BoundStore";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public BoundStore merge(BoundStore detachedInstance) {
		log.debug("merging BoundStore instance");
		try {
			BoundStore result = (BoundStore) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(BoundStore instance) {
		log.debug("attaching dirty BoundStore instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(BoundStore instance) {
		log.debug("attaching clean BoundStore instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}