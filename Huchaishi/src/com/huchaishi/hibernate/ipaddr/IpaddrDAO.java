package com.huchaishi.hibernate.ipaddr;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ipaddr entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.ipaddr.Ipaddr
 * @author MyEclipse Persistence Tools
 */
public class IpaddrDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(IpaddrDAO.class);
	// property constants
	public static final String IP = "ip";
	public static final String TASKNUM = "tasknum";

	public void save(Ipaddr transientInstance) {
		log.debug("saving Ipaddr instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Ipaddr persistentInstance) {
		log.debug("deleting Ipaddr instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Ipaddr findById(java.lang.Integer id) {
		log.debug("getting Ipaddr instance with id: " + id);
		try {
			Ipaddr instance = (Ipaddr) getSession().get(
					"com.huchaishi.hibernate.ipaddr.Ipaddr", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Ipaddr instance) {
		log.debug("finding Ipaddr instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huchaishi.hibernate.ipaddr.Ipaddr")
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
		log.debug("finding Ipaddr instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Ipaddr as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIp(Object ip) {
		return findByProperty(IP, ip);
	}

	public List findByTasknum(Object tasknum) {
		return findByProperty(TASKNUM, tasknum);
	}

	public List findAll() {
		log.debug("finding all Ipaddr instances");
		try {
			String queryString = "from Ipaddr";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Ipaddr merge(Ipaddr detachedInstance) {
		log.debug("merging Ipaddr instance");
		try {
			Ipaddr result = (Ipaddr) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Ipaddr instance) {
		log.debug("attaching dirty Ipaddr instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Ipaddr instance) {
		log.debug("attaching clean Ipaddr instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}