package edu.sgu.bookingsystem.model;

public class Customer {
	private long id;
	private String email;
	private String phone;
	private String password;
	private String fullName;
	private String address;
	private int pageNumber;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public Customer(long id) {
		super();
		this.id = id;
	}
	public Customer(long id, String password, String address) {
		super();
		this.id = id;
		this.password = password;
		this.address = address;
	}
	public Customer(String email, String phone, String password, String fullName, String address) {
		super();
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
	}
	public Customer(long id, String email, String phone, String fullName, String address) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.fullName = fullName;
		this.address = address;
	}
	
	
}
