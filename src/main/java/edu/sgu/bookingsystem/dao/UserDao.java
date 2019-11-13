package edu.sgu.bookingsystem.dao;

import java.util.ArrayList;
import java.util.List;

import edu.sgu.bookingsystem.model.User;
import edu.sgu.bookingsystem.model.UserModel;

public interface UserDao {

	static void initUsers() {
		// TODO Auto-generated method stub	
	}
	User findUser(String username, String password, long status);
	List<User> getAllUserByStatus ();
	User checkUser(String username, String password);
	
	ArrayList<UserModel> getAllUser();
	// TODO Auto-generated method stub
	UserModel getID(long id);
	boolean insertUser(UserModel u);
	boolean updateUser(UserModel u);
}
