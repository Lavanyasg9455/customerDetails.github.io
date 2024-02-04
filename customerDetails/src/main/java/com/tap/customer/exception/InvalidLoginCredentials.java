package com.tap.customer.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidLoginCredentials extends Exception {

	public InvalidLoginCredentials() {
		System.out.println("Object created by IOC Container for InvalidLoginCredentials()");
	}

	public InvalidLoginCredentials(String string) {
		 super(string);
	}

}

