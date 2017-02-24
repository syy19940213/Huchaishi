package com.huchaishi.hibernate.aticle;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.sql.Timestamp;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Aticle entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.aticle.Aticle
 * @author MyEclipse Persistence Tools
 */
public class AticleDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(AticleDAO.class);
	// property constants
	public static final String ATICLE_TITLE = "aticleTitle";
	public static final String ATICLE_CENTER = "aticleCenter";
	public static final String STATUS = "status";

	public void save(Aticle transientInstance) {
		log.debug("saving Aticle instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Aticle persistentInstance) {
		log.debug("deleting Aticle instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Aticle findById(java.lang.Integer id) {
		log.debug("getting Aticle instance with id: " + id);
		try {
			Aticle instance = (Aticle) getSession().get(
					"com.huchaishi.hibernate.aticle.Aticle", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Aticle instance) {
		log.debug("finding Aticle instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huchaishi.hibernate.aticle.Aticle")
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
		log.debug("finding Aticle instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Aticle as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAticleTitle(Object aticleTitle) {
		return findByProperty(ATICLE_TITLE, aticleTitle);
	}

	public List findByAticleCenter(Object aticleCenter) {
		return findByProperty(ATICLE_CENTER, aticleCenter);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all Aticle instances");
		try {
			String queryString = "from Aticle";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Aticle merge(Aticle detachedInstance) {
		log.debug("merging Aticle instance");
		try {
			Aticle result = (Aticle) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Aticle instance) {
		log.debug("attaching dirty Aticle instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Aticle instance) {
		log.debug("attaching clean Aticle instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}