package edu.sgu.bookingsystem.dao;

import java.util.List;

import edu.sgu.bookingsystem.model.Customer;

public interface CustomerDAO {
	Customer getCustomer(Customer customer);

	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);
	
	List<Customer> getAllCustomer(int page);
	
	List<Customer> searchCustomer(String search, int page);
}
