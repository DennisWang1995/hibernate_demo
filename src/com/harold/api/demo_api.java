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
		 * 1 ����,���ÿղι��� 2 ��ȡָ���������ļ� => �ղμ��ط���,����src�µ�hibernate.cfg.xml�ļ�
		 * ��ȡָ��ormԪ����(��չ),������������Ѿ�����ӳ������.����Ҫ�ֶ����� conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.����������Ϣ,���� SessionFactory����
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 ���session
		// ��һ���µ�session����
		Session session = sessionFactory.openSession();
		//���������ύ
		Transaction tx = session.beginTransaction();
		// ----------------------------------------------
		Customer c = new Customer();
		c.setCust_name("facebook");

		session.save(c);// ִ�б���

		// ----------------------------------------------
		tx.commit();
		session.close();
		sessionFactory.close();
	}

	@Test
	public void fun_select() {
		/*
		 * 1 ����,���ÿղι��� 2 ��ȡָ���������ļ� => �ղμ��ط���,����src�µ�hibernate.cfg.xml�ļ�
		 * ��ȡָ��ormԪ����(��չ),������������Ѿ�����ӳ������.����Ҫ�ֶ����� conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.����������Ϣ,���� SessionFactory����
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 ���session
		// ��һ���µ�session����
		Session session = sessionFactory.openSession();
		//���������ύ
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
		 * 1 ����,���ÿղι��� 2 ��ȡָ���������ļ� => �ղμ��ط���,����src�µ�hibernate.cfg.xml�ļ�
		 * ��ȡָ��ormԪ����(��չ),������������Ѿ�����ӳ������.����Ҫ�ֶ����� conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.����������Ϣ,���� SessionFactory����
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 ���session
		// ��һ���µ�session����
		Session session = sessionFactory.openSession();
		//���������ύ
		Transaction transaction = session.beginTransaction();
		// �Ȳ�ѯ��Ҫ�޸ĵĶ���
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
		 * 1 ����,���ÿղι��� 2 ��ȡָ���������ļ� => �ղμ��ط���,����src�µ�hibernate.cfg.xml�ļ�
		 * ��ȡָ��ormԪ����(��չ),������������Ѿ�����ӳ������.����Ҫ�ֶ����� conf.addResource(resourceName);
		 * conf.addClass(persistentClass);
		 */
		Configuration conf = new Configuration().configure();
		// 3.����������Ϣ,���� SessionFactory����
		SessionFactory sessionFactory = conf.buildSessionFactory();
		// 4 ���session
		// ��һ���µ�session����
		Session session = sessionFactory.openSession();
		//���������ύ
		Transaction transaction = session.beginTransaction();
		// �Ȳ�ѯ��Ҫ�޸ĵĶ���
		Customer customer = session.get(Customer.class, 13l);
		System.out.println(customer);
		session.delete(customer);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
