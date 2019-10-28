package edu.sgu.bookingsystem.model;

public class User {
	private String username;
	private String password;
	private int empID;
	public String getUserName() {
		return username;
	}
	public void setUserName(String userName) {
		this.username = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	public User(String userName, String password, int empID) {
		super();
		this.username = userName;
		this.password = password;
		this.empID = empID;
	}
	
}
