package com.tap.customer.dao;

import com.tap.customer.entity.LoginEntity;

public interface LoginDAO {
	
	    LoginEntity getLoginEntityById(String loginId);

}
