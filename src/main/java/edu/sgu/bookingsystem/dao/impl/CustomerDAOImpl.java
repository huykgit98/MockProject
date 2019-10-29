package edu.sgu.bookingsystem.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.sgu.bookingsystem.connect.JDBCConnection;
import edu.sgu.bookingsystem.dao.CustomerDAO;
import edu.sgu.bookingsystem.model.Customer;

public class CustomerDAOImpl implements CustomerDAO{
	private Connection dbConnection = null;
	private PreparedStatement stmt = null;
	public CustomerDAOImpl() {
		try {
			dbConnection = JDBCConnection.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CustomerDAOImpl: Ket noi that bai!");
		}
	}
	
	@Override
	public Customer getCustomer(Customer customer) {
		ResultSet rs = null;
		try {
			if (customer.getId() == 0) {
				String sql="SELECT c.CusID, c.Email, c.Phone, c.Password, c.FullName, c.Address" + 
						"	FROM Customers c" + 
						"	WHERE (c.Email = ? OR c.Phone = ?) AND c.Password = ?";
				stmt=dbConnection.prepareStatement(sql);
				stmt.setString(1, customer.getEmail());
				stmt.setString(2, customer.getPhone());
				stmt.setString(3, customer.getPassword());

			} else {
				
				String sql="SELECT c.CusID, c.Email, c.Phone, c.Password, c.FullName, c.Address" + 
						"	FROM customers c" + 
						"	WHERE c.CusID = ?";
				stmt=dbConnection.prepareStatement(sql);
				stmt.setLong(1, customer.getId());

			}

			rs = stmt.executeQuery();

			if (rs.next()) {
				customer.setId(rs.getInt("CusID"));
				customer.setEmail(rs.getString("Email"));
				customer.setPhone(rs.getString("Phone"));
				customer.setPassword(rs.getString("Password"));
				customer.setFullName(rs.getString("FullName"));
				customer.setAddress(rs.getString("Address"));

			} else {
				customer = new Customer();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			finallyFunction();
		}

		return customer;
	}

	@Override
	public int insertCustomer(Customer customer) {
		if (checkEmail(customer) == 1) {
			return -1;
		} else {
			if (checkPhoneNumber(customer) == 1) {
				return -2;
			} else {
				try {
					
					String sql="INSERT INTO `customers` (`Email`, `Password`, `FullName`, `Address`, `Phone`) VALUES (?, ?, ?, ?, ?)";
					stmt=dbConnection.prepareStatement(sql);
					stmt.setString(1, customer.getEmail());
					stmt.setString(5, customer.getPhone());
					stmt.setString(2, customer.getPassword());
					stmt.setString(3, customer.getFullName());
					stmt.setString(4, customer.getAddress());

					stmt.executeUpdate();

					return 1;

				} catch (Exception e) {
					System.err.println(e.getMessage());
				} finally {
					finallyFunction();
				}
			}

		}

		return 0;
	}

	@Override
	public int updateCustomer(Customer customer) {
		if (customer.getFullName() == null) {
			try {
				String sql="UPDATE customers SET Password = ?, Address = ? WHERE CusID =?";
				stmt=dbConnection.prepareStatement(sql);				
				stmt.setLong(3, customer.getId());
				stmt.setString(1, customer.getPassword());
				stmt.setString(2, customer.getAddress());

				stmt.executeUpdate();

				return 1;

			} catch (Exception e) {
				System.err.println(e.getMessage());
			} finally {
				finallyFunction();
			}
		} else {

			if (checkEmail(customer) == 1) {
				return -1;
			} else {
				if (checkPhoneNumber(customer) == 1) {
					return -2;
				} else {
					try {
						String sql="UPDATE customers SET Email = ?, Phone = ?, Password = ?, FullName = ?, Address = ? WHERE CusID = ?";
						stmt=dbConnection.prepareStatement(sql);
						
						stmt.setLong(6, customer.getId());
						stmt.setString(1, customer.getEmail());
						stmt.setString(2, customer.getPhone());
						stmt.setString(3, customer.getPassword());
						stmt.setString(4, customer.getFullName());
						stmt.setString(5, customer.getAddress());

						stmt.executeUpdate();

						return 1;

					} catch (Exception e) {
						System.err.println(e.getMessage());
					} finally {
						finallyFunction();
					}
				}

			}
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

	private int checkEmail(Customer customer) {
		try {

			String sql="SELECT Email FROM customers WHERE Email = ? AND CusID != ?";
//			String sql="SELECT Email FROM customers WHERE Email = ?";

			stmt=dbConnection.prepareStatement(sql);
			stmt.setLong(2, customer.getId());
			stmt.setString(1, customer.getEmail());

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				return 1;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return 0;
	}
	
	private int checkPhoneNumber(Customer customer) {
		try {
			//String sql="SELECT Phone FROM customers WHERE Phone = ?";
			String sql="SELECT Phone FROM customers WHERE Phone = ? AND CusID != ?";
			stmt=dbConnection.prepareStatement(sql);
			stmt.setLong(2, customer.getId());
			stmt.setString(1, customer.getPhone());

			ResultSet rs = stmt.executeQuery();

			if (rs.next())
				return 1;

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		return 0;
	}

	
	
	private void finallyFunction() {

		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException se) {
			se.printStackTrace();
		} finally {
			try {
				if (dbConnection != null)
					dbConnection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args){

		CustomerDAO cusdao = new CustomerDAOImpl();
	/*	Customer customer = new Customer("asd@email.com","0391231231", "123456", "Hoàng Nguyễn Huy", "dia chi cung cung");
		Customer customer = new Customer();
		customer.setId(1);
		System.out.println("ket qua: " +cusdao.getCustomer(customer).getFullName());
	*/
		/*
		Customer customer1 = new Customer("huy@email.com","0381231231", "123456", "Hoàng Huy", "chac chan thanh cong");
		System.out.println("ket qua insert customer: " +cusdao.insertCustomer(customer1));
		*/
		
	}
}
