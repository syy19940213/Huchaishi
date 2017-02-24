package com.huchaishi.hibernate.goldrecord;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * GoldRecord entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.goldrecord.GoldRecord
 * @author MyEclipse Persistence Tools
 */
public class GoldRecordDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(GoldRecordDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_NAME = "userName";
	public static final String GOLD_NUM = "goldNum";
	public static final String REMARK = "remark";
	public static final String GOLD_FLAG = "goldFlag";
	public static final String PAY_ACCOUNT = "payAccount";
	public static final String STATUS = "status";

	public void save(GoldRecord transientInstance) {
		log.debug("saving GoldRecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(GoldRecord persistentInstance) {
		log.debug("deleting GoldRecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public GoldRecord findById(java.lang.Integer id) {
		log.debug("getting GoldRecord instance with id: " + id);
		try {
			GoldRecord instance = (GoldRecord) getSession().get(
					"com.huchaishi.hibernate.goldrecord.GoldRecord", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(GoldRecord instance) {
		log.debug("finding GoldRecord instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.goldrecord.GoldRecord")
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
		log.debug("finding GoldRecord instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from GoldRecord as model where model."
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

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByGoldNum(Object goldNum) {
		return findByProperty(GOLD_NUM, goldNum);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByGoldFlag(Object goldFlag) {
		return findByProperty(GOLD_FLAG, goldFlag);
	}

	public List findByPayAccount(Object payAccount) {
		return findByProperty(PAY_ACCOUNT, payAccount);
	}

	public List findByStatus(Object status) {
		return findByProperty(STATUS, status);
	}

	public List findAll() {
		log.debug("finding all GoldRecord instances");
		try {
			String queryString = "from GoldRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public GoldRecord merge(GoldRecord detachedInstance) {
		log.debug("merging GoldRecord instance");
		try {
			GoldRecord result = (GoldRecord) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(GoldRecord instance) {
		log.debug("attaching dirty GoldRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(GoldRecord instance) {
		log.debug("attaching clean GoldRecord instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}