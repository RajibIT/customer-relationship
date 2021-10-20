package com.luv2code.springdemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;



@Repository
public class CustomerDaoImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String addCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		return "success";
	}
	
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query query = currentSession.createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

	@Override
	public String deleteCustomer(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer customer = currentSession.get(Customer.class, custId);
		currentSession.delete(customer);
		return "success";
	}

	@Override
	public Customer updateCustomer(int custId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		return currentSession.get(Customer.class, custId);
	}


	@Override
	public List<Customer> searchCustomer(String searchName) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("search name :"+searchName);
		Query query = null;
		if(searchName != null && searchName.length()>0) {
			query = currentSession.createQuery("from Customer where lower(firstName) like :firstName or lower(lastName) like :lastName or lower(email) like :email");
			query.setParameter("firstName", "%"+searchName.toLowerCase()+"%");
			query.setParameter("lastName", "%"+searchName.toLowerCase()+"%");
			query.setParameter("email", "%"+searchName.toLowerCase()+"%");
		}else {
			query = currentSession.createQuery("from Customer");
		}
		List<Customer> customers = query.getResultList();
		System.out.println("searched customer :"+customers.toString());
		return customers;
	}

	

}
