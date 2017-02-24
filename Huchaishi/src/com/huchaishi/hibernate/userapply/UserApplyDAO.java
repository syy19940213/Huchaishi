package com.huchaishi.hibernate.userapply;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * UserApply entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.userapply.UserApply
 * @author MyEclipse Persistence Tools
 */
public class UserApplyDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UserApplyDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_DO = "userDo";
	public static final String USER_LEVEL = "userLevel";
	public static final String USER_NAME = "userName";
	public static final String STATUS = "status";
	public static final String USER_QQ = "userQq";

	public void save(UserApply transientInstance) {
		log.debug("saving UserApply instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(UserApply persistentInstance) {
		log.debug("deleting UserApply instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public UserApply findById(java.lang.Integer id) {
		log.debug("getting UserApply instance with id: " + id);
		try {
			UserApply instance = (UserApply) getSession().get(
					"com.huchaishi.hibernate.userapply.UserApply", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(UserApply instance) {
		log.debug("finding UserApply instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.userapply.UserApply")
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
		log.debug("finding UserApply instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from UserApply as model where model."
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

	public List findByUserDo(Object userDo) {
		return findByProperty(USER_DO, userDo);
	}

	public List findByUserLevel(Object userLevel) {
		return findByProperty(USER_LEVEL, userLevel);
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findByUserQq(Object userQq) {
		return findByProperty(USER_QQ, userQq);
	}

	public List findAll() {
		log.debug("finding all UserApply instances");
		try {
			String queryString = "from UserApply";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public UserApply merge(UserApply detachedInstance) {
		log.debug("merging UserApply instance");
		try {
			UserApply result = (UserApply) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(UserApply instance) {
		log.debug("attaching dirty UserApply instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(UserApply instance) {
		log.debug("attaching clean UserApply instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}