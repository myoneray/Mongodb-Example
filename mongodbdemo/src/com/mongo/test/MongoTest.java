/**
 * MongoTest.java
 * 版权所有(C) 2012 
 * 创建: 2012-12-12 11:54:30
 */
package com.mongo.test;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mongo.bean.Person;
import com.mongo.dao.AbstractRepository;
import com.mongo.dao.impl.PersonRepository;

/**
 * 

 */
public class MongoTest {

	private static Log log = LogFactory.getLog(MongoTest.class.getName());

	private AbstractRepository pr = null;

	/**
	 * 
	 * <b>function:</b>
	 * 
	 * @createDate 2012-12-12 16:08:02
	 */
    public void init() {
		log.debug("开始启动");
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		pr = (PersonRepository) ctx.getBean("personRepository");

	}

	/**
	 * 
	 * <b>function:</b>添加
	 * 
	 * 
	 * @createDate 2012-12-12 16:11:01
	 */
	public void insert() {
		for (int i = 0; i < 1000; i++) {
			int temp = (int) (Math.random() * 10);
			Person p = new Person(temp, new Date().getTime());
			pr.insert(p);
		}
		log.debug("添加成功");
	}

	/**
	 * 返回毫秒
	 * 
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 */
	public long getMillis(java.util.Date date) {
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 
	 * <b>function:</b>根据输入的ID查找对象
	 * 
	 * 
	 * @createDate 2012-12-12 16:24:10
	 */
	public void findOne() {
		String id = "50c83cb552c2ceb0463177d6";
		Person p = pr.findOne(id);
		log.debug(p);
	}

	/**
	 * 
	 * <b>function:</b>查询所有
	 * 
	 * 
	 * @createDate 2012-12-12 16:08:54
	 */
	public void listAll() {

		List<Person> list = pr.findAll();
		log.debug("listAll查询结果如下:");
		long count = 0;
		for (Person p : list) {
			count += p.getValue();
			log.debug(p.getValue());
			log.debug(p.toString());
		}
		log.debug("数据总计共：" + count);
	}

	public void removeAll() {
		pr.removeAll();
	}

	/**
	 * 
	 * <b>function:</b>测试方法
	 * 
	 * @createDate 2012-12-12 16:11:37
	 */
	public void start() {
		init();
		insert();
		listAll();
		// findOne();
		// removeAll();
	}

	/**
	 * <b>function:</b>main函数
	 * 
	 * @createDate 2012-12-12 11:54:30
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MongoTest t = new MongoTest();
		t.start();
	}

}