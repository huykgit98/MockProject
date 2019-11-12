package edu.sgu.bookingsystem.service;

import java.util.List;

import edu.sgu.bookingsystem.model.Customer;

public interface CustomerService {
	Customer getCustomer(Customer customer);

	int insertCustomer(Customer customer);

	int updateCustomer(Customer customer);
	
	List<Customer> getAllCustomer(int page);
	
	List<Customer> searchCustomer(String search, int page);
	
	long getCustomerID(String fullname, String phone);

}
