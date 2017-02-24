package com.huchaishi.hibernate.user;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

/**
 * A data access object (DAO) providing persistence and search support for User
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.huchaishi.hibernate.user.User
 * @author MyEclipse Persistence Tools
 */
public class UserDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(UserDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String USER_PASSWORD = "userPassword";
	public static final String USER_QQ = "userQq";
	public static final String REAL_NAME = "realName";
	public static final String CARD_ID = "cardId";
	public static final String EMAIL = "email";
	public static final String PHONE_NUM = "phoneNum";
	public static final String RECOMMEND_USER = "recommendUser";
	public static final String GOLD = "gold";
	public static final String TASK_GOLD = "taskGold";
	public static final String BLACK_USER = "blackUser";

	public void save(User transientInstance) {
		log.debug("saving User instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(User persistentInstance) {
		log.debug("deleting User instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public User findById(java.lang.Integer id) {
		log.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getSession().get(
					"com.huchaishi.hibernate.user.User", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(User instance) {
		log.debug("finding User instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huchaishi.hibernate.user.User")
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
		log.debug("finding User instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from User as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List findByUserPassword(Object userPassword) {
		return findByProperty(USER_PASSWORD, userPassword);
	}

	public List findByUserQq(Object userQq) {
		return findByProperty(USER_QQ, userQq);
	}

	public List findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}

	public List findByCardId(Object cardId) {
		return findByProperty(CARD_ID, cardId);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByPhoneNum(Object phoneNum) {
		return findByProperty(PHONE_NUM, phoneNum);
	}

	public List findByRecommendUser(Object recommendUser) {
		return findByProperty(RECOMMEND_USER, recommendUser);
	}

	public List findByGold(Object gold) {
		return findByProperty(GOLD, gold);
	}

	public List findByTaskGold(Object taskGold) {
		return findByProperty(TASK_GOLD, taskGold);
	}

	public List findByBlackUser(Object blackUser) {
		return findByProperty(BLACK_USER, blackUser);
	}

	public List findAll() {
		log.debug("finding all User instances");
		try {
			String queryString = "from User";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public User merge(User detachedInstance) {
		log.debug("merging User instance");
		try {
			User result = (User) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(User instance) {
		log.debug("attaching dirty User instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(User instance) {
		log.debug("attaching clean User instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}