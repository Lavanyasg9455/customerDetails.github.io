package com.tap.customer.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.customer.entity.CustomerEntity;


@Component
public class CustomerDAOImpl implements CustomerDAO {
	
private SessionFactory sessionFactory;
	
	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
		System.out.println("SessionFactory is injected by iocContainer..");
	}

	@Override
	public List<CustomerEntity> viewAllCustomers(int page, int size, String sortBy, String sortDir) {
	    Session session = null;
	    List<CustomerEntity> resultList;
	    Query query = null;
	    String GETALL_QUERY = "from CustomerEntity";

	    try {
	        session = sessionFactory.openSession();
	        query = session.createQuery(GETALL_QUERY);
	        query.setFirstResult(page * size);
	        query.setMaxResults(size);
	        resultList = query.getResultList();
	        return resultList;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

	@Override
	public boolean saveCustomerEntity(CustomerEntity entity) {
		
			System.out.println("Inkoved saveCustomerEntity()..");
			Session session=null;
			Transaction transaction=null;
			boolean isDataSaved=false;
			try
			{
				session=sessionFactory.openSession();
				transaction=session.beginTransaction();
				Serializable save =session.save(entity);
				System.out.println("save"+save);
				transaction.commit();
				isDataSaved=true;
				System.out.println("CustomerEntity has been saved..");
				
			}catch(HibernateException e) {
				
				transaction.rollback();
				System.out.println("Transaction has been rollback.."+e.getMessage());
				
			}
			finally {
				if(session!=null)
				{
					session.close();
					System.out.println("session is closed");
				}
				
			}
			return isDataSaved;
		}
	
	@Override
	public boolean updateCustomerEntity(CustomerEntity entity) {
		System.out.println("Invoked updateCustomerEntity()..");
		Session session=null;
		Transaction transaction=null;
		boolean isDataSaved = false;
		
		try
		{
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
			System.out.println("Entity has been updated");
			isDataSaved = true;
		}catch(HibernateException hibernateException) {
			
			transaction.rollback();
			System.out.println("Transaction has been rollback.."+hibernateException.getMessage());
			
		}
		finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return isDataSaved;
	}
	
	@Override
	public CustomerEntity getCustomerEntityByID(int customerId) {
		
		System.out.println("Invoked getCustomerEntityByID()..");
		Session session=null;
		CustomerEntity entity=null;
		
		try
		{
			session=sessionFactory.openSession();
			entity=session.get(CustomerEntity.class,customerId);
			if(entity!=null)
			{
				System.out.println("CustomerEntity found..");
				return entity;
			}
			
		}
		finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
			
		}
		return entity;
		
	}
	
	@Override
	public boolean deleteCustomerEntityById(int customerId) {
		
		System.out.println("Invoked deleteCustomerEntityById()..");
		Session session=null;
		CustomerEntity entity=null;
		Transaction transaction  = null;
		Query query=null;
		boolean isDataDeleted = false;
		String hql="delete from CustomerEntity where customerId='"+customerId+"'";
		try
		{
			session = sessionFactory.openSession();
			transaction=session.beginTransaction();
			query = session.createQuery(hql);
			query.executeUpdate();
			System.out.println("CustomerEntity deleted..");
			transaction.commit();
			isDataDeleted = true;
		}catch(HibernateException hibernateException) {
			
			transaction.rollback();
			System.out.println("Transaction has been rollback.."+hibernateException.getMessage());
			
		}
		finally {
			if(session!=null)
			{
				session.close();
				System.out.println("session is closed");
			}
		}
		return isDataDeleted;
	
	}

	@Override
	public List<CustomerEntity> searchCustomersByFirstName(String firstName) {
		Session session = null;
		List<CustomerEntity> resultList;
		Query query = null;
		String QUERY ="From CustomerEntity c Where c.firstName like :firstName";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(QUERY);
			query.setParameter("firstName", "%" + firstName + "%");
			resultList = query.getResultList();
			return resultList;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<CustomerEntity> searchCustomersByLastName(String lastName) {
		Session session = null;
		List<CustomerEntity> resultList;
		Query query = null;
		String QUERY ="From CustomerEntity c Where c.lastName like :lastName";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(QUERY);
			query.setParameter("lastName", "%" + lastName + "%");
			resultList = query.getResultList();
			return resultList;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<CustomerEntity> searchCustomersByCity(String city) {
		Session session = null;
		List<CustomerEntity> resultList;
		Query query = null;
		String QUERY ="From CustomerEntity c Where c.city like :city";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(QUERY);
			query.setParameter("city", "%" + city + "%");
			resultList = query.getResultList();
			return resultList;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<CustomerEntity> searchCustomersByEmail(String email) {
		Session session = null;
		List<CustomerEntity> resultList;
		Query query = null;
		String QUERY ="From CustomerEntity c Where  c.email like :email";
		try {
			session = sessionFactory.openSession();
			query = session.createQuery(QUERY);
			query.setParameter("email", "%" + email + "%");
			resultList = query.getResultList();
			return resultList;
		}finally {
			if(session != null) {
				session.close();
			}
		}
	}
	
	@Override
    public int getTotalCustomers() {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            String hql = "SELECT COUNT(*) FROM CustomerEntity";
            Long count = (Long) session.createQuery(hql).uniqueResult();
            return count != null ? count.intValue() : 0;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}





