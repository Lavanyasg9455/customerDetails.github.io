package com.tap.customer.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.customer.entity.CustomerEntity;
import com.tap.customer.entity.LoginEntity;

@Component
public class LoginDAOImpl implements LoginDAO {

	
private SessionFactory sessionFactory;
	
	@Autowired
	public LoginDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("SessionFactory is injected by iocContainer..");
	}
	
	@Override
    public LoginEntity getLoginEntityById(String loginId) {
		System.out.println("Invoked getLoginEntityById()..");
		Session session=null;
		LoginEntity entity=null;
		Query query=null;
		String hql="FROM LoginEntity WHERE loginId = :loginId";
		try
		{
			session = sessionFactory.openSession();
			query = session.createQuery(hql);
			query.setParameter("loginId", loginId);
			entity = (LoginEntity) query.uniqueResult();
			if(entity!=null)
			{
				System.out.println("LoginEntity found..");
				return entity;
			}
		}finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
		}
		return entity;
	
	}
}


