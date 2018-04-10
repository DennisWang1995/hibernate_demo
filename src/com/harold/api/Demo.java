package com.harold.api;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.harold.domain.*;

//����Hibernate���
public class Demo {

	@Test
	//����ͻ�
	public void fun1(){
		//1 ����,���ÿղι���
		/*2 ��ȡָ���������ļ� => �ղμ��ط���,����src�µ�hibernate.cfg.xml�ļ�	
		 ��ȡָ��ormԪ����(��չ),������������Ѿ�����ӳ������.����Ҫ�ֶ�����
		conf.addResource(resourceName);
		conf.addClass(persistentClass);
		*/
		Configuration conf = new Configuration().configure();
		//3.����������Ϣ,���� SessionFactory����
		SessionFactory sessionFactory = conf.buildSessionFactory();
		//4 ���session
		//��һ���µ�session����
		Session session = sessionFactory.openSession();
		//���������ύ
		Transaction tx = session.beginTransaction();
		//----------------------------------------------
		Customer c = new Customer();
		c.setCust_name("facebook");
		
		session.save(c);//ִ�б���
		
		//----------------------------------------------
		//�����ύ
		tx.commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
}
