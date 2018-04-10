package com.harold.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.harold.domain.Customer;
import com.harold.utils.hibernateUtils;

public class demo_api {

	@Test
	public void fun1_save() {
		//
		/*
		 * 1 创建,调用空参构造 2 读取指定主配置文件 => 空参加载方法,加载src下的hibernate.cfg.xml文件
		 * 读取指定orm元数据(扩展),如果主配置中已经引入映射配置.不需要手动加载 conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.根据配置信息,创建 SessionFactory对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 获得session
		// 打开一个新的session对象
		Session session = sessionFactory.openSession();
		//开启事务提交
		Transaction tx = session.beginTransaction();
		// ----------------------------------------------
		Customer c = new Customer();
		c.setCust_name("facebook");

		session.save(c);// 执行保存

		// ----------------------------------------------
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void fun_select() {
		/*
		 * 1 创建,调用空参构造 2 读取指定主配置文件 => 空参加载方法,加载src下的hibernate.cfg.xml文件
		 * 读取指定orm元数据(扩展),如果主配置中已经引入映射配置.不需要手动加载 conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.根据配置信息,创建 SessionFactory对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 获得session
		// 打开一个新的session对象
		Session session = sessionFactory.openSession();
		//开启事务提交
		Transaction transaction = session.beginTransaction();

		Customer customer = session.get(Customer.class, 1l);
		System.out.println(customer);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void fun_update() {
		/*
		 * 1 创建,调用空参构造 2 读取指定主配置文件 => 空参加载方法,加载src下的hibernate.cfg.xml文件
		 * 读取指定orm元数据(扩展),如果主配置中已经引入映射配置.不需要手动加载 conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.根据配置信息,创建 SessionFactory对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 获得session
		// 打开一个新的session对象
		Session session = sessionFactory.openSession();
		//开启事务提交
		Transaction transaction = session.beginTransaction();
		// 先查询出要修改的对象，
		Customer customer = session.get(Customer.class, 9l);
		System.out.println(customer);
		customer.setCust_name("weibo");
		// session.update(customer);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void fun_delete() {
		/*
		 * 1 创建,调用空参构造 2 读取指定主配置文件 => 空参加载方法,加载src下的hibernate.cfg.xml文件
		 * 读取指定orm元数据(扩展),如果主配置中已经引入映射配置.不需要手动加载 conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.根据配置信息,创建 SessionFactory对象
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 获得session
		// 打开一个新的session对象
		Session session = sessionFactory.openSession();
		//开启事务提交
		Transaction transaction = session.beginTransaction();
		// 先查询出要修改的对象，
		Customer customer = session.get(Customer.class, 13l);
		System.out.println(customer);
		session.delete(customer);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
