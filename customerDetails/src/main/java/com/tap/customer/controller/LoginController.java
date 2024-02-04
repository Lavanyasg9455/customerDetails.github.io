package com.tap.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tap.customer.entity.LoginEntity;
import com.tap.customer.exception.InvalidLoginCredentials;
import com.tap.customer.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
	
public static String userEmail;

	private LoginService loginService;
	
	@Autowired
	public LoginController(LoginService loginService) {
		
		System.out.println("Invoked LoginService..");
		this.loginService = loginService;
	}
	
	
	@RequestMapping(value="/getLoginPage")
	public String getLoginPage() {
		return "/WEB-INF/Login.jsp";
	}
	
	

	@RequestMapping(value = "/loginPage")
	public String loginPage(@RequestParam String loginId, @RequestParam String password, Model model, HttpServletRequest request) {
	    try {
	        boolean validUser = loginService.validateLoginCredentials(loginId, password);
	        if (validUser) {
	            	boolean result = loginService.verifyLogin(loginId, password);
	                if (result) {
	                    HttpSession session = request.getSession(true);
	                    session.setAttribute("userEmail", loginId);
	                    userEmail = (String) session.getAttribute("userEmail");
	                    return "/WEB-INF/HomePage.jsp";
	                }
	                
	            }
	    } catch (InvalidLoginCredentials e) {
	        model.addAttribute("loginMessage1", "Login Failed" + " " + e.getMessage());
	    }
	    return "/WEB-INF/Login.jsp";
	}
}
