package com.tap.customer.exception;

import org.springframework.stereotype.Component;

@Component
public class InvalidCustomerCredentials extends Exception  {


		public InvalidCustomerCredentials() {
			
			System.out.println("ObjectCreated By IOC Container for InvalidMemberCredentials()");
		}
		
		public InvalidCustomerCredentials(String string) {

			super(string);
		}	

}


