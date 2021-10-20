package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface CustomerDAO {

	public String addCustomer(Customer customer);
	public List<Customer> getCustomers();
	public String deleteCustomer(int customerId);
	public Customer updateCustomer(int customerId);
	public List<Customer> searchCustomer(String searchName);
}
