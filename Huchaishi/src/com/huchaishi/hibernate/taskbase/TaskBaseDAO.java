package com.huchaishi.hibernate.taskbase;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for
 * TaskBase entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.huchaishi.hibernate.taskbase.TaskBase
 * @author MyEclipse Persistence Tools
 */
public class TaskBaseDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TaskBaseDAO.class);
	// property constants
	public static final String TASK_NUM = "taskNum";
	public static final String TASK_NAME = "taskName";
	public static final String TASK_COMMISSION = "taskCommission";
	public static final String TASK_CONSUME = "taskConsume";
	public static final String TASK_GET_CONSUME = "taskGetConsume";
	public static final String TASK_TOP_CONSUME = "taskTopConsume";

	public void save(TaskBase transientInstance) {
		log.debug("saving TaskBase instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TaskBase persistentInstance) {
		log.debug("deleting TaskBase instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TaskBase findById(java.lang.Integer id) {
		log.debug("getting TaskBase instance with id: " + id);
		try {
			TaskBase instance = (TaskBase) getSession().get(
					"com.huchaishi.hibernate.taskbase.TaskBase", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TaskBase instance) {
		log.debug("finding TaskBase instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huchaishi.hibernate.taskbase.TaskBase")
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
		log.debug("finding TaskBase instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TaskBase as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTaskNum(Object taskNum) {
		return findByProperty(TASK_NUM, taskNum);
	}

	public List findByTaskName(Object taskName) {
		return findByProperty(TASK_NAME, taskName);
	}

	public List findByTaskCommission(Object taskCommission) {
		return findByProperty(TASK_COMMISSION, taskCommission);
	}

	public List findByTaskConsume(Object taskConsume) {
		return findByProperty(TASK_CONSUME, taskConsume);
	}

	public List findByTaskGetConsume(Object taskGetConsume) {
		return findByProperty(TASK_GET_CONSUME, taskGetConsume);
	}

	public List findByTaskTopConsume(Object taskTopConsume) {
		return findByProperty(TASK_TOP_CONSUME, taskTopConsume);
	}

	public List findAll() {
		log.debug("finding all TaskBase instances");
		try {
			String queryString = "from TaskBase";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TaskBase merge(TaskBase detachedInstance) {
		log.debug("merging TaskBase instance");
		try {
			TaskBase result = (TaskBase) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TaskBase instance) {
		log.debug("attaching dirty TaskBase instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TaskBase instance) {
		log.debug("attaching clean TaskBase instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}