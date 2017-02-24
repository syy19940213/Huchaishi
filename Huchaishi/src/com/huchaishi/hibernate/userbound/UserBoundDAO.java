package com.huchaishi.hibernate.userbound;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserBound entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.userbound.UserBound
 * @author MyEclipse Persistence Tools
 */

public class UserBoundDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UserBoundDAO.class);
	// property constants
	public static final String BOUND_ACOUNT = "boundAcount";
	public static final String BOUND_STORE = "boundStore";
	public static final String ACONUT_GRADE = "aconutGrade";
	public static final String STORE_SIGN = "storeSign";
	public static final String ACOUNT_SIGN = "acountSign";
	public static final String BOUND_OBLIGATE = "boundObligate";
	public static final String STORE_FILE = "storeFile";

	public void save(UserBound transientInstance) {
		log.debug("saving UserBound instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserBound persistentInstance) {
		log.debug("deleting UserBound instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserBound findById(java.lang.Integer id) {
		log.debug("getting UserBound instance with id: " + id);
		try {
			UserBound instance = (UserBound) getSession().get(
					"com.huchaishi.hibernate.userbound.UserBound", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserBound instance) {
		log.debug("finding UserBound instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.userbound.UserBound")
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
		log.debug("finding UserBound instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserBound as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByBoundAcount(Object boundAcount) {
		return findByProperty(BOUND_ACOUNT, boundAcount);
	}

	public List findByBoundStore(Object boundStore) {
		return findByProperty(BOUND_STORE, boundStore);
	}

	public List findByAconutGrade(Object aconutGrade) {
		return findByProperty(ACONUT_GRADE, aconutGrade);
	}

	public List findByStoreSign(Object storeSign) {
		return findByProperty(STORE_SIGN, storeSign);
	}

	public List findByAcountSign(Object acountSign) {
		return findByProperty(ACOUNT_SIGN, acountSign);
	}

	public List findByBoundObligate(Object boundObligate) {
		return findByProperty(BOUND_OBLIGATE, boundObligate);
	}

	public List findByStoreFile(Object storeFile) {
		return findByProperty(STORE_FILE, storeFile);
	}

	public List findAll() {
		log.debug("finding all UserBound instances");
		try {
			String queryString = "from UserBound";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserBound merge(UserBound detachedInstance) {
		log.debug("merging UserBound instance");
		try {
			UserBound result = (UserBound) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserBound instance) {
		log.debug("attaching dirty UserBound instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserBound instance) {
		log.debug("attaching clean UserBound instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}