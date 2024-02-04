package com.tap.customer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import com.tap.customer.entity.CustomerEntity;
import com.tap.customer.exception.InvalidCustomerCredentials;
import com.tap.customer.service.CustomerService;


@Controller
public class CustomerController {
	

	private CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {

		System.out.println("Invoked CustomerService()");
		this.customerService = customerService;
	}

	@RequestMapping(value = "/getAddCustomerPage")
	public String getAddCustomerPage() {

		return "/WEB-INF/AddCustomer.jsp";
	}

	@RequestMapping(value = "/getBackHomePage")
	public String getCustomerPage() {

		return "/WEB-INF/Login.jsp";
	}

	@RequestMapping(value = "/viewAllButton")
	public String viewAllCustomers(Model model, HttpServletRequest request,
	    @RequestParam(defaultValue = "0") int page,
	    @RequestParam(defaultValue = "3") int size,
	    @RequestParam(defaultValue = "customerId") String sortBy,
	    @RequestParam(defaultValue = "asc") String sortDir) {

	    List<CustomerEntity> allCustomers = customerService.getAllCustomers(page, size, sortBy, sortDir);
	    if (allCustomers != null) {
	        model.addAttribute("customers", allCustomers);
	        model.addAttribute("currentPage", page);
	        model.addAttribute("totalPages", customerService.getTotalPages(size));
	        return "/WEB-INF/HomePage.jsp";
	    } else {
	        model.addAttribute("tableErrorMessage", "Table is empty!Cannot retrieve data..");
	        return "/WEB-INF/HomePage.jsp";
	    }
	}
	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomer(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String address, @RequestParam String city, @RequestParam String state,
			@RequestParam String email, @RequestParam long phone, Model model, HttpServletRequest request)
			throws InvalidCustomerCredentials {

		HttpSession session = request.getSession();
		String userEmail = (String) session.getAttribute("userEmail");
		System.out.println(userEmail);
		System.out.println("this is AddMember in controller");
		try {
			boolean valid = customerService.validateCustomerData(firstName, lastName, address, city, state, email,
					phone);
			if (valid) {
				boolean save = customerService.saveCustomerDetails(firstName, lastName, address, city, state, email,
						phone);
				if (save) {

					model.addAttribute("customerMessage", "Customer Added Succesfully..");
				}
			}

		} catch (InvalidCustomerCredentials e) {
			model.addAttribute("customerErrorMessage", e.getMessage());
		}
		return "/WEB-INF/AddCustomer.jsp";
	}

	@RequestMapping(value = "/editCustomer/{customerId}")
	public String editCustomerDetailsById(@PathVariable int customerId, Model model) {

		System.out.println("Invoked editCustomerDetailsById()" + customerId);

		CustomerEntity entity = customerService.getCustomerEntityByID(customerId);
		model.addAttribute("CUSTOMER_ID", entity.getCustomerId());
		model.addAttribute("FIRST_NAME", entity.getFirstName());
		model.addAttribute("LAST_NAME", entity.getLastName());
		model.addAttribute("ADDRESS", entity.getAddress());
		model.addAttribute("CITY", entity.getCity());
		model.addAttribute("STATE", entity.getState());
		model.addAttribute("EMAIL", entity.getEmail());
		model.addAttribute("PHONE", entity.getPhone());

		return "/WEB-INF/UpdateCustomer.jsp";

	}

	@RequestMapping(value = "/editCustomer/updateCustomer/{customerId}", method = RequestMethod.POST)
	public String updateCustomerDetails(@PathVariable int customerId, @RequestParam String firstName,
			@RequestParam String lastName, @RequestParam String address, @RequestParam String city,
			@RequestParam String state, @RequestParam String email, @RequestParam long phone, Model model,
			HttpServletRequest request) throws InvalidCustomerCredentials {

		System.out.println("Invoked updateCustomerDetails()..");

		try {

			boolean valid = customerService.validateCustomerData(firstName, lastName, address, city, state, email,
					phone);
			if (valid) {
				boolean update = customerService.updateCustomerEntity(customerId, firstName, lastName, address, city,
						state, email, phone);
				if (update) {
					return "redirect:/viewAllButton";
				} else {
					model.addAttribute("updateErrorMessage", "Invalid Data! Please provide valid data..");
					return "/WEB-INF/UpdateCustomer.jsp";
				}
			}
		} catch (InvalidCustomerCredentials e) {

			model.addAttribute("updateErrorMessage", e.getMessage());
			return "/WEB-INF/UpdateCustomer.jsp";
		}

		return "forward:/WEB-INF/HomePage.jsp";
	}

	@RequestMapping(value = "/deleteCustomer/{customerId}")
	public String deleteCustomerEntityById(@PathVariable int customerId, Model model, HttpServletRequest request) {

		System.out.println("Invoked deleteCustomerEntityById()" + customerId);
		CustomerEntity entity = customerService.getCustomerEntityByID(customerId);
		customerService.deleteCustomerEntityById(customerId);
		return "redirect:/viewAllButton";

	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String searchCustomers(@RequestParam("searchBy") String searchBy,
			@RequestParam("searchQuery") String searchQuery, Model model) {
		List<CustomerEntity> searchResults = customerService.searchCustomers(searchBy, searchQuery);
		model.addAttribute("customers", searchResults);
		return "/WEB-INF/HomePage.jsp";
	}
}
