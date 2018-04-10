package com.harold.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.exception.spi.Configurable;

public class hibernateUtils {
	//����˽�л� sessionfactory ����
	private static SessionFactory sessionfactory;
	static {
		//1 ����,���ÿղι���	
		Configuration configuretion = new Configuration().configure();
		//2 ����������Ϣ,���� SessionFactory����
		sessionfactory= configuretion.buildSessionFactory();
	}
	//���session => ���ȫ��session
	public static Session openSession() {
		//3.���session
		Session session = sessionfactory.openSession();
		return session;
	}
	//���session => ������̰߳󶨵�session
	public static Session getCurrentSession() {
		//3 ���session
		Session session = sessionfactory.getCurrentSession();
		return session;
	}
	
}
