package edu.sgu.bookingsystem.service.impl;

import java.util.List;

import edu.sgu.bookingsystem.dao.CustomerDAO;
import edu.sgu.bookingsystem.dao.impl.CustomerDAOImpl;
import edu.sgu.bookingsystem.model.Customer;
import edu.sgu.bookingsystem.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	CustomerDAO customerdao = new CustomerDAOImpl();
	
	@Override
	public Customer getCustomer(Customer customer) {
		//customerdao = new CustomerDAOImpl();
		return customerdao.getCustomer(customer);
	}

	@Override
	public int insertCustomer(Customer customer) {
	//	customerdao = new CustomerDAOImpl();
		if(customerdao.insertCustomer(customer)==1)
		{
			customerdao = new CustomerDAOImpl();
			return 1;
		}
		if(customerdao.insertCustomer(customer)==-1)
		{
			return -1;
		}
		if(customerdao.insertCustomer(customer)==-2)
			{
				return -2;
			}
	
		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		//customerdao = new CustomerDAOImpl();
		if(customerdao.updateCustomer(customer)==1)
		{
			customerdao = new CustomerDAOImpl();
			return 1;
		}
		if(customerdao.updateCustomer(customer)==-1)
		{
			return -1;
		}
		if(customerdao.updateCustomer(customer)==-2)
			{
				return -2;
			}
	
		return 0;
	}

	@Override
	public List<Customer> getAllCustomer(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Customer> searchCustomer(String search, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCustomerID(String fullname, String phone) {
		return customerdao.getCustomerID(fullname, phone);
	}
//	public static void main(String[] args) {
//		CustomerService cs = new CustomerServiceImpl();
//		System.out.println(cs.getCustomerID("Huy Nguyen", "0387134747"));
//	}
}
