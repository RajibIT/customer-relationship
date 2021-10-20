package com.luv2code.springdemo.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
	return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public String deleteCustomer(int custId) {
		
		return customerDao.deleteCustomer(custId);
	}

	@Override
	@Transactional
	public String addCustomer(Customer customer) {
		
		return customerDao.addCustomer(customer);
	}

	@Override
	@Transactional
	public Customer updateCustomer(int custId) {
		
		return customerDao.updateCustomer(custId);
	}

	@Override
	@Transactional
	public List<Customer> searchCustomer(String searchName) {
		return customerDao.searchCustomer(searchName);
		
	}
		
}
