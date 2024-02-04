package com.tap.customer.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.customer.dao.CustomerDAO;
import com.tap.customer.entity.CustomerEntity;
import com.tap.customer.exception.InvalidCustomerCredentials;


@Component
public class CustomerService {
	
	private CustomerDAO customerDAO;

	@Autowired
	public CustomerService(CustomerDAO customerDAO) {
		
		System.out.println("Invoked CustomerDAO()..");
		this.customerDAO = customerDAO;
	}
	
	public boolean validateCustomerData(String firstName,String lastName,String address,String city,String state,
			String email,long phone) throws InvalidCustomerCredentials{
		
		System.out.println("Invoked validateMemberData()..");
		boolean validfirstName=false;
		boolean validlastName=false;
		boolean validaddress=false;
		boolean validcity=false;
		boolean validstate=false;
		boolean validemail=false;
		boolean validphone=false;
		
		if(firstName!=null && !firstName.isEmpty() && !firstName.isBlank()) {
			System.out.println("FirstName is valid..");
			validfirstName=true;
		}else {
			throw new InvalidCustomerCredentials("Enter Valid FirstName");
		}
		
		if(lastName!=null && !lastName.isEmpty() && !lastName.isBlank()) {
			System.out.println("LastName is valid..");
			validlastName=true;
		}else {
			throw new InvalidCustomerCredentials("Enter Valid LastName");
		}
		
		if(address!=null && !address.isEmpty() && !address.isBlank()) {
			System.out.println("Address is valid..");
			validaddress=true;
		}else {
			throw new InvalidCustomerCredentials("Enter Valid Address ");
		}
		
		if(city!=null && !city.isEmpty() && !city.isBlank()) {
			System.out.println("city is valid..");
			validcity=true;
		}else {
			throw new InvalidCustomerCredentials("Enter Valid city");
		}
		
		if (state!= null && !state.isEmpty() && !state.isBlank()) {
			System.out.println("state is valid..");
			validstate = true;
		} else {

			throw new InvalidCustomerCredentials("Select Valid state");

		}
		
		if(email!=null && !email.isEmpty() && !email.isBlank()) {
			System.out.println("Email is valid..");
			validemail=true;
		}else {
			throw new InvalidCustomerCredentials("Enter Valid Email");
		}
		
		if(phone>0 && String.valueOf(phone).length()==10) {
			System.out.println("Phone No is valid..");
			validphone=true;
		}else {
			throw new InvalidCustomerCredentials("Select Valid Phone No");
		}

		
		return validfirstName && validlastName && validaddress &&  validcity && validstate && validemail && validphone;
		
	}
	
	public boolean saveCustomerDetails(String firstName,String lastName,String address,String city,String state,String email,long phone) 
	{
		
		System.out.println("Invoked saveCustomerDetails()..");
		CustomerEntity entity=new CustomerEntity(firstName, lastName, address, city, state,email, phone);
		return customerDAO.saveCustomerEntity(entity);
	}
	
	public List<CustomerEntity> getAllCustomers(int page, int size, String sortBy, String sortDir) {
		
		if(customerDAO.viewAllCustomers(page, size, sortBy, sortDir).size()==0) {
			return null;
		}else {
			return customerDAO.viewAllCustomers(page, size, sortBy, sortDir);
		}

	}
	
	public int getTotalPages(int size) {
	    int totalCustomers = customerDAO.getTotalCustomers();
	    return (int) Math.ceil((double) totalCustomers / size);
	}
	
	public boolean updateCustomerEntity(int customerId, String firstName,String lastName,String address,String city,String state,String email,long phone)
			throws InvalidCustomerCredentials {
		System.out.println("Invoked updateCustomerEntity..");

		CustomerEntity entity = new CustomerEntity(customerId,firstName, lastName, address, city, state,email, phone);
		return customerDAO.updateCustomerEntity(entity);

	}

	public CustomerEntity getCustomerEntityByID(int customerId) {

		System.out.println("Invoked getCustomerEntityByID().. ");
		return customerDAO.getCustomerEntityByID(customerId);

	}
	
	public boolean deleteCustomerEntityById(int customerId){

		System.out.println("Invoked deleteCustomerEntityById()..");
		return customerDAO.deleteCustomerEntityById(customerId);
		
	}
	
	public List<CustomerEntity> searchCustomers(String searchBy, String searchQuery) {
		
		if (searchBy.equals("firstName")) {
	        return customerDAO.searchCustomersByFirstName(searchQuery);
	    } else if (searchBy.equals("lastName")) {
	        return customerDAO.searchCustomersByLastName(searchQuery);
	    } else if (searchBy.equals("city")) {
	        return customerDAO.searchCustomersByCity(searchQuery);
	    } else if (searchBy.equals("email")) {
	        return customerDAO.searchCustomersByEmail(searchQuery);
	    } 
	    return Collections.emptyList();
	}

	public boolean updateCustomer(CustomerEntity entity) {
		return customerDAO.updateCustomerEntity(entity);
		
	}

	public boolean saveCustomer(CustomerEntity entity) {
		return customerDAO.updateCustomerEntity(entity);
		
	}
}
