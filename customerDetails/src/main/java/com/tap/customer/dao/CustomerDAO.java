package com.tap.customer.dao;

import java.util.List;

import com.tap.customer.entity.CustomerEntity;

public interface CustomerDAO {
	
	List<CustomerEntity> viewAllCustomers(int page, int size, String sortBy, String sortDir);

	boolean saveCustomerEntity(CustomerEntity entity);

	boolean updateCustomerEntity(CustomerEntity entity);

	CustomerEntity getCustomerEntityByID(int customerId);

	boolean deleteCustomerEntityById(int customerId);
	
	List<CustomerEntity> searchCustomersByFirstName(String firstName);

    List<CustomerEntity> searchCustomersByLastName(String lastName);

    List<CustomerEntity> searchCustomersByCity(String city);

    List<CustomerEntity> searchCustomersByEmail(String email);

	int getTotalCustomers();
    

}
