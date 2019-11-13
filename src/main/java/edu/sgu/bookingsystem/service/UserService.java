package edu.sgu.bookingsystem.service;

import java.util.ArrayList;

import edu.sgu.bookingsystem.model.User;
import edu.sgu.bookingsystem.model.UserModel;

public interface UserService {
	
	User checkUser(String username, String password);
	User findUser(String username, String password, long status);
	
	//-----------
	ArrayList<UserModel> getAllUser();
	UserModel getID(long id);
	void insertUser(UserModel u);
	void updateUser(UserModel u);
}
