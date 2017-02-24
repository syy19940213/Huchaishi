package com.huchaishi.hibernate.systemsomething;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * SystemSomething entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.systemsomething.SystemSomething
 * @author MyEclipse Persistence Tools
 */
public class SystemSomethingDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(SystemSomethingDAO.class);
	// property constants
	public static final String URL = "url";
	public static final String ATICLEID = "aticleid";
	public static final String ATICLE_NAME = "aticleName";

	public void save(SystemSomething transientInstance) {
		log.debug("saving SystemSomething instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SystemSomething persistentInstance) {
		log.debug("deleting SystemSomething instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SystemSomething findById(java.lang.Integer id) {
		log.debug("getting SystemSomething instance with id: " + id);
		try {
			SystemSomething instance = (SystemSomething) getSession().get(
					"com.huchaishi.hibernate.systemsomething.SystemSomething",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SystemSomething instance) {
		log.debug("finding SystemSomething instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.systemsomething.SystemSomething")
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
		log.debug("finding SystemSomething instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from SystemSomething as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUrl(Object url) {
		return findByProperty(URL, url);
	}

	public List findByAticleid(Object aticleid) {
		return findByProperty(ATICLEID, aticleid);
	}

	public List findByAticleName(Object aticleName) {
		return findByProperty(ATICLE_NAME, aticleName);
	}

	public List findAll() {
		log.debug("finding all SystemSomething instances");
		try {
			String queryString = "from SystemSomething";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SystemSomething merge(SystemSomething detachedInstance) {
		log.debug("merging SystemSomething instance");
		try {
			SystemSomething result = (SystemSomething) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SystemSomething instance) {
		log.debug("attaching dirty SystemSomething instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SystemSomething instance) {
		log.debug("attaching clean SystemSomething instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}