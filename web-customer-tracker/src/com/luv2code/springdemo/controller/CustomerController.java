package com.luv2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String getCustomers(Model myModel) {
		
		//get the customer list
		List<Customer> customers = customerService.getCustomers();
		
		//attached customer list to model
		myModel.addAttribute("customers", customers);
		
		//return view list
		return "customer-list";
	}
	
	
	@GetMapping("/delete")
	public String deleteCustomer(Model model, @RequestParam("id") int custId) {
		
		customerService.deleteCustomer(custId);
		return "redirect:/customer/list";
	}
	
	
	@GetMapping("/showFormAdd")
	public String showCustomerForm(Model model) {
		
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "showFormAdd";
	}
	
	
	@PostMapping("/saveCustomer")
	public String addCustomer(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {
		System.out.println(customer);
		customerService.addCustomer(customer);
		System.out.println("Binding result :"+bindingResult);
		if(bindingResult.hasErrors())
			return "showFormAdd";
		else
			return "redirect:/customer/list";
	}
	
	
	@GetMapping("/update")
	public String updateCustomer(Model model, @RequestParam("customerId") int custId) {	
		Customer customer = customerService.updateCustomer(custId);
		System.out.println("customer ID :"+customer.getCustomerId());
		model.addAttribute("customer", customer);
		return "showFormAdd";
	}
	
	@GetMapping("/search")
	public String searchCustomer(Model model,@RequestParam("theSearchName") String searchName) {
		List<Customer> customers = customerService.searchCustomer(searchName);
		model.addAttribute("customers", customers);
		return "customer-list";
	}
	
}
