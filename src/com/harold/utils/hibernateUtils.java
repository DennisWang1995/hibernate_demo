package com.harold.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.spi.Configurable;

public class hibernateUtils {
	//构造私有化 sessionfactory 对象
	private static SessionFactory sessionfactory;
	static {
		//1 创建,调用空参构造	
		Configuration configuretion = new Configuration().configure();
		//2 根据配置信息,创建 SessionFactory对象
		sessionfactory= configuretion.buildSessionFactory();
	}
	//获得session => 获得全新session
	public static Session openSession() {
		//3.获得session
		Session session = sessionfactory.openSession();
		return session;
	}
	//获得session => 获得与线程绑定的session
	public static Session getCurrentSession() {
		//3 获得session
		Session session = sessionfactory.getCurrentSession();
		return session;
	}
	
}
