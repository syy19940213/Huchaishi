package com.huchaishi.hibernate.task;

import com.huchaishi.hibernate.BaseHibernateDAO;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 * A data access object (DAO) providing persistence and search support for Task
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.huchaishi.hibernate.task.Task
 * @author MyEclipse Persistence Tools
 */
public class TaskDAO extends BaseHibernateDAO {
	private static final Log log = LogFactory.getLog(TaskDAO.class);
	// property constants
	public static final String TASK_TYPE = "taskType";
	public static final String TASK_SHOP_NAME = "taskShopName";
	public static final String TASK_GOODS_PICTUR = "taskGoodsPictur";
	public static final String TASK_REQUIRE_PICTUR = "taskRequirePictur";
	public static final String TASK_PRICE_STATUS = "taskPriceStatus";
	public static final String TASK_GOODS_PRICE = "taskGoodsPrice";
	public static final String TASK_PHONE_OR_PC = "taskPhoneOrPc";
	public static final String TASK_CREDIT = "taskCredit";
	public static final String TASK_NUM = "taskNum";
	public static final String TASK_SENDTIME = "taskSendtime";
	public static final String TASK_REWARD = "taskReward";
	public static final String TASK_SEND_TIMESTAMP = "taskSendTimestamp";
	public static final String TASK_ISMPRICE = "taskIsmprice";
	public static final String TASK_SEND_USER = "taskSendUser";
	public static final String TASK_GET_USER = "taskGetUser";
	public static final String TASK_STAUTS = "taskStauts";
	public static final String TASK_USER_ACCOUNT = "taskUserAccount";
	public static final String TASK_COSTOME = "taskCostome";
	public static final String TASK_SEARCHWORD = "taskSearchword";
	public static final String TASK_GET_TIME = "taskGetTime";
	public static final String SEND_TIME = "sendTime";
	public static final String GET_TIME = "getTime";
	public static final String TASK_SHOW_SEND = "taskShowSend";
	public static final String TASK_SHOW_GET = "taskShowGet";
	public static final String PAY_WAY = "payWay";
	public static final String TASK_ISTOP = "taskIstop";
	public static final String TASK_TOP_STARTTIME = "taskTopStarttime";
	public static final String TASK_TOP_ENDTIME = "taskTopEndtime";
	
	
	public List findTaskByUserName(String username){
		try {
			Criteria criteria =  getSession().createCriteria(Task.class);//生成一个Criteria实例
			criteria.add(Restrictions.eq("taskGetUser",username));
			criteria.addOrder(Order.desc("taskGetTime"));
			List results = criteria.list();
//			List results = getSession()
//					.createCriteria("com.huchaishi.hibernate.task.Task")
//					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List findTop(Task instance) {
		log.debug("finding Task instance by example");
		try {
			Criteria criteria =  getSession().createCriteria(Task.class);//生成一个Criteria实例
			criteria.add(Restrictions.eq("taskType",instance.getTaskType()));
			if(instance.getTaskPhoneOrPc()!=null){
				criteria.add(Restrictions.eq("taskPhoneOrPc",instance.getTaskPhoneOrPc()));
			}
			if(instance.getTaskCredit()!=null){
				criteria.add(Restrictions.eq("taskCredit",instance.getTaskCredit()));
			}
			if(instance.getTaskPriceStatus()!=null){
				criteria.add(Restrictions.eq("taskPriceStatus",instance.getTaskPriceStatus()));
			}
			long time = System.currentTimeMillis()/1000;
			criteria.add(Restrictions.le("taskSendTimestamp",time));
			criteria.add(Restrictions.eq("taskStauts",1));
			criteria.addOrder(Order.desc("taskSendTimestamp"));
			criteria.add(Restrictions.eq("taskIstop",1));
			List results = criteria.list();
//			List results = getSession()
//					.createCriteria("com.huchaishi.hibernate.task.Task")
//					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	
	public List findTaskList(Task instance) {
		log.debug("finding Task instance by example");
		try {
			Criteria criteria =  getSession().createCriteria(Task.class);//生成一个Criteria实例
			criteria.add(Restrictions.eq("taskType",instance.getTaskType()));
			if(instance.getTaskPhoneOrPc()!=null){
				criteria.add(Restrictions.eq("taskPhoneOrPc",instance.getTaskPhoneOrPc()));
			}
			if(instance.getTaskCredit()!=null){
				criteria.add(Restrictions.eq("taskCredit",instance.getTaskCredit()));
			}
			if(instance.getTaskPriceStatus()!=null){
				criteria.add(Restrictions.eq("taskPriceStatus",instance.getTaskPriceStatus()));
			}
			long time = System.currentTimeMillis()/1000;
			criteria.add(Restrictions.le("taskSendTimestamp",time));
			criteria.add(Restrictions.eq("taskStauts",1));
			criteria.addOrder(Order.desc("taskSendTimestamp"));
			List results = criteria.list();
//			List results = getSession()
//					.createCriteria("com.huchaishi.hibernate.task.Task")
//					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public void save(Task transientInstance) {
		log.debug("saving Task instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Task persistentInstance) {
		log.debug("deleting Task instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Task findById(java.lang.Integer id) {
		log.debug("getting Task instance with id: " + id);
		try {
			Task instance = (Task) getSession().get(
					"com.huchaishi.hibernate.task.Task", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Task instance) {
		log.debug("finding Task instance by example");
		try {
			List results = getSession()
					.createCriteria("com.huchaishi.hibernate.task.Task")
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
		log.debug("finding Task instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Task as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTaskType(Object taskType) {
		return findByProperty(TASK_TYPE, taskType);
	}

	public List findByTaskShopName(Object taskShopName) {
		return findByProperty(TASK_SHOP_NAME, taskShopName);
	}

	public List findByTaskGoodsPictur(Object taskGoodsPictur) {
		return findByProperty(TASK_GOODS_PICTUR, taskGoodsPictur);
	}

	public List findByTaskRequirePictur(Object taskRequirePictur) {
		return findByProperty(TASK_REQUIRE_PICTUR, taskRequirePictur);
	}

	public List findByTaskPriceStatus(Object taskPriceStatus) {
		return findByProperty(TASK_PRICE_STATUS, taskPriceStatus);
	}

	public List findByTaskGoodsPrice(Object taskGoodsPrice) {
		return findByProperty(TASK_GOODS_PRICE, taskGoodsPrice);
	}

	public List findByTaskPhoneOrPc(Object taskPhoneOrPc) {
		return findByProperty(TASK_PHONE_OR_PC, taskPhoneOrPc);
	}

	public List findByTaskCredit(Object taskCredit) {
		return findByProperty(TASK_CREDIT, taskCredit);
	}

	public List findByTaskNum(Object taskNum) {
		return findByProperty(TASK_NUM, taskNum);
	}

	public List findByTaskSendtime(Object taskSendtime) {
		return findByProperty(TASK_SENDTIME, taskSendtime);
	}

	public List findByTaskReward(Object taskReward) {
		return findByProperty(TASK_REWARD, taskReward);
	}

	public List findByTaskSendTimestamp(Object taskSendTimestamp) {
		return findByProperty(TASK_SEND_TIMESTAMP, taskSendTimestamp);
	}

	public List findByTaskIsmprice(Object taskIsmprice) {
		return findByProperty(TASK_ISMPRICE, taskIsmprice);
	}

	public List findByTaskSendUser(Object taskSendUser) {
		return findByProperty(TASK_SEND_USER, taskSendUser);
	}

	public List findByTaskGetUser(Object taskGetUser) {
		return findByProperty(TASK_GET_USER, taskGetUser);
	}

	public List findByTaskStauts(Object taskStauts) {
		return findByProperty(TASK_STAUTS, taskStauts);
	}

	public List findByTaskUserAccount(Object taskUserAccount) {
		return findByProperty(TASK_USER_ACCOUNT, taskUserAccount);
	}

	public List findByTaskCostome(Object taskCostome) {
		return findByProperty(TASK_COSTOME, taskCostome);
	}

	public List findByTaskSearchword(Object taskSearchword) {
		return findByProperty(TASK_SEARCHWORD, taskSearchword);
	}

	public List findByTaskGetTime(Object taskGetTime) {
		return findByProperty(TASK_GET_TIME, taskGetTime);
	}

	public List findBySendTime(Object sendTime) {
		return findByProperty(SEND_TIME, sendTime);
	}

	public List findByGetTime(Object getTime) {
		return findByProperty(GET_TIME, getTime);
	}

	public List findByTaskShowSend(Object taskShowSend) {
		return findByProperty(TASK_SHOW_SEND, taskShowSend);
	}

	public List findByTaskShowGet(Object taskShowGet) {
		return findByProperty(TASK_SHOW_GET, taskShowGet);
	}

	public List findByPayWay(Object payWay) {
		return findByProperty(PAY_WAY, payWay);
	}

	public List findByTaskIstop(Object taskIstop) {
		return findByProperty(TASK_ISTOP, taskIstop);
	}

	public List findByTaskTopStarttime(Object taskTopStarttime) {
		return findByProperty(TASK_TOP_STARTTIME, taskTopStarttime);
	}

	public List findByTaskTopEndtime(Object taskTopEndtime) {
		return findByProperty(TASK_TOP_ENDTIME, taskTopEndtime);
	}

	public List findAll() {
		log.debug("finding all Task instances");
		try {
			String queryString = "from Task";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Task merge(Task detachedInstance) {
		log.debug("merging Task instance");
		try {
			Task result = (Task) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Task instance) {
		log.debug("attaching dirty Task instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Task instance) {
		log.debug("attaching clean Task instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}