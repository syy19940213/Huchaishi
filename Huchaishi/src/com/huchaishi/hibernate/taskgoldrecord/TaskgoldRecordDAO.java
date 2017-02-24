package com.huchaishi.hibernate.taskgoldrecord;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskgoldRecord entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord
 * @author MyEclipse Persistence Tools
 */
public class TaskgoldRecordDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TaskgoldRecordDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_NAME = "userName";
	public static final String TASK_GOLD = "taskGold";
	public static final String REMARK = "remark";
	public static final String TASK_STATUS = "taskStatus";

	public void save(TaskgoldRecord transientInstance) {
		log.debug("saving TaskgoldRecord instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskgoldRecord persistentInstance) {
		log.debug("deleting TaskgoldRecord instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskgoldRecord findById(java.lang.Integer id) {
		log.debug("getting TaskgoldRecord instance with id: " + id);
		try {
			TaskgoldRecord instance = (TaskgoldRecord) getSession()
					.get("com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord",
							id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TaskgoldRecord instance) {
		log.debug("finding TaskgoldRecord instance by example");
		try {
			List results = getSession()
					.createCriteria(
							"com.huchaishi.hibernate.taskgoldrecord.TaskgoldRecord")
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
		log.debug("finding TaskgoldRecord instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from TaskgoldRecord as model where model."
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

	public List findByTaskGold(Object taskGold) {
		return findByProperty(TASK_GOLD, taskGold);
	}

	public List findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findByTaskStatus(Object taskStatus) {
		return findByProperty(TASK_STATUS, taskStatus);
	}

	public List findAll() {
		log.debug("finding all TaskgoldRecord instances");
		try {
			String queryString = "from TaskgoldRecord";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskgoldRecord merge(TaskgoldRecord detachedInstance) {
		log.debug("merging TaskgoldRecord instance");
		try {
			TaskgoldRecord result = (TaskgoldRecord) getSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskgoldRecord instance) {
		log.debug("attaching dirty TaskgoldRecord instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskgoldRecord instance) {
		log.debug("attaching clean TaskgoldRecord instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}