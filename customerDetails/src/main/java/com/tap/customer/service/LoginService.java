package com.tap.customer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tap.customer.dao.LoginDAO;
import com.tap.customer.entity.LoginEntity;
import com.tap.customer.exception.InvalidLoginCredentials;

@Component
public class LoginService {
	
	private LoginDAO loginDAO;

	@Autowired
	public LoginService(LoginDAO loginDAO) {
		
		System.out.println("Invoked LoginDAO()..");
		this.loginDAO = loginDAO;
	}

	public boolean validateLoginCredentials(String loginId,String password) throws InvalidLoginCredentials {
		
		boolean validEmailId=false;
		boolean validPassword=false;
		
		
		if(loginId!=null && !loginId.isEmpty() && !loginId.isBlank()) {
			System.out.println("emailId is valid..");
			validEmailId=true;
		}else {
			throw new InvalidLoginCredentials("Invalid EmailId! EmailId doesn't exist.");
			
		}
		
		if(password!=null && !password.isEmpty() && !password.isBlank()) {
			System.out.println("password is valid..");
			validPassword=true;
		}else {
			throw new InvalidLoginCredentials("Invalid Password! password cannot be null or empty");
		}
		return validEmailId && validPassword;
	}
	
	public boolean verifyLogin(String loginId, String password) throws InvalidLoginCredentials {
		
		System.out.println("Invoked verifyLogin()..");
		boolean flag=false;
        LoginEntity loginEntity = loginDAO.getLoginEntityById(loginId);
        if (loginEntity != null && loginEntity.getPassword().equals(password)) {
            flag=true;
        } else {
            throw new InvalidLoginCredentials("Incorrect Email or Password. Please check your credentials.");
        }
        return flag;
    }
	
	
}