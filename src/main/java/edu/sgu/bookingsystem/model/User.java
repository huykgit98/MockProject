package edu.sgu.bookingsystem.model;

import java.util.ArrayList;
import java.util.List;

public class User {
	private String username;
	private String password;
	private long empID;
	private long status;
	private Role role = new Role();
	
	private List<String> roles;
	
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
	public long getEmpID() {
		return empID;
	}
	public void setEmpID(long empID) {
		this.empID = empID;
	}
	public User() {
		super();
	}
	public User(String userName, String password) {
		super();
		this.username = userName;
		this.password = password;
	}
	public User(String userName, String password, long empID) {
		super();
		this.username = userName;
		this.password = password;
		this.empID = empID;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public User(String username, String password, String... roles) {
		super();
		this.username = username;
		this.password = password;
		this.roles = new ArrayList<String>();
		if (roles != null)
		{
			for (String r: roles)
			{
				this.roles.add(r);
			}
		}
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}
