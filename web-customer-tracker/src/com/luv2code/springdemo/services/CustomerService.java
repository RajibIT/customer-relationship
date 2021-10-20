package com.luv2code.springdemo.services;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	
	public String deleteCustomer(int custId);
	
	public String addCustomer(Customer customer);
	
	public Customer updateCustomer(int custId);

	public List<Customer> searchCustomer(String searchName);
}
