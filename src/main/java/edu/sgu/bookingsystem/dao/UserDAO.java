package edu.sgu.bookingsystem.dao;

import edu.sgu.bookingsystem.model.Employee;
import edu.sgu.bookingsystem.model.User;

public interface UserDAO {
	Employee getEmployeeByAccount(User account);
	
	User getUserNameByUserName(User account);
	
	User getUserNameByUserName(User account, String usernameSave);
}
