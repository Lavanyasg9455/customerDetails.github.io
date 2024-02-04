package com.tap.customer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="login")
public class LoginEntity {
	
	@Id	
	@Column(name="LOGIN_ID")
	private String loginId;
	
	@Column(name="PASSWORD")
	private String password;

	public LoginEntity() {
		System.out.println("Invoked LoginEntity()..");
	}

	public LoginEntity(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "("+loginId+","+password+")";
	}

}
